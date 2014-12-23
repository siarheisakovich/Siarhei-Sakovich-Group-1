package com.epam.mentoringApp.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Currency {

    @Id
    private Long id;
    
    @Column(length = 3, nullable = false, unique = true)
    private String isoCode;
    
    @Column(length = 50, nullable = false, unique = true)
    private String title;
    
    
}
