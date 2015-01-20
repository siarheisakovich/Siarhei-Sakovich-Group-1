package com.epam.mentoringApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Currency {

    private Long id;

    private String isoCode;

    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(length = 3, nullable = false, unique = true)
    public String getIsoCode() {
        return isoCode;
    }

    @Column(length = 50, nullable = false, unique = true)
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
       if (!(obj instanceof Currency))
            return false;
        if (obj == this)
            return true;

        Currency rhs = (Currency) obj;
        return new EqualsBuilder().
            append(id, rhs.id).
            isEquals();
    }
}
