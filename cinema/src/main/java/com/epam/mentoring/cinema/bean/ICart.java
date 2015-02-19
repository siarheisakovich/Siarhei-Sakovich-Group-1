package com.epam.mentoring.cinema.bean;

import java.util.List;

public interface ICart<T> {

    void addToCart(T item);
    
    List<T> getItems();
    
    void remove(T item);
    
    boolean contains(T item);
}
