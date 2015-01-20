package com.epam.mentoringApp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentoringApp.dao.BaseDao;
import com.epam.mentoringApp.dao.CurrencyDao;
import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.services.CurrencyService;
import com.epam.mentoringApp.services.base.BasicService;

@Service
public class CurrencyServiceImpl extends BasicService<Currency, Long> implements CurrencyService {

    @Autowired
    private CurrencyDao dao;
    
    @Override
    protected BaseDao<Currency, Long> getDao() {
        return dao;
    }
}
