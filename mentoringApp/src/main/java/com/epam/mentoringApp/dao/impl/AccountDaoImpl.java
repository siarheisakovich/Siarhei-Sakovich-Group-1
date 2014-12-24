package com.epam.mentoringApp.dao.impl;

import org.springframework.stereotype.Repository;

import com.epam.mentoringApp.dao.AccountDao;
import com.epam.mentoringApp.model.Account;

@Repository
public class AccountDaoImpl extends GenericJpaDaoImpl<Account, Long> implements
        AccountDao {

    public AccountDaoImpl() {
        super(Account.class);
    }

}
