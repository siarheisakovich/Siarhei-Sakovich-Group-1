package com.epam.mentoringApp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentoringApp.dto.CurrencyOperationDto;
import com.epam.mentoringApp.dto.ExchangeOperationDto;
import com.epam.mentoringApp.dto.UserDto;
import com.epam.mentoringApp.security.UserPrinical;
import com.epam.mentoringApp.services.CurrencyOperationService;
import com.epam.mentoringApp.services.ExchangeOperationService;
import com.epam.mentoringApp.services.UserService;

@Controller
@RequestMapping
public class ExchangeController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ExchangeOperationService exchangeOperationService;
    
    @Autowired
    private CurrencyOperationService currencyOperationService;
    
    @RequestMapping(value="/exchange", method = RequestMethod.GET)
    public String currencyOperation(HttpSession session, Model model) {
        UserPrinical userPrinical = UserPrinical.get();
        UserDto userDto = userService.read(userPrinical.getId());
        List<ExchangeOperationDto> exchangeOperations = exchangeOperationService.findByUser(userDto);        
        model.addAttribute("exchangeOperations", exchangeOperations);
        model.addAttribute("currencyOperations", currencyOperationService.list());
        return "currencyOperationsForm";
    }
    
    @RequestMapping(value="/exchange/{currencyOperationId}", method = RequestMethod.GET)
    public String list(@PathVariable Long currencyOperationId, Model model) {
        CurrencyOperationDto currencyOperationDto = currencyOperationService.read(currencyOperationId);
        if(currencyOperationDto != null){
            UserPrinical userPrinical = UserPrinical.get();
            
            model.addAttribute("accounts", userService.getUserAccounts(userPrinical.getId()));
            model.addAttribute("exchangeOperation", new ExchangeOperationDto());
            return "exchangeForm";
        }
        return "redirect:/exchange";
    }
    
    @RequestMapping(value="/exchange/{currencyOperationId}", method = RequestMethod.POST)
    public String addOrUpdate(@PathVariable Long currencyOperationId, @ModelAttribute("exchangeOperation") ExchangeOperationDto exchangeOperation){
        CurrencyOperationDto currencyOperationDto = currencyOperationService.read(currencyOperationId);
        if(currencyOperationDto != null){
            UserPrinical userPrinical = UserPrinical.get();
            Long userId = userPrinical.getId();
            UserDto user = userService.read(userId);
            exchangeOperationService.exchange(exchangeOperation.getFromAccount(),
                    exchangeOperation.getToAccount(), currencyOperationDto,
                    exchangeOperation.getAmount(), user);
            return "redirect:/exchange/"+ currencyOperationId;
        }
        return "redirect:/exchange";
    }
}