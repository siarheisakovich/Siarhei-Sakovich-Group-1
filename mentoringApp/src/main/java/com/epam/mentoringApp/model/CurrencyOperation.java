package com.epam.mentoringApp.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CurrencyOperation {

    private Long id;

    private Currency fromCurrency;

    private Currency toCurrency;

    private BigDecimal coefficent;

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
    public BigDecimal getCoefficent() {
        return coefficent;
    }

}