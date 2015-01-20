package com.epam.mentoringApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Account {

    private Long id;

    private Currency currency;

    private Long amount;

    @TableGenerator(
            name="accGen",
            table="ACC_ID_GEN",
            pkColumnName="GEN_KEY",
            valueColumnName="GEN_VALUE",
            pkColumnValue="ACC_ID",
            allocationSize=1)
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="accGen")
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    public Currency getCurrency() {
        return currency;
    }

    @Column(nullable = false)
    public Long getAmount() {
        return amount;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    
    public void setCurrency(Currency currency) {
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
       if (!(obj instanceof Account))
            return false;
        if (obj == this)
            return true;

        Account rhs = (Account) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
}
