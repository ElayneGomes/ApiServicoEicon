package br.com.exemplo.eicon.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import br.com.exemplo.eicon.repository.JpaBaseRepository;
import br.com.exemplo.eicon.service.IBaseService;
import br.com.exemplo.eicon.service.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Implementação genérica para métodos comuns que serão utilizados pelos serviços (Services)
 *
 * @param <ENTITY> Entidade relacional persistente
 * @param <DTO> Data Transfer Object utilizado para trafegar os dados
 * @param <PK> Primary Key, tipo do objeto utilizado como primary key (Ex: Long, Integer, etc)
 */
@Transactional
public abstract class BaseServiceImpl<ENTITY, DTO, PK extends Serializable> implements IBaseService<DTO, PK> {


    protected abstract JpaBaseRepository<ENTITY, PK> getRepository();

    protected abstract EntityMapper<DTO, ENTITY> getMapper();


    @Override
    public DTO buscarPorId(PK id) {
        Optional<ENTITY> optional = getRepository().findById( id);
        return optional.map(diligencia -> getMapper().toDto(diligencia))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List getAll() {
        return getRepository().findAll();
    }

    @Override
    public Page getPageable(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public DTO salvar(@Valid DTO t) {
        this.doSalvar();
        return getMapper().toDto(getRepository().save(getMapper().toEntity(t)));
    }

    /**
     * Sobrescrever este método caso necessite realizar ação antes de salvar
     */
    public void doSalvar(){}

    @Override
    public DTO editar(@Valid DTO t) {
        return null;
    }

    @Override
    public void apagar(PK id) {

    }

    public Page<DTO> pesquisar(DTO dto, Pageable pageable) {
        return getEspecificacao(dto) != null ? getRepository().findAll(getEspecificacao(dto), pageable).map(this::getRetornoPesquisa)
                : getRepository().findAll(pageable).map(this::getRetornoPesquisa);
    }

    /**
     * Metodo deverá ser sobrescrito em caso de necessidade de criação de especificação para a pesquisa
     *
     * @return
     */
    protected Specification<ENTITY> getEspecificacao(DTO dto){
        return null;
    }

    /**
     * Método deverá ser sobrescrito em caso de necessidade de customização do retorno da pesquisa
     *
     * @param entity - Entidade Relacional persistente
     * @return DTO - Objeto convertido para DTO
     */
    protected DTO getRetornoPesquisa(ENTITY entity){
        return getMapper().toDto(entity);
    }


}
