package com.visa.prj.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
public interface TicketDao {
	
	public void addTicket(Ticket e);
	
	public Ticket getOpenTicketById(int id);
	
	public List<Ticket> getOpenTickets();
	
	public void resolveTicketById(int id, Employee e, String arg);
	

}
