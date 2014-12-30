package com.epam.mentoringApp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.mentoringApp.dao.UserDao;
import com.epam.mentoringApp.model.User;

public class UserDaoImpl extends GenericJpaDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User loadUserByUsername(String username) {
        Map<String, Object> criteriaMap = new HashMap<String, Object>();
        criteriaMap.put("login", username);
        List<User> users = search(criteriaMap);
        if(users.size() > 0){
            return users.get(0);
        }
        return null;
    }

}
