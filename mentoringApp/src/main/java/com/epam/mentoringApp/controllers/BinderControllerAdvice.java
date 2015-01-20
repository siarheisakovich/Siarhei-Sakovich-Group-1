package com.epam.mentoringApp.controllers;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.epam.mentoringApp.dao.CurrencyDao;
import com.epam.mentoringApp.dto.CurrencyDto;
import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.services.CurrencyService;

@ControllerAdvice
public class BinderControllerAdvice {
    
    @Autowired 
    private CurrencyEditor currencyEditor;  
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(CurrencyDto.class, this.currencyEditor);
    }
    
    @Component
    private static class CurrencyEditor extends PropertyEditorSupport {
        
        @Autowired
        private CurrencyService currencyDao;
        
        @Override
        public String getAsText() {
            if((Currency)this.getValue() != null){
                Long id = ((Currency)this.getValue()).getId();
                if(id != null){
                    return id.toString();
                }
            }
            return null;
        }
        
        @Override
        public void setAsText(String text) throws IllegalArgumentException 
        {
            this.setValue(currencyDao.read(Long.valueOf(text)));
        }
    }
    

}
