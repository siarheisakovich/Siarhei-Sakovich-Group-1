package com.epam.mentoringApp.dto;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.mentoringApp.model.Account;
import com.epam.mentoringApp.model.Currency;

public class AccountDto {
    
    private Long id;

    private CurrencyDto currency;

    private BigDecimal amount;
    
    public Long getId() {
        return id;
    }

    public CurrencyDto getCurrency() {
        return currency;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public void setCurrency(CurrencyDto currency) {
        this.currency = currency;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). 
            append(id).
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof AccountDto))
            return false;
        if (obj == this)
            return true;

        AccountDto rhs = (AccountDto) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
    
    public static AccountDto convertToDto(Account from) {
        if (from != null) {
            CurrencyDto currencyDto = new CurrencyDto();
            currencyDto.setId(from.getCurrency().getId());
            currencyDto.setIsoCode(from.getCurrency().getIsoCode());
            currencyDto.setTitle(from.getCurrency().getTitle());
            AccountDto accountDto = new AccountDto();
            accountDto.setId(from.getId());
            accountDto.setCurrency(currencyDto);
            accountDto.setAmount(from.getAmount());
            return accountDto;
        }
        return null;
    }

    public static Account convertFromDto(AccountDto from) {
        if (from != null) {
            Currency toCurrency = new Currency();
            toCurrency.setId(from.getCurrency().getId());
            toCurrency.setIsoCode(from.getCurrency().getIsoCode());
            toCurrency.setTitle(from.getCurrency().getTitle());
            Account toAccount = new Account();
            toAccount.setId(from.getId());
            toAccount.setCurrency(toCurrency);
            toAccount.setAmount(from.getAmount());
            return toAccount;
        }
        return null;
    }
    
}
