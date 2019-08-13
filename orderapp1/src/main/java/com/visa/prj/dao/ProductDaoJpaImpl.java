package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;

@Repository
public class ProductDaoJpaImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Product> getProducts() {
		
		return null;
	}

	@Override
	public Product getProduct(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public int addProduct(Product p) {
		System.out.println("Product Saved");
		em.persist(p);
		return p.getId();
		//return 0;
	}

}
