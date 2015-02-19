package com.epam.mentoring.cinema.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.epam.mentoring.cinema.dao.ICinemaTicketDao;
import com.epam.mentoring.cinema.entity.Ticket;

@Repository
public class CinemaTicketDao implements ICinemaTicketDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> list() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
        TypedQuery<Ticket> q = entityManager.createQuery(cq.select(cq.from(Ticket.class)));
        return q.getResultList();
    }

    @Override
    public Ticket findById(Long id) {
        return this.entityManager.find(Ticket.class, id);
    }

    @Override
    public Ticket create(Ticket ticket) {
        this.entityManager.persist(ticket);
        return ticket;
    }

    @Override
    public void remove(Ticket ticket) {
        this.entityManager.remove(ticket);
        
    }

    @Override
    public Ticket update(Ticket ticket) {
        return this.entityManager.merge(ticket);
    }
    
    
}
