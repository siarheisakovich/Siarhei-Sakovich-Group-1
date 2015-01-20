package com.epam.mentoringApp.dto;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.mentoringApp.model.Currency;
import com.epam.mentoringApp.model.CurrencyOperation;

public class CurrencyOperationDto {

    private Long id;

    private CurrencyDto fromCurrency;

    private CurrencyDto toCurrency;

    private BigDecimal fromCoefficent;
    
    private BigDecimal toCoefficent;

    public Long getId() {
        return id;
    }

    public CurrencyDto getFromCurrency() {
        return fromCurrency;
    }

    public CurrencyDto getToCurrency() {
        return toCurrency;
    }
    
    public BigDecimal getFromCoefficent() {
        return fromCoefficent;
    }
    
    public BigDecimal getToCoefficent() {
        return toCoefficent;
    }
    
    public void setFromCoefficent(BigDecimal fromCoefficent) {
        this.fromCoefficent = fromCoefficent;
    }
    
    public void setToCoefficent(BigDecimal toCoefficent) {
        this.toCoefficent = toCoefficent;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setFromCurrency(CurrencyDto fromCurrency) {
        this.fromCurrency = fromCurrency;
    }
    
    public void setToCurrency(CurrencyDto toCurrency) {
        this.toCurrency = toCurrency;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). 
            append(id).
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof CurrencyOperationDto))
            return false;
        if (obj == this)
            return true;

        CurrencyOperationDto rhs = (CurrencyOperationDto) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
    
    public static CurrencyOperation convertFromDto(CurrencyOperationDto from){
        if(from != null){
            CurrencyOperation toCurrencyOperation = new CurrencyOperation();
            toCurrencyOperation.setId(from.getId());
            toCurrencyOperation.setFromCoefficent(from.getFromCoefficent());
            toCurrencyOperation.setFromCurrency(CurrencyDto.convertFromDto(from.getFromCurrency()));
            toCurrencyOperation.setToCurrency(CurrencyDto.convertFromDto(from.getToCurrency()));
            toCurrencyOperation.setToCoefficent(from.getToCoefficent());
            return toCurrencyOperation;
        }
        return null;
    }
    
    public static CurrencyOperationDto convertToDto(CurrencyOperation from){
        if(from != null){
            CurrencyOperationDto toCurrencyOperation = new CurrencyOperationDto();
            toCurrencyOperation.setId(from.getId());
            toCurrencyOperation.setFromCoefficent(from.getFromCoefficent());
            toCurrencyOperation.setFromCurrency(CurrencyDto.convertToDto(from.getFromCurrency()));
            toCurrencyOperation.setToCurrency(CurrencyDto.convertToDto(from.getToCurrency()));
            toCurrencyOperation.setToCoefficent(from.getToCoefficent());
            return toCurrencyOperation;
        }
        return null;
    }

}
