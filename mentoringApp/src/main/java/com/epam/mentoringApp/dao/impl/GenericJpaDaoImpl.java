package com.epam.mentoringApp.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
    @Override
    public List<T> list() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        TypedQuery<T> q = entityManager.createQuery(cq.select(cq.from(entityClass)));
        return q.getResultList();
    }
    
    @Override
    public List<T> search(Map<String, Object> criteriaMap) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> p = criteriaQuery.from(entityClass);
        Predicate[] predicate = new Predicate[criteriaMap.size()];
        int index = 0;
        for (String property : criteriaMap.keySet()) {
            Object value = criteriaMap.get(property);
            predicate[index] = criteriaBuilder.equal(p.get(property), value);
            index++;
        }
        criteriaQuery.where(predicate);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Class<T> getEntityClass() {
        return entityClass;
    }

}
