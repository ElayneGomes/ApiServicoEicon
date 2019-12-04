package br.com.exemplo.eicon.repository;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public abstract class BaseHibernateRepository {

    @Autowired
    private EntityManager entityManager;

    protected Session getSession() {
        Session session = (Session) entityManager.getDelegate();
        session.setHibernateFlushMode(FlushMode.COMMIT);
        return session;
    }
}
