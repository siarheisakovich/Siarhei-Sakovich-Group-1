package com.epam.mentoringApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.CurrencyOperationDao;
import com.epam.mentoringApp.dto.CurrencyOperationDto;
import com.epam.mentoringApp.model.CurrencyOperation;
import com.epam.mentoringApp.services.CurrencyOperationService;

@Service
public class CurrencyOperationServiceImpl implements CurrencyOperationService {

    @Autowired
    private CurrencyOperationDao dao;

    @Transactional(readOnly = false)
    @Override
    public CurrencyOperationDto create(CurrencyOperationDto value) {
        CurrencyOperation currencyOperation = CurrencyOperationDto.convertFromDto(value);
        return CurrencyOperationDto.convertToDto(dao.create(currencyOperation));
    }

    @Transactional(readOnly = false)
    @Override
    public void update(CurrencyOperationDto value) {
        CurrencyOperation currencyOperation = CurrencyOperationDto.convertFromDto(value);
        dao.update(currencyOperation);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(CurrencyOperationDto value) {        
        CurrencyOperation currencyOperation = CurrencyOperationDto.convertFromDto(value);
        dao.delete(currencyOperation);
    }

    @Transactional(readOnly = true)
    @Override
    public CurrencyOperationDto read(Long key) {
        return CurrencyOperationDto.convertToDto(dao.read(key));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CurrencyOperationDto> list() {
        List<CurrencyOperation> currencyOperations = dao.list();
        List<CurrencyOperationDto> list = new ArrayList<CurrencyOperationDto>();
        for (CurrencyOperation currencyOperation : currencyOperations) {
            list.add(CurrencyOperationDto.convertToDto(currencyOperation));
        }
        return list;
    }
}
