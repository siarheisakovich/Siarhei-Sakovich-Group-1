package com.epam.mentoringApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(allocationSize = 100, name = "ACC_SEQ")
public class Account {

    private Long id;

    private Currency currency;

    private Long amount;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_SEQ")
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

}
