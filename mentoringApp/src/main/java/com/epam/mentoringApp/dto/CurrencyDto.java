package com.epam.mentoringApp.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.mentoringApp.model.Currency;

public class CurrencyDto {

    private Long id;

    private String isoCode;

    private String title;

    public Long getId() {
        return id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getTitle() {
        return title;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). 
            append(id).
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof CurrencyDto))
            return false;
        if (obj == this)
            return true;

        CurrencyDto rhs = (CurrencyDto) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
    
    public static CurrencyDto convertToDto(Currency from) {
        if (from != null) {
            CurrencyDto toCurrency = new CurrencyDto();
            toCurrency.setId(from.getId());
            toCurrency.setIsoCode(from.getIsoCode());
            toCurrency.setTitle(from.getTitle());
            return toCurrency;
        }
        return null;
    }
    
    public static Currency convertFromDto(CurrencyDto from) {
        if (from != null) {
            Currency toCurrency = new Currency();
            toCurrency.setId(from.getId());
            toCurrency.setIsoCode(from.getIsoCode());
            toCurrency.setTitle(from.getTitle());
            return toCurrency;
        }
        return null;
    }
}
