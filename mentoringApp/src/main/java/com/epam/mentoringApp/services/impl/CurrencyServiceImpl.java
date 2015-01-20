package com.epam.mentoringApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.CurrencyDao;
import com.epam.mentoringApp.dto.CurrencyDto;
import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.services.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao dao;

    @Transactional(readOnly = false)
    @Override
    public CurrencyDto create(CurrencyDto value) {
        Currency currency = CurrencyDto.convertFromDto(value);
        return CurrencyDto.convertToDto(dao.create(currency));
    }

    @Transactional(readOnly = false)
    @Override
    public void update(CurrencyDto value) {
        Currency currency = CurrencyDto.convertFromDto(value);
        dao.update(currency);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(CurrencyDto value) {
        Currency currency = CurrencyDto.convertFromDto(value);
        dao.delete(currency);
    }

    @Transactional(readOnly = true)
    @Override
    public CurrencyDto read(Long key) {
        return CurrencyDto.convertToDto(dao.read(key));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CurrencyDto> list() {
        List<Currency> currencies = dao.list();
        List<CurrencyDto> list = new ArrayList<CurrencyDto>();
        for (Currency currency : currencies) {
            list.add(CurrencyDto.convertToDto(currency));
        }
        return list;
    }
    
}
