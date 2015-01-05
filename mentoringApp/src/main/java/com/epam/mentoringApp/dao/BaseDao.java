package com.epam.mentoringApp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T, PK extends Serializable> {
    
    Class<? extends T> getEntityClass();
    
    T create(T t);

    T read(PK id);

    T update(T t);

    void delete(T t);
    
    List<T> list();
    
    List<T> search(Map<String, Object> criteriaMap);
}
