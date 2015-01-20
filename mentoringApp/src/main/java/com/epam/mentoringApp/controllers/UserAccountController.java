package com.epam.mentoringApp.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentoringApp.dto.AccountDto;
import com.epam.mentoringApp.dto.CurrencyDto;
import com.epam.mentoringApp.dto.UserDto;
import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.model.User;
import com.epam.mentoringApp.security.UserPrinical;
import com.epam.mentoringApp.services.CurrencyService;
import com.epam.mentoringApp.services.UserService;

@Controller
@RequestMapping
public class UserAccountController {
    private static final Logger logger = Logger.getLogger(UserAccountController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private CurrencyService currencyService;
    
    @RequestMapping(value="/accounts", method = RequestMethod.GET)
    public String list(Model model) {
        UserPrinical userPrinical = UserPrinical.get();
        List<CurrencyDto> currencies = currencyService.list();
        model.addAttribute("currencies", currencies);
        model.addAttribute("list", userService.getUserAccounts(userPrinical.getId()));
        model.addAttribute("account", new AccountDto());
        return "accounts";
    }
    
    @RequestMapping(value="/accounts", method = RequestMethod.POST)
    public String addOrUpdate(@ModelAttribute("account") AccountDto account){         
        UserPrinical userPrinical = UserPrinical.get();
        Long id = userPrinical.getId();
        UserDto user = userService.read(id);
        List<AccountDto> accounts = userService.getUserAccounts(userPrinical.getId());
        accounts.add(account);
        user.setAccounts(accounts);
        userService.update(user);
        return "redirect:/accounts";
    }
}