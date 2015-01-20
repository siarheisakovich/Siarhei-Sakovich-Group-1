package com.epam.mentoringApp.services;

import java.util.List;

import com.epam.mentoringApp.dto.AccountDto;
import com.epam.mentoringApp.dto.UserDto;
import com.epam.mentoringApp.model.User;

public interface UserService extends IBasicService<User, UserDto, Long>{

    List<AccountDto> getUserAccounts(Long userId);
}
