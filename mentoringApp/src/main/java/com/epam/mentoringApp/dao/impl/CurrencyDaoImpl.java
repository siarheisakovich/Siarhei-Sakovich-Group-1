package com.epam.mentoringApp.dao.impl;

import org.springframework.stereotype.Repository;

import com.epam.mentoringApp.dao.CurrencyDao;
import com.epam.mentoringApp.model.Currency;

@Repository
public class CurrencyDaoImpl extends GenericJpaDaoImpl<Currency, Long> implements
        CurrencyDao {

    public CurrencyDaoImpl() {
        super(Currency.class);
    }

}
