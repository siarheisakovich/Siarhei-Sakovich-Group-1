package com.epam.mentoringApp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentoringApp.dao.BaseDao;
import com.epam.mentoringApp.dao.CurrencyOperationDao;
import com.epam.mentoringApp.model.CurrencyOperation;
import com.epam.mentoringApp.services.CurrencyOperationService;
import com.epam.mentoringApp.services.base.BasicService;

@Service
public class CurrencyOperationServiceImpl extends BasicService<CurrencyOperation, Long> implements CurrencyOperationService {

    @Autowired
    private CurrencyOperationDao dao;
    
    @Override
    protected BaseDao<CurrencyOperation, Long> getDao() {
        return dao;
    }
}
