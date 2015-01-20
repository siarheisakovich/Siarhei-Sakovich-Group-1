package com.epam.mentoringApp.dto;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.mentoringApp.model.ExchangeOperation;

public class ExchangeOperationDto {

    private Long id;
    
    private BigDecimal coefficent;
    
    private AccountDto fromAccount;
    
    private AccountDto toAccount;
    
    private Long amount;
    
    public Long getId() {
        return id;
    }
    
    public BigDecimal getCoefficent() {
        return coefficent;
    }
    
    public AccountDto getFromAccount() {
        return fromAccount;
    }
    
    public AccountDto getToAccount() {
        return toAccount;
    }
    
    public Long getAmount() {
        return amount;
    }
    
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    
    public void setCoefficent(BigDecimal coefficent) {
        this.coefficent = coefficent;
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
    
    public static ExchangeOperation convertFromDto(ExchangeOperationDto from) {
        if (from != null) {
            ExchangeOperation toExchangeOperation = new ExchangeOperation();
            toExchangeOperation.setAmount(from.getAmount());
            toExchangeOperation.setCoefficent(from.getCoefficent());
            toExchangeOperation.setFromAccount(AccountDto.convertFromDto(from
                    .getFromAccount()));
            toExchangeOperation.setToAccount(AccountDto.convertFromDto(from
                    .getToAccount()));
            toExchangeOperation.setCoefficent(from.getCoefficent());
            return toExchangeOperation;
        }
        return null;
    }

    public static ExchangeOperationDto convertToDto(ExchangeOperation from) {
        if (from != null) {
            ExchangeOperationDto toExchangeOperation = new ExchangeOperationDto();
            toExchangeOperation.setAmount(from.getAmount());
            toExchangeOperation.setCoefficent(from.getCoefficent());
            toExchangeOperation.setFromAccount(AccountDto.convertToDto(from
                    .getFromAccount()));
            toExchangeOperation.setToAccount(AccountDto.convertToDto(from
                    .getToAccount()));
            toExchangeOperation.setCoefficent(from.getCoefficent());
            return toExchangeOperation;
        }
        return null;
    }
}

