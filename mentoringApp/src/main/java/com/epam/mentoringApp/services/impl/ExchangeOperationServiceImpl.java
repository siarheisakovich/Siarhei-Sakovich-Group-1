package com.epam.mentoringApp.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.AccountDao;
import com.epam.mentoringApp.dao.CurrencyOperationDao;
import com.epam.mentoringApp.dao.ExchangeOperationDao;
import com.epam.mentoringApp.dao.UserDao;
import com.epam.mentoringApp.dto.AccountDto;
import com.epam.mentoringApp.dto.CurrencyOperationDto;
import com.epam.mentoringApp.dto.ExchangeOperationDto;
import com.epam.mentoringApp.dto.UserDto;
import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.model.CurrencyOperation;
import com.epam.mentoringApp.model.ExchangeOperation;
import com.epam.mentoringApp.model.User;
import com.epam.mentoringApp.services.ExchangeOperationService;

@Service
public class ExchangeOperationServiceImpl implements ExchangeOperationService {

    @Autowired
    private ExchangeOperationDao dao;
    
    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private CurrencyOperationDao currencyOperationDao;
    
    @Autowired
    private UserDao userDao;

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

    @Transactional(readOnly = true)
    @Override
    public List<ExchangeOperationDto> findByUser(UserDto user) {
        List<ExchangeOperation> exchangeOperations = dao.findByUser(UserDto.convertFromDto(user));
        if(exchangeOperations != null){
            List<ExchangeOperationDto> list = new ArrayList<ExchangeOperationDto>();
            for (ExchangeOperation exchangeOperation : exchangeOperations) {
                list.add(ExchangeOperationDto.convertToDto(exchangeOperation));
            }
            return list;
        }
        return null;
    }
    
    @Transactional(readOnly = false)
    @Override
    public void exchange(AccountDto fromAccountDto, AccountDto toAccountDto, CurrencyOperationDto currencyOperationDto, BigDecimal amount, UserDto userDto) {
        Account fromAccount = accountDao.read(fromAccountDto.getId());
        Account toAccount = accountDao.read(toAccountDto.getId());
        User user = userDao.read(userDto.getId());
        CurrencyOperation currencyOperation = currencyOperationDao.read(currencyOperationDto.getId());
        if(isValidAccounts(fromAccount, toAccount) && isValidCurrencyOperation(currencyOperation) && isEnoughtAmount(fromAccount, amount) && isValidAccountCurrencies(fromAccount, toAccount, currencyOperation)){
            exchange(fromAccount, toAccount, currencyOperation, amount, user);
        } 
    }
    
    private void exchange(Account fromAccount, Account toAccount, CurrencyOperation currencyOperation, BigDecimal amount, User user){
        BigDecimal first = fromAccount.getAmount();
        fromAccount.setAmount(first.subtract(amount));
        BigDecimal second = toAccount.getAmount();
        BigDecimal fromCoef = currencyOperation.getFromCoefficent();
        BigDecimal toCoef = currencyOperation.getToCoefficent();
        toAccount.setAmount(second.add(amount.divide(fromCoef).multiply(toCoef)));
        accountDao.update(fromAccount);
        accountDao.update(toAccount);
        ExchangeOperation exchangeOperation = new ExchangeOperation();
        exchangeOperation.setAmount(amount);
        exchangeOperation.setFromAccount(fromAccount);
        exchangeOperation.setToAccount(toAccount);
        exchangeOperation.setUser(user);
        exchangeOperation.setFromCoefficent(fromCoef);
        exchangeOperation.setToCoefficent(toCoef);
        dao.create(exchangeOperation);
    }
    
    private boolean isValidAccounts(Account fromAccount, Account toAccount){
        return fromAccount != null && toAccount != null;
    }
    
    private boolean isValidCurrencyOperation(CurrencyOperation currencyOperation){
        return currencyOperation != null;
    }
    
    private boolean isEnoughtAmount(Account fromAccount, BigDecimal amount){
        return fromAccount.getAmount().compareTo(amount) >= 0;
    }
    
    private boolean isValidAccountCurrencies(Account fromAccount, Account toAccount, CurrencyOperation currencyOperation){
        return ObjectUtils.equals(fromAccount.getCurrency(), currencyOperation.getFromCurrency()) && ObjectUtils.equals(toAccount.getCurrency(), currencyOperation.getToCurrency());
    }
}
