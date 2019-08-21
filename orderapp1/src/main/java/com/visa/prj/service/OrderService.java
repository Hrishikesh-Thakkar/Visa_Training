package com.visa.prj.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class OrderService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public void placeOrder(Order o) {
		orderDao.placeOrder(o);
		double total = 0.0;
		List<Item> items = o.getItems();
		for (Item item : items) {
			total += item.getAmount();
			Product p = getById(item.getProduct().getId());
			p.setCount(p.getCount()-item.getQty());
		}
		o.setTotal(total);
	}
	public List<Order> getOrders(Customer c){
		return orderDao.getOrders(c);
	}
	@Transactional
	public int insertProduct(Product p) {
		return productDao.addProduct(p);
	}
	@Transactional
	public int insertItem(String[] prds,String email) {
		List<Product> l = new ArrayList<Product>();
		List<Item> items = new ArrayList<Item>();
		double total = 0.0;
		for (String p : prds) {
			l.add(getById(Integer.parseInt(p)));
			Item item = new Item();
			item.setProduct(l.get(l.size()-1));
			item.setAmount(l.get(l.size()-1).getPrice());
			item.setQty(1);
			items.add(item);
			total+=item.getAmount();
			
		}
		Order o = new Order();
		o.setItems(items);
		o.setOrderDate(new Date());
		o.setTotal(total);
		Customer c = new Customer();
		c.setEmail(email);
		o.setCustomer(c);
		placeOrder(o);
		return 0;
	}
	public List<Product> fetchProducts(){
		return productDao.getProducts();
	}
	public Product getById(int id) {
		return productDao.getProduct(id);
	}
}
