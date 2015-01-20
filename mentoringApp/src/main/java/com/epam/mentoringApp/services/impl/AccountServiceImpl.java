package com.epam.mentoringApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.AccountDao;
import com.epam.mentoringApp.dto.AccountDto;
import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;
    
    @Transactional(readOnly = false)
    @Override
    public AccountDto create(AccountDto value) {
        Account account = AccountDto.convertFromDto(value);
        return AccountDto.convertToDto(dao.create(account));
    }

    @Transactional(readOnly = false)
    @Override
    public void update(AccountDto value) {
        Account account = AccountDto.convertFromDto(value);
        dao.update(account);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(AccountDto value) {        
        Account account = AccountDto.convertFromDto(value);
        dao.delete(account);
    }

    @Transactional(readOnly = true)
    @Override
    public AccountDto read(Long key) {
        return AccountDto.convertToDto(dao.read(key));
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDto> list() {
        List<Account> accounts = dao.list();
        List<AccountDto> list = new ArrayList<AccountDto>();
        for (Account account : accounts) {
            list.add(AccountDto.convertToDto(account));
        }
        return list;
    }
}
