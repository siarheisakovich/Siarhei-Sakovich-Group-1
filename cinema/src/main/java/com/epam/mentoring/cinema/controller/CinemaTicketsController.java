package com.epam.mentoring.cinema.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.mentoring.cinema.bean.impl.CinemaTicket;
import com.epam.mentoring.cinema.service.ICinemaTicketService;

@Controller
public class CinemaTicketsController {

    private static final Logger LOGGER = Logger.getLogger(CinemaTicketsController.class);
    
    @Autowired
    private ICinemaTicketService cinemaTicketService;
    
    @RequestMapping(value="/tickets")
    public String listTickets(Model model) {
        LOGGER.debug("listTickets");
        List<CinemaTicket> cinemaTickets = cinemaTicketService.listUncomited();
        if(cinemaTickets == null || cinemaTickets.size() == 0){
            if(cinemaTicketService.createFreeTickets()){
                cinemaTickets = cinemaTicketService.listUncomited();
            }
        }
        model.addAttribute("message", "hello");
        return "tickets";
    }
}
