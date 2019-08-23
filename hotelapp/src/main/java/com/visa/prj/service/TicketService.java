package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {
	@Autowired
	private TicketDao dao;
	
	public void addTicket(String desc, Employee e) {
		Ticket t=new Ticket();
		t.setTicketDesc(desc);
		t.setRaisedBy(e);
		t.setRaisedDate(new Date());
		dao.addTicket(t);		
	}

	public Ticket getOpenTicketById(int id) {
		return dao.getOpenTicketById(id);
	}
	
	public List<Ticket> getOpenTickets() {
		return dao.getOpenTickets();
	}
	
	@Transactional
	public void resolveTicketById(int id, Employee e, String arg) {
		dao.resolveTicketById(id, e, arg);
	}
	

}
