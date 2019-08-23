package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RestController
public class ProductController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("products/{id}")
	public @ResponseBody Product getProductById(@PathVariable("id") int id) {
		//ResponseBody is going to see the Accept: Header (application/json) and chooses content negotiation handler 
		//Negotiation Handler converts Java to Representation (i.e to JSON or XML)
		return orderService.getById(id);
	}
	@GetMapping("products")
	public @ResponseBody List<Product> getProducts(@RequestParam(name="price",defaultValue = "0") double price) {
		//ResponseBody is going to see the Accept: Header (application/json) and chooses content negotiation handler 
		//Negotiation Handler converts Java to Representation (i.e to JSON or XML)
		if(price>0)
			return orderService.getProductsByPrice(price);
		return orderService.getProducts();
	}
	@PostMapping("products")
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		//RequestBody Sees the content type and converts Representation into Java
		orderService.saveProduct(p);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
}
