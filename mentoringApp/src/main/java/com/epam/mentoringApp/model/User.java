package com.epam.mentoringApp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(allocationSize = 100, name = "USER_SEQ")
public class User {
    
    private Long id;
    
    private String login;
    
    private String password;
    
    private List<Account> accounts;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    public Long getId() {
        return id;
    }
    
    @Column
    public String getLogin() {
        return login;
    }
    
    @Column
    public String getPassword() {
        return password;
    }
    
    @OneToMany
    @
    public List<Account> getAccounts() {
        return accounts;
    }
}
