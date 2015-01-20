package com.epam.mentoringApp.dto;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.mentoringApp.model.ExchangeOperation;

public class ExchangeOperationDto {

    private Long id;
    
    private BigDecimal fromCoefficent;
    
    private BigDecimal toCoefficent;
    
    private AccountDto fromAccount;
    
    private AccountDto toAccount;
    
    private UserDto user;
    
    private CurrencyOperationDto currencyOperation;
    
    private BigDecimal amount;
    
    public Long getId() {
        return id;
    }
    
    public BigDecimal getFromCoefficent() {
        return fromCoefficent;
    }
    
    public BigDecimal getToCoefficent() {
        return toCoefficent;
    }
    
    public AccountDto getFromAccount() {
        return fromAccount;
    }
    
    public UserDto getUser() {
        return user;
    }
    
    public AccountDto getToAccount() {
        return toAccount;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public void setFromAccount(AccountDto fromAccount) {
        this.fromAccount = fromAccount;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setToAccount(AccountDto toAccount) {
        this.toAccount = toAccount;
    }
    
    
    public void setFromCoefficent(BigDecimal fromCoefficent) {
        this.fromCoefficent = fromCoefficent;
    }
    
    public void setToCoefficent(BigDecimal toCoefficent) {
        this.toCoefficent = toCoefficent;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). 
            append(id).
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof ExchangeOperationDto))
            return false;
        if (obj == this)
            return true;

        ExchangeOperationDto rhs = (ExchangeOperationDto) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
    
    public void setUser(UserDto user) {
        this.user = user;
    }
    
    public static ExchangeOperation convertFromDto(ExchangeOperationDto from) {
        if (from != null) {
            ExchangeOperation toExchangeOperation = new ExchangeOperation();
            toExchangeOperation.setId(from.getId());
            toExchangeOperation.setAmount(from.getAmount());
            toExchangeOperation.setFromCoefficent(from.getFromCoefficent());
            toExchangeOperation.setToCoefficent(from.getToCoefficent());
            toExchangeOperation.setUser(UserDto.convertFromDto(from.getUser()));
            toExchangeOperation.setFromAccount(AccountDto.convertFromDto(from
                    .getFromAccount()));
            toExchangeOperation.setToAccount(AccountDto.convertFromDto(from
                    .getToAccount()));
            return toExchangeOperation;
        }
        return null;
    }

    public static ExchangeOperationDto convertToDto(ExchangeOperation from) {
        if (from != null) {
            ExchangeOperationDto toExchangeOperation = new ExchangeOperationDto();
            toExchangeOperation.setId(from.getId());
            toExchangeOperation.setAmount(from.getAmount());
            toExchangeOperation.setFromCoefficent(from.getFromCoefficent());
            toExchangeOperation.setToCoefficent(from.getToCoefficent());
            toExchangeOperation.setUser(UserDto.convertToDto(from.getUser()));
            toExchangeOperation.setFromAccount(AccountDto.convertToDto(from
                    .getFromAccount()));
            toExchangeOperation.setToAccount(AccountDto.convertToDto(from
                    .getToAccount()));
            return toExchangeOperation;
        }
        return null;
    }

    public CurrencyOperationDto getCurrencyOperation() {
        return currencyOperation;
    }

    public void setCurrencyOperation(CurrencyOperationDto currencyOperation) {
        this.currencyOperation = currencyOperation;
    }
}

