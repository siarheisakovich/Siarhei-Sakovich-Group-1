package com.epam.mentoring.cinema.service;

import java.util.List;

import com.epam.mentoring.cinema.bean.impl.CinemaTicket;

public interface ICinemaTicketService {

    List<CinemaTicket> listUncomited();
    
    boolean createFreeTickets();

    void updateTicketStatus(CinemaTicket cinemaTicket);
    
}
