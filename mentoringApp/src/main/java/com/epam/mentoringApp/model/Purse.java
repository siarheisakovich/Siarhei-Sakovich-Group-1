package com.epam.mentoringApp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Purse {
    
    private Long id;
    
    private Long amount;
    
    @ManyToOne
    private Currency currency;

}
