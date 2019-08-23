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

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RestController
public class CustomerController {
@Autowired
private OrderService os;

@GetMapping("customer/{email}")
public @ResponseBody Customer getCustomerById(@PathVariable("email") String email) {
	//ResponseBody is going to see the Accept: Header (application/json) and chooses content negotiation handler 
	//Negotiation Handler converts Java to Representation (i.e to JSON or XML)
	return os.getCustomer(email);
}
@GetMapping("customers")
public @ResponseBody List<Customer> getCustomers() {
	//ResponseBody is going to see the Accept: Header (application/json) and chooses content negotiation handler 
	//Negotiation Handler converts Java to Representation (i.e to JSON or XML)
	return os.getCustomers();
}
@PostMapping("customers")
public ResponseEntity<Customer> addProduct(@RequestBody Customer p){
	//RequestBody Sees the content type and converts Representation into Java
	os.saveCustomer(p);
	return new ResponseEntity<>(p,HttpStatus.CREATED);
}
}
