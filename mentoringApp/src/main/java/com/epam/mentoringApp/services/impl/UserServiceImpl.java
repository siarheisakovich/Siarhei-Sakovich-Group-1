package com.epam.mentoringApp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.BaseDao;
import com.epam.mentoringApp.dao.UserDao;
import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.model.User;
import com.epam.mentoringApp.services.UserService;
import com.epam.mentoringApp.services.base.BasicService;

@Service
public class UserServiceImpl extends BasicService<User, Long> implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    protected BaseDao<User, Long> getDao() {
        return userDao;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Account> getUserAccounts(Long userId) {
        User user = userDao.read(userId);
        if(user != null){
            return user.getAccounts();
        }
        return null;
    }
}
