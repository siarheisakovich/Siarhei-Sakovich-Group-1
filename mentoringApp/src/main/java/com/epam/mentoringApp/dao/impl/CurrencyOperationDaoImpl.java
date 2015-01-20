package com.epam.mentoringApp.dao.impl;

import org.springframework.stereotype.Repository;

import com.epam.mentoringApp.dao.CurrencyOperationDao;
import com.epam.mentoringApp.model.CurrencyOperation;

@Repository
public class CurrencyOperationDaoImpl extends GenericJpaDaoImpl<CurrencyOperation, Long> implements
        CurrencyOperationDao {

    public CurrencyOperationDaoImpl() {
        super(CurrencyOperation.class);
    }

}
