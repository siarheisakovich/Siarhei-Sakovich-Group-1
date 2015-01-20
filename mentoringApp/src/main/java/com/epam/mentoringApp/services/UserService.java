package com.epam.mentoringApp.services;

import java.util.List;

import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.model.User;

public interface UserService extends IBasicService<User, Long>{

    List<Account> getUserAccounts(Long userId);
}
