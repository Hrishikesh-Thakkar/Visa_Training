
package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

public class TicketClient {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		TicketService ticketService= ctx.getBean(TicketService.class);
		EmployeeDao empDao= ctx.getBean(EmployeeDao.class);
		
		
		//functionality to raise a ticket
		String id="abc@google.com";
		String desc="some problem";
		Employee e=empDao.getEmployeeById(id);

		ticketService.addTicket(desc, e);
		
		
		//functionality to resolve a ticket
		Employee e1=empDao.getEmployeeById(id);
		if(check(e1)) {
			List<Ticket> list=ticketService.getOpenTickets();
			list.forEach(System.out::println);
			int t_id=list.get(list.size()-1).getTicketId();
			String arg="some resolve text";
			ticketService.resolveTicketById(t_id, e1, arg);
		}
		else {
			System.out.println("Sorry. You are not authorized to resolve a ticket. ");
		}

	}

	private static boolean check(Employee e) {
		if(e.getDepartment().equalsIgnoreCase("IT"))return true;
		return false;
	}

}
