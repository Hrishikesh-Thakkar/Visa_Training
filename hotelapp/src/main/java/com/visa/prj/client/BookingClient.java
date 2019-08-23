package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;


public class BookingClient {
	public static void main(String[] args) {
		//Create Spring COntainer
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		BookingService os = ctx.getBean("bookingService",BookingService.class);
		User u = os.getUser("def@v.com", "sec");
		System.out.println(u.toString());
		Hotel h = os.getHotelById(11);
		System.out.println(h.toString());
		
		System.out.println("Here I am");
		List<Hotel> list = os.findHotels("a");
		for (Hotel product : list) {
			System.out.println(product.getName()+","+product.getPrice());
		
		}
		
	}
}
