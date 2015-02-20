package com.epam.mentoring.cinema.bean.impl;

import com.epam.mentoring.cinema.bean.ITicket;

public class CinemaTicket implements ITicket{

    private String title;
    
    private String row;
    
    private String seat;
    
    private String price;
    
    private String status;
    
    public CinemaTicket(String title, String row, String seat, String price,
            String status) {
        super();
        this.title = title;
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.status = status;
    }

    @Override
    public String getDescription() {
        return "Row: " + row + ", Seat: " + seat + ";";
    }
    
    @Override
    public String getPrice() {
        return price;
    }
    
    public String getRow() {
        return row;
    }
    
    public String getSeat() {
        return seat;
    }
    
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getStatus() {
        return status;
    }
}
