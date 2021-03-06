package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		//Create Spring COntainer
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService",OrderService.class);
		/*
		Product p = new Product(0,"LogiTech Mouse","computer",450.00,1000);
		os.insertProduct(p);
		p = os.getById(1);
		System.out.println(p.getName()+p.getCategory()+p.getPrice()+p.getCount());
		*/
		List<Product> list = os.fetchProducts();
		for (Product product : list) {
			System.out.println(product.getName()+","+product.getPrice());
		
		}
	}

}
