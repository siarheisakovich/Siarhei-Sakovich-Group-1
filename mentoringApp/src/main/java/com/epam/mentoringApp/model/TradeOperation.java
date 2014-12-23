package com.epam.mentoringApp.model;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class TradeOperation {

    @Id
    private Long id;
    
    @ManyToOne
    private Currency fromCurrency;
    
    @ManyToOne
    private Currency toCurrency;
    
    private BigDecimal 
}
