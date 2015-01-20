package com.epam.mentoringApp.controllers;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.epam.mentoringApp.dto.AccountDto;
import com.epam.mentoringApp.dto.CurrencyDto;
import com.epam.mentoringApp.dto.CurrencyOperationDto;
import com.epam.mentoringApp.services.AccountService;
import com.epam.mentoringApp.services.CurrencyOperationService;
import com.epam.mentoringApp.services.CurrencyService;

@ControllerAdvice
public class BinderControllerAdvice {
    
    @Autowired 
    private CurrencyEditor currencyEditor;  
    
    @Autowired 
    private CurrencyOperationEditor currencyOperationEditor;  
    
    @Autowired 
    private AccountEditor accountEditor;  
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(CurrencyDto.class, this.currencyEditor);
        binder.registerCustomEditor(CurrencyOperationEditor.class, this.currencyOperationEditor);
        binder.registerCustomEditor(AccountDto.class, this.accountEditor);
    }
    
    @Component
    private static class CurrencyEditor extends PropertyEditorSupport {
        
        @Autowired
        private CurrencyService currencyDao;
        
        @Override
        public String getAsText() {
            if((CurrencyDto)this.getValue() != null){
                Long id = ((CurrencyDto)this.getValue()).getId();
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
    
    @Component
    private static class CurrencyOperationEditor extends PropertyEditorSupport {
        
        @Autowired
        private CurrencyOperationService currencyOperationService;
        
        @Override
        public String getAsText() {
            if((CurrencyOperationDto)this.getValue() != null){
                Long id = ((CurrencyOperationDto)this.getValue()).getId();
                if(id != null){
                    return id.toString();
                }
            }
            return null;
        }
        
        @Override
        public void setAsText(String text) throws IllegalArgumentException 
        {
            this.setValue(currencyOperationService.read(Long.valueOf(text)));
        }
    }
    
    @Component
    private static class AccountEditor extends PropertyEditorSupport {
        
        @Autowired
        private AccountService accountService;
        
        @Override
        public String getAsText() {
            if((AccountDto)this.getValue() != null){
                Long id = ((AccountDto)this.getValue()).getId();
                if(id != null){
                    return id.toString();
                }
            }
            return null;
        }
        
        @Override
        public void setAsText(String text) throws IllegalArgumentException 
        {
            this.setValue(accountService.read(Long.valueOf(text)));
        }
    }
    

}
