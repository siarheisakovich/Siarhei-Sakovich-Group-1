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
import javax.persistence.TableGenerator;

@Entity
public class User {

    private Long id;

    private String login;

    private String password;

    private List<Account> accounts;

    @TableGenerator(
            name="userGen",
            table="USER_ID_GEN",
            pkColumnName="GEN_KEY",
            valueColumnName="GEN_VALUE",
            pkColumnValue="USER_ID",
            allocationSize=1)
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="userGen")
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
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
