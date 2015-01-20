package com.epam.mentoringApp.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class CurrencyOperation {

    private Long id;

    private Currency fromCurrency;

    private Currency toCurrency;

    private BigDecimal fromCoefficent;
    
    private BigDecimal toCoefficent;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "from_currency_id", nullable = false)
    public Currency getFromCurrency() {
        return fromCurrency;
    }

    @ManyToOne
    @JoinColumn(name = "to_currency_id", nullable = false)
    public Currency getToCurrency() {
        return toCurrency;
    }
    
    @Column(nullable = false, precision = 10, scale = 3)
    public BigDecimal getFromCoefficent() {
        return fromCoefficent;
    }
    @Column(nullable = false, precision = 10, scale = 3)
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
    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }
    
    public void setToCurrency(Currency toCurrency) {
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
       if (!(obj instanceof CurrencyOperation))
            return false;
        if (obj == this)
            return true;

        CurrencyOperation rhs = (CurrencyOperation) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }

}
