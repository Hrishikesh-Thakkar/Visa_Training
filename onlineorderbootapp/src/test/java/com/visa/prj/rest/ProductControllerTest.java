package com.visa.prj.rest;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.Service;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@MockBean
	private OrderService os ;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getProductsTest() throws Exception{
		List<Product> products= 
				Arrays.asList(new Product(1,"a","c1",500.00,100),new Product(2,"b","c2",1500.00,100));
		when(os.getProducts()).thenReturn(products);
		
		// @formatter:off
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("b")));
        // @formatter:on
        verify(os, times(1)).getProducts();//Executed only once. Checking this
        verifyNoMoreInteractions(os);
	}
	@Test
	public void addProductTest() throws Exception{
		Product p = new Product(0,"b","c2",1550.00,100);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);
		
		when(os.saveProduct(Mockito.any(Product.class))).thenReturn(10);
		
		mockMvc.perform(post("/products").content(json).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		verify(os,times(1)).saveProduct(Mockito.any(Product.class));
	}
}
