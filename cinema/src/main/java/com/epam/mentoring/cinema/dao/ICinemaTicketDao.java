package com.epam.mentoring.cinema.dao;

import java.util.List;

import com.epam.mentoring.cinema.entity.Ticket;

public interface ICinemaTicketDao {

    List<Ticket> list();
    
    Ticket findById(Long id);
    
    Ticket create(Ticket ticket);
    
    void remove(Ticket ticket);
    
    Ticket update(Ticket ticket);
 
}
