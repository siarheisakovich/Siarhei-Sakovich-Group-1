package com.epam.mentoringApp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
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

    @Column(nullable = false)
    public String getLogin() {
        return login;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    @OneToMany
    @JoinTable(name = "user_account", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "id", unique = true) })
    public List<Account> getAccounts() {
        return accounts;
    }
}
