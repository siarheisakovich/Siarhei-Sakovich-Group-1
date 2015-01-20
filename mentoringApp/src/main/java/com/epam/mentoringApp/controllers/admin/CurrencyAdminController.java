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

import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.services.CurrencyService;

@Controller
public class CurrencyAdminController {
    private static final Logger logger = Logger.getLogger(CurrencyAdminController.class);

    @Autowired
    private CurrencyService service;
    
    @RequestMapping(value="/admin/currencies", method = RequestMethod.GET)
    public String list(Model model) {
        List<Currency> list = service.list();
        model.addAttribute("item", new Currency());
        model.addAttribute("list", list);

        return "currencies";
    }
    
    @RequestMapping(value="/admin/currencies", method = RequestMethod.POST)
    public String add(@ModelAttribute("currency") Currency currency){         
        if (currency.getId() == null) {
            this.service.create(currency);
        } else {
            this.service.update(currency);
        }
        return "redirect:/admin/currencies";
    }
    
    @RequestMapping(value="/admin/currencies/{id}", method = RequestMethod.GET)
    public String detailView(Model model, @PathVariable Long id) {
        Currency currency = service.read(id);
        model.addAttribute("item", currency);        
        return "currencyDetails";
    }
    
//    @RequestMapping("/remove/{id}")
//    public String removePerson(@PathVariable("id") int id){
//         
//        this.personService.removePerson(id);
//        return "redirect:/persons";
//    }

}