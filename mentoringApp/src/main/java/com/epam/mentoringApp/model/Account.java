package com.epam.mentoringApp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(allocationSize = 100, name = "ACC_SEQ")
public class Account {

    private Long id;
    
    private List<Purse> purse;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACC_SEQ")
    public Long getId() { return id; }
    
    

    
}
