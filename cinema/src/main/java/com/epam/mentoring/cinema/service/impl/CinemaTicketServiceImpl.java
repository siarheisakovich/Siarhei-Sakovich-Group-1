package com.epam.mentoring.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentoring.cinema.bean.impl.CinemaTicket;
import com.epam.mentoring.cinema.dao.ICinemaTicketDao;
import com.epam.mentoring.cinema.entity.Ticket;
import com.epam.mentoring.cinema.entity.Ticket.Status;
import com.epam.mentoring.cinema.service.ICinemaTicketService;

@Service
public class CinemaTicketServiceImpl implements ICinemaTicketService {

    @Autowired
    private ICinemaTicketDao dao;

    @Override
    public List<CinemaTicket> listUncomited() {
        List<CinemaTicket> cinemaTickets = new ArrayList<CinemaTicket>();
        for (Ticket ticket : dao.list()) {
            CinemaTicket cinemaTicket = new CinemaTicket("Аватар",
                    String.valueOf(ticket.getRow()), String.valueOf(ticket
                            .getSeat()), "50000", ticket.getStatus().toString());
            cinemaTickets.add(cinemaTicket);
        }
        return cinemaTickets;
    }

    @Override
    public boolean createFreeTickets() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                Ticket ticket = new Ticket();
                ticket.setRow(i);
                ticket.setSeat(j);
                ticket.setStatus(Status.FREE);
                dao.create(ticket);
            }
        }
        return true;
    }

    @Override
    public void updateTicketStatus(CinemaTicket cinemaTicket) {
        int row = Integer.valueOf(cinemaTicket.getRow());
        int seat = Integer.valueOf(cinemaTicket.getSeat());
        Status status = Status.valueOf(cinemaTicket.getStatus());

        Ticket ticket = dao.findByPlace(row, seat);
        ticket.setStatus(status);
        dao.update(ticket);
    }

}
