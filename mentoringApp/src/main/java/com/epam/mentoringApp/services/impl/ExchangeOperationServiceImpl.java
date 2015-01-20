package com.epam.mentoringApp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentoringApp.dao.BaseDao;
import com.epam.mentoringApp.dao.ExchangeOperationDao;
import com.epam.mentoringApp.model.ExchangeOperation;
import com.epam.mentoringApp.services.ExchangeOperationService;
import com.epam.mentoringApp.services.base.BasicService;

@Service
public class ExchangeOperationServiceImpl extends BasicService<ExchangeOperation, Long> implements ExchangeOperationService {

    @Autowired
    private ExchangeOperationDao dao;
    
    @Override
    protected BaseDao<ExchangeOperation, Long> getDao() {
        return dao;
    }
}
