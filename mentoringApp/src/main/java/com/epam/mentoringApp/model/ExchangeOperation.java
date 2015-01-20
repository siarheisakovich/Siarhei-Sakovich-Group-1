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
public class ExchangeOperation {

    private Long id;
    
    private BigDecimal coefficent;
    
    private Account fromAccount;
    
    private Account toAccount;
    
    private Long amount;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    @Column(nullable = false, precision = 10, scale = 3)
    public BigDecimal getCoefficent() {
        return coefficent;
    }
    
    @ManyToOne
    @JoinColumn(name = "from_account_id", nullable = false)
    public Account getFromAccount() {
        return fromAccount;
    }
    
    @ManyToOne
    @JoinColumn(name = "to_account_id", nullable = false)
    public Account getToAccount() {
        return toAccount;
    }
    
    @Column(nullable = false)
    public Long getAmount() {
        return amount;
    }
    
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    
    public void setCoefficent(BigDecimal coefficent) {
        this.coefficent = coefficent;
    }
    
    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setToAccount(Account toAccount) {
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
       if (!(obj instanceof ExchangeOperation))
            return false;
        if (obj == this)
            return true;

        ExchangeOperation rhs = (ExchangeOperation) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
}

