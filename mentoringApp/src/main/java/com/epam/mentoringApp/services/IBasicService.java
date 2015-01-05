package com.epam.mentoringApp.services;

import java.io.Serializable;
import java.util.List;

public interface IBasicService<T, PK extends Serializable> {

    Class<? extends T> getEntityClass();
    
    T create(T value);
    
    void update(T value);

    void delete(T value);
    
    T read(PK key);
    
    List<T> list();
}
