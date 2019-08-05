package com.visa.training.jdbc;

import java.util.List;

public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcProductDAO dao = new JdbcProductDAO();
		Product test = new Product(10, 199, "test");
		dao.save(test);

		List<Product> l = dao.findAll();
		l.forEach(System.out::println);
	}

}
