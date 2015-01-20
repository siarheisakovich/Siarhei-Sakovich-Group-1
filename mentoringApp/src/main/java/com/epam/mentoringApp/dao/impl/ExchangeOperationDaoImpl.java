package com.epam.mentoringApp.dao.impl;

import org.springframework.stereotype.Repository;

import com.epam.mentoringApp.dao.ExchangeOperationDao;
import com.epam.mentoringApp.model.ExchangeOperation;

@Repository
public class ExchangeOperationDaoImpl extends GenericJpaDaoImpl<ExchangeOperation, Long> implements
        ExchangeOperationDao {

    public ExchangeOperationDaoImpl() {
        super(ExchangeOperation.class);
    }

}
