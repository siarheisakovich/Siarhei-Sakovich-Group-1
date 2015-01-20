package com.epam.mentoringApp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoringApp.dao.BaseDao;
import com.epam.mentoringApp.dao.UserDao;
import com.epam.mentoringApp.dto.AccountDto;
import com.epam.mentoringApp.dto.CurrencyDto;
import com.epam.mentoringApp.dto.UserDto;
import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.model.User;
import com.epam.mentoringApp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Transactional(readOnly = true)
    @Override
    public List<AccountDto> getUserAccounts(Long userId) {
        User user = userDao.read(userId);
        if(user != null){
            List<AccountDto> accountDtos = new ArrayList<AccountDto>();
            for (Account account : user.getAccounts()) {
                accountDtos.add(AccountDto.convertToDto(account));
            }
            return accountDtos;
        }
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public UserDto create(UserDto value) {
        User user = UserDto.convertFromDto(value);
        return UserDto.convertToDto(userDao.create(user));
    }

    @Transactional(readOnly = false)
    @Override
    public void update(UserDto value) {
        User user = UserDto.convertFromDto(value);
        userDao.update(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(UserDto value) {
        User user = UserDto.convertFromDto(value);
        userDao.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto read(Long key) {
        return UserDto.convertToDto(userDao.read(key));
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> list() {
        List<User> users = userDao.list();
        List<UserDto> list = new ArrayList<UserDto>();
        for (User user : users) {
            list.add(UserDto.convertToDto(user));
        }
        return list;
    }
    
    
}
