package com.epam.mentoringApp.dao;

import com.epam.mentoringApp.model.User;

public interface UserDao extends BaseDao<User, Long>{

    User loadUserByUsername(String username);
}
