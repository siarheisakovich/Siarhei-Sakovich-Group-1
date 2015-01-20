package com.epam.mentoringApp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentoringApp.dao.AccountDao;
import com.epam.mentoringApp.dao.BaseDao;
import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.services.AccountService;
import com.epam.mentoringApp.services.base.BasicService;

@Service
public class AccountServiceImpl extends BasicService<Account, Long> implements AccountService {

    @Autowired
    private AccountDao dao;
    
    @Override
    protected BaseDao<Account, Long> getDao() {
        return dao;
    }
}
