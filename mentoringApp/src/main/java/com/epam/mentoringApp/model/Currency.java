package com.epam.mentoringApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
