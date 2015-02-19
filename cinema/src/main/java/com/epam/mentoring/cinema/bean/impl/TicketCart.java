package com.epam.mentoring.cinema.bean.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.epam.mentoring.cinema.bean.ICart;
import com.epam.mentoring.cinema.bean.ITicket;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.INTERFACES)
public class TicketCart implements ICart<ITicket>{
    
    private static final Logger LOGGER = Logger.getLogger(TicketCart.class);
    
    private List<ITicket> tickets;
    
    @Override
    public void addToCart(ITicket item) {
        tickets.add(item);
    }
    
    @Override
    public void remove(ITicket item) {
        tickets.remove(item);
    }

    @Override
    public List<ITicket> getItems() {
        return tickets;
    }
    
    

    @Override
    public boolean contains(ITicket item) {
        return tickets.contains(item);
    }
    
    @PostConstruct
    private void initialize(){
        LOGGER.debug("initialize");
        //Start Transaction
        tickets = new ArrayList<ITicket>();
        
    }
    
    @PreDestroy
    private void preDestroy(){
        LOGGER.debug("preDestroy");
        //Rollback
    }

}
