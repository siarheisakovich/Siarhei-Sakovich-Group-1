package com.epam.mentoringApp.dao;

import java.io.Serializable;

public interface GenericJpaDao<T, PK extends Serializable> {
    T create(T t);

    T read(PK id);

    T update(T t);

    void delete(T t);
}
