package com.epam.mentoringApp.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.mentoringApp.dao.UserDao;
import com.epam.mentoringApp.model.User;
import com.epam.mentoringApp.services.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

    @Autowired(required = true)
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {        
        User user = userDao.loadUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No user with username '" + username + "' found!");
        }
        //TODO
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        for (Privilege p : user.getPrivileges()) {
            roles.add(new GrantedAuthorityImpl(p.getName()));
        }
        // initialize user
        SecurityUser securityUser = new SecurityUser(
            user.getUsername(),
            user.getLdapAuth() ? getLdapPassword(user.getUsername()) : user.getPassword(),
            user.getStatus() != User.Status.NOT_COMMITED, user.getStatus() != User.Status.BLOCKED, true, true,
            roles.toArray(new GrantedAuthority[0])
        );

        securityUser.setUser(user);

        return securityUser;
    }

}
