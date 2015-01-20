package com.epam.mentoringApp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserPrinical extends org.springframework.security.core.userdetails.User {
    
    private static final long serialVersionUID = 1L;
    private Long id;
    
    private static List<GrantedAuthority> predefinedAuthorities;
    static {
        // add USER_ROLE to all users as predefined
        predefinedAuthorities = new ArrayList<GrantedAuthority>();
        predefinedAuthorities.add( new SimpleGrantedAuthority("ROLE_USER"));
    }
    
    public UserPrinical(com.epam.mentoringApp.model.User user) {
        super(user.getLogin(), user.getPassword(), true, true, true, true, predefinedAuthorities);
        this.id = user.getId();
    }

    /**
     * Returns user id
     * 
     * @return user id
     */
    public Long getId() {
        return id;
    }
    
    public static UserPrinical get() {
        return (UserPrinical) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

