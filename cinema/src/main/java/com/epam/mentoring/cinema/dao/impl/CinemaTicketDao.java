package com.epam.mentoring.cinema.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
    @Override
    public List<Ticket> search(Map<String, Object> criteriaMap) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> p = criteriaQuery.from(Ticket.class);
        Predicate[] predicate = new Predicate[criteriaMap.size()];
        int index = 0;
        for (String property : criteriaMap.keySet()) {
            Object value = criteriaMap.get(property);
            predicate[index] = criteriaBuilder.equal(p.get(property), value);
            index++;
        }
        criteriaQuery.where(predicate);
        TypedQuery<Ticket> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    @Override
    public Ticket findByPlace(Integer row, Integer seat) {
        Map<String, Object> criteriaMap = new HashMap<String, Object>();
        criteriaMap.put("row", row);
        criteriaMap.put("seat", seat);
        List<Ticket> tickets = search(criteriaMap);
        if(tickets != null && tickets.size() > 0){
            return tickets.get(0);
        }
        return null;
    }
}
