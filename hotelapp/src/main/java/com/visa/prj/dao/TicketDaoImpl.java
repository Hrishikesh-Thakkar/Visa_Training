package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;


@Repository
public class TicketDaoImpl implements TicketDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void addTicket(Ticket t) {
		em.persist(t);
	}

	@Override
	public Ticket getOpenTicketById(int id) {
		return em.find(Ticket.class, id);
		
	}

	@Override
	public List<Ticket> getOpenTickets() {
		String s= "select t from Ticket t where t.resolveText is NULL ";
		TypedQuery<Ticket> t= em.createQuery(s,Ticket.class);
		return t.getResultList();
	}

	@Override
	public void resolveTicketById(int id, Employee e, String args) {
		Ticket t=em.find(Ticket.class, id);
		t.setResolvedBy(e);
		t.setResolvedDate(new Date());
		t.setResolveText(args);
		em.merge(t);

	}

}
