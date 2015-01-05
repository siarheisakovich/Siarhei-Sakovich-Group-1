package com.epam.mentoringApp.services.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.BaseDao;
import com.epam.mentoringApp.services.IBasicService;

public abstract class BasicService<T, PK extends Serializable> implements IBasicService<T, PK>{

    public Class<? extends T> getEntityClass() {
        return getDao().getEntityClass();
    }
    
    @Transactional(readOnly = false)
    public T create(T value) {
        return getDao().create(value);
    }
    
    @Transactional(readOnly = false)
    public void update(T value) {
        getDao().update(value);
    }

    @Transactional(readOnly = false)
    public void delete(T value) {
        getDao().delete(value);
    }
    
    @Transactional(readOnly = true)
    public T read(PK key) {
        return getDao().read(key);
    }
    
    @Transactional(readOnly = true)
    public List<T> list() {
        return getDao().list();
    }
    
    protected abstract BaseDao<T, PK> getDao();
    
}
