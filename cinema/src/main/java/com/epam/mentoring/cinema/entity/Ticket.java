package com.epam.mentoring.cinema.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "Registrant", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Ticket implements Serializable{

    private static final long serialVersionUID = -6969439625103679528L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Integer row;

    @NotNull
    private Integer seat;

    public Long getId() {
        return id;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}