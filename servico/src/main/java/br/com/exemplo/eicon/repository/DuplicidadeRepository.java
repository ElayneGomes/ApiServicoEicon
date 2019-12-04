package br.com.exemplo.eicon.repository;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import br.com.exemplo.eicon.annotation.VerificaDuplicidade;
import net.vidageek.mirror.dsl.Mirror;
import net.vidageek.mirror.list.dsl.MirrorList;

@Repository
public class DuplicidadeRepository {

    private final EntityManager entityManager;

    @Autowired
    public DuplicidadeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private Session getSession() {
        Session session = (Session) entityManager.getDelegate();
        session.setHibernateFlushMode(FlushMode.COMMIT);
        return session;
    }

    public boolean verificarDuplicidade(Object entidade) {
        final StringBuilder hql = new StringBuilder(
                "SELECT count(e) FROM " + entidade.getClass().getName() + " e WHERE 1=1");
        Map<String, Object> atributosParaVerificacao = getAtributosParaVerificacao(entidade);
        if (!CollectionUtils.isEmpty(atributosParaVerificacao)) {
            atributosParaVerificacao.forEach((chave, valor) -> hql.append(" AND UPPER(e.").append(chave).append(") = ")
                    .append("UPPER('").append(valor).append("') "));
            Long id = (Long) atributosParaVerificacao.get("id");
            if(id != null){
                hql.append("e.id != "+id);
            }
        } else {
            return false;
        }
        Pair<String, Object> id = getId(entidade);
        if (id != null && id.getValue() != null) {
            hql.append(" AND e.").append(id.getKey()).append("!=").append(id.getValue());
        }
        Query query = getSession().createQuery(hql.toString());
        Long cont = (Long) query.uniqueResult();
        return cont > 0;
    }

    private Map<String, Object> getAtributosParaVerificacao(Object entidade) {
        final MirrorList<Field> fields = new Mirror().on(entidade.getClass()).reflectAll().fields()
                .matching(element -> element.isAnnotationPresent(VerificaDuplicidade.class));
        if (!CollectionUtils.isEmpty(fields)) {
            Map<String, Object> retorno = new HashMap<>(fields.size());
            fields.forEach(field -> retorno.put(field.getName(), new Mirror().on(entidade).get().field(field)));
            return retorno;
        }
        return Collections.emptyMap();
    }

    private Pair<String, Object> getId(Object entidade) {
        MirrorList<Field> matching = new Mirror().on(entidade.getClass()).reflectAll().fields()
                .matching(element -> element.isAnnotationPresent(Id.class) &&
                        !element.isAnnotationPresent(VerificaDuplicidade.class));
        if (!CollectionUtils.isEmpty(matching)) {
            Field field = matching.get(0);
            return new ImmutablePair<>(field.getName(), new Mirror().on(entidade).get().field(field));
        }
        return ImmutablePair.nullPair();
    }
}
