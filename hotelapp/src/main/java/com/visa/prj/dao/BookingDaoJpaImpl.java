package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		String jpql = "from Hotel h where h.name Like :u or h.address like :u";
		TypedQuery<Hotel> query = em.createQuery(jpql,Hotel.class);
		query.setParameter("u","%"+criteria+"%");
		return query.getResultList(); 
	}

	@Override
	public Hotel findHotelById(long id) {
		String jpql = "from Hotel h where h.id = :u";
		TypedQuery<Hotel> query = em.createQuery(jpql,Hotel.class);
		query.setParameter("u", id);
		return query.getResultList().get(0);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql = "select u from User u where u.email = :ema AND u.password = :pas";
		//Product is class not table (Case Sensitive) no need for select keyword if you require full row
		//Select p from Product p
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("ema", email);
		query.setParameter("pas", password);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public long createBooking(Booking booking) {
		em.persist(booking);
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql = "from Booking b where b.user = :u";
		TypedQuery<Booking> query = em.createQuery(jpql,Booking.class);
		query.setParameter("u", user);
		return query.getResultList();
	}

}
