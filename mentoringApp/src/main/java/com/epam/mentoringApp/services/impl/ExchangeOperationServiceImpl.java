package com.epam.mentoringApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.ExchangeOperationDao;
import com.epam.mentoringApp.dto.CurrencyDto;
import com.epam.mentoringApp.dto.ExchangeOperationDto;
import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.model.ExchangeOperation;
import com.epam.mentoringApp.services.ExchangeOperationService;

@Service
public class ExchangeOperationServiceImpl implements ExchangeOperationService {

    @Autowired
    private ExchangeOperationDao dao;

    @Transactional(readOnly = false)
    @Override
    public ExchangeOperationDto create(ExchangeOperationDto value) {
        ExchangeOperation exchangeOperation = ExchangeOperationDto.convertFromDto(value);
        return ExchangeOperationDto.convertToDto(dao.create(exchangeOperation));
    }

    @Transactional(readOnly = false)
    @Override
    public void update(ExchangeOperationDto value) {
        dao.update(ExchangeOperationDto.convertFromDto(value));
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(ExchangeOperationDto value) {
        dao.delete(ExchangeOperationDto.convertFromDto(value));
    }

    @Transactional(readOnly = true)
    @Override
    public ExchangeOperationDto read(Long key) {
        return ExchangeOperationDto.convertToDto(dao.read(key));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExchangeOperationDto> list() {
        List<ExchangeOperation> exchangeOperations = dao.list();
        List<ExchangeOperationDto> list = new ArrayList<ExchangeOperationDto>();
        for (ExchangeOperation exchangeOperation : exchangeOperations) {
            list.add(ExchangeOperationDto.convertToDto(exchangeOperation));
        }
        return list;
    }
    
}
