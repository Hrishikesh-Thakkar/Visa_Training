package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;

@Repository
public class ProductDaoJpaImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Product> getProducts() {
		String jpql = "from Product"; //Product is class not table (Case Sensitive) no need for select keyword if you require full row
		//Select p from Product p
		TypedQuery<Product> query = em.createQuery(jpql,Product.class);
		return query.getResultList();
		//return null;
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
