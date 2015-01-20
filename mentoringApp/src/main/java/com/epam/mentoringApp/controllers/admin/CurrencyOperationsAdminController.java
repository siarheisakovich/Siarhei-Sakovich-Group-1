package com.epam.mentoringApp.controllers.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentoringApp.dto.CurrencyDto;
import com.epam.mentoringApp.dto.CurrencyOperationDto;
import com.epam.mentoringApp.services.CurrencyOperationService;
import com.epam.mentoringApp.services.CurrencyService;

@Controller
public class CurrencyOperationsAdminController {
    private static final Logger logger = Logger.getLogger(CurrencyOperationsAdminController.class);

    @Autowired
    private CurrencyOperationService service;
    
    @Autowired
    private CurrencyService currencyService;
    
    @RequestMapping(value="/admin/currencyOperations", method = RequestMethod.GET)
    public String list(Model model) {
        logger.debug("printHello");
        List<CurrencyOperationDto> list = service.list();
        List<CurrencyDto> currencies = currencyService.list();
        model.addAttribute("currencies", currencies);
        model.addAttribute("currencyOperation", new CurrencyOperationDto());
        model.addAttribute("list", list);

        return "currencyOperations";
    }
    
    @RequestMapping(value="/admin/currencyOperations", method = RequestMethod.POST)
    public String add(@ModelAttribute("currencyOperation") CurrencyOperationDto currencyOperation){         
        if (currencyOperation.getId() == null) {
            this.service.create(currencyOperation);
        } else {
            this.service.update(currencyOperation);
        }
        return "redirect:/admin/currencyOperations";
    }
    
    @RequestMapping(value="/admin/currencyOperations/{id}", method = RequestMethod.GET)
    public String detailView(Model model, @PathVariable Long id) {
        CurrencyOperationDto currencyOperation = service.read(id);
        List<CurrencyDto> currencies = currencyService.list();
        model.addAttribute("currencies", currencies);
        model.addAttribute("currencyOperation", currencyOperation);        
        return "currencyOperationDetails";
    }
}