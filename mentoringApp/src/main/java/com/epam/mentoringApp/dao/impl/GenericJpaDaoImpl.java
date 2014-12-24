package com.epam.mentoringApp.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epam.mentoringApp.dao.GenericJpaDao;

@Repository
public abstract class GenericJpaDaoImpl<T, PK extends Serializable> implements
        GenericJpaDao<T, PK> {

    protected Class<T> entityClass;

    protected EntityManager entityManager;

    public GenericJpaDaoImpl(Class<T> clazz) {
        this.entityClass = clazz;
    }

    @Override
    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Override
    public T read(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
