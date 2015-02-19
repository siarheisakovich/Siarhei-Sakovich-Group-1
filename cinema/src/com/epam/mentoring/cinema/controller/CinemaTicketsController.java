package com.epam.mentoring.cinema.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.mentoring.cinema.bean.ICart;
import com.epam.mentoring.cinema.bean.ITicket;

@Controller
public class CinemaTicketsController {

    private static final Logger LOGGER = Logger.getLogger(CinemaTicketsController.class);
    
    @Autowired
    private ICart<ITicket> cart;
    
    @RequestMapping(value="/tickets")
    public String listTickets(Model model) {
        LOGGER.debug("listTickets");
        model.addAttribute("message", "hello");
        return "tickets";
    }
    
    @RequestMapping(value="/cart")
    public String cart(Model model) {
        List<ITicket> tickets = cart.getItems();
        model.addAttribute("items", tickets);
        return "cart";
    }
    
    @RequestMapping(value="/cart/${id}", method = RequestMethod.PUT)
    @ResponseBody
    public String addTicketToCart(@ModelAttribute("currency") ITicket iTicket){
        cart.addToCart(iTicket);
        return "addedd";
    }
    
    @RequestMapping(value="/cart/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public String removeTicketFromCart(@ModelAttribute("currency") ITicket iTicket){
        cart.addToCart(iTicket);
        return "addedd";
    }
    
    @RequestMapping(value="/cart/book", method=RequestMethod.POST)
    public String order(){
        
    }
    
    @RequestMapping(value="/cart/pay", method=RequestMethod.POST)
    public String pay(){
        
    }
    
//    @RequestMapping(value="/admin/currencies/{id}", method = RequestMethod.GET)
//    public String detailView(Model model, @PathVariable Long id) {
//        
//    }
}
