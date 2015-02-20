package com.epam.mentoring.cinema.dao;

import java.util.List;
import java.util.Map;

import com.epam.mentoring.cinema.entity.Ticket;

public interface ICinemaTicketDao {

    List<Ticket> list();

    Ticket findById(Long id);

    Ticket create(Ticket ticket);

    void remove(Ticket ticket);

    Ticket update(Ticket ticket);

    List<Ticket> search(Map<String, Object> criteriaMap);

    Ticket findByPlace(Integer row, Integer seat);

}
