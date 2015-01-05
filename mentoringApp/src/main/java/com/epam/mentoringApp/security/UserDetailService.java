package com.epam.mentoringApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.mentoringApp.dao.UserDao;
import com.epam.mentoringApp.model.User;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired(required = true)
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user with username '"
                    + username + "' found!");
        }
        com.epam.mentoringApp.security.User securityUser = new com.epam.mentoringApp.security.User(user);
        return securityUser;
    }

}
