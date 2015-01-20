package com.epam.mentoringApp.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.model.User;

public class UserDto {

    private Long id;

    private String login;

    private String password;

    private List<AccountDto> accounts;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). 
            append(id).
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof UserDto))
            return false;
        if (obj == this)
            return true;

        UserDto rhs = (UserDto) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
    
    public static User convertFromDto(UserDto from) {
        if (from != null) {
            User user = new User();
            List<AccountDto> list = from.getAccounts();
            if(list != null){
                List<Account> accounts = new ArrayList<Account>();
                for (AccountDto fromAccount : list) {
                    accounts.add(AccountDto.convertFromDto(fromAccount));
                }
                user.setAccounts(accounts);
            }
            user.setId(from.getId());
            user.setLogin(from.getLogin());
            user.setPassword(from.getPassword());
            return user;
        }
        return null;
    }

    public static UserDto convertToDto(User from) {
        if (from != null) {
            UserDto user = new UserDto();
            List<Account> list = from.getAccounts();
            if(list != null){
                List<AccountDto> accounts = new ArrayList<AccountDto>();
                for (Account fromAccount : from.getAccounts()) {
                    accounts.add(AccountDto.convertToDto(fromAccount));
                }
                user.setAccounts(accounts);
            }
            user.setId(from.getId());
            user.setLogin(from.getLogin());
            user.setPassword(from.getPassword());
            return user;
        }
        return null;
    }
}
