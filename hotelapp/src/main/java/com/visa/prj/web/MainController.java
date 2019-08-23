package com.visa.prj.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;


@Controller
public class MainController {
	@Autowired
	private BookingService bs;
	@RequestMapping("placeReservation.do")
	public String placeReservation(HttpServletRequest req, @ModelAttribute("booking") Booking b ) {
		
		User u = (User) req.getSession().getAttribute("user");
		b.setUser(u);
		bs.makeBooking(u, b.getHotel(), b.getCheckinDate(), b.getCheckoutDate(), b.getSmoking() ,b.getBeds());
		
		/*List<Booking> bookingList= bs.getAllBookingsByUser(b.getUser());
		mav.addObject("bookingList",bookingList);*/
		return "redirect:mybookings.do";
	}
	@RequestMapping("search.do")
	public ModelAndView searchRedirect() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchForm.jsp");
		SearchCriteria s = new SearchCriteria();
		mav.addObject("searchCriteria",s);
		return mav;
	}
	@RequestMapping("hotels.do")
	public ModelAndView searchForm(@RequestParam("searchString") String searchString, @RequestParam("pageSize") int pageSize) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchResults.jsp");
		List<Hotel> hotelList = bs.findHotels(searchString);
		if(hotelList.size()>pageSize)
			hotelList =hotelList.subList(0, pageSize);
		mav.addObject("hotelList",hotelList);
		return mav;
	}
	@RequestMapping("viewHotel.do")
	public ModelAndView viewHotel(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showHotel.jsp");
		mav.addObject("hotel",bs.getHotelById(id));
		return mav;
	}
	@RequestMapping("login.do")
	public ModelAndView login() {
		Booking b = new Booking();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userLoginForm.jsp");
		mav.addObject("booking",b);
		return mav;
	}
	@RequestMapping("auth.do")
	public String login(HttpServletRequest req,@ModelAttribute("booking") Booking b) {
		HttpSession ses = req.getSession();
		User u = bs.getUser(b.getUser().getEmail(), b.getUser().getPassword());
		ses.setAttribute("user", u);
		return "/";
	}
	@RequestMapping("bookingForm.do")
	public ModelAndView bookingForm(HttpServletRequest req,@RequestParam("id") int id ) {
		Booking b = new Booking();
		b.setHotel(bs.getHotelById(id));
		User u = (User)req.getSession().getAttribute("user");
		b.setUser(u);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookingForm.jsp");
		mav.addObject("booking",b);
		return mav;
	}
	@RequestMapping("mybookings.do")
	public ModelAndView showBookings(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		User u =(User) req.getSession().getAttribute("user");
		List<Booking> bookings = bs.getAllBookingsByUser(u);
		mav.setViewName("showBookings.jsp");
		mav.addObject("bookingList",bookings);
		return mav;
	}
}
