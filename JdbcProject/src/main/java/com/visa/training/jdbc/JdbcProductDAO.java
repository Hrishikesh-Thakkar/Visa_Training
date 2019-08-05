package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDAO {
	public JdbcProductDAO() {
		// TODO Auto-generated constructor stub
	}
	public Product findById(int id) {
		//Connection c = JdbcUtil.getConnection();
		Product p = null;
		
		try(Connection c = JdbcUtil.getConnection()) {
			p = new Product();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from product where product_id ="+id);
			while(rs.next()) {
				mapRow(p, rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	private void mapRow(Product p, ResultSet rs) throws SQLException {
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setPrice(rs.getFloat(3));
		p.setQoh(rs.getInt(4));
	}
	
	public List<Product> findAll(){
		Product p = null;
		List<Product> all = new ArrayList<Product>();
		try(Connection c = JdbcUtil.getConnection()) {
			p = new Product();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from product");
			while(rs.next()) {
				p = new Product();
				mapRow(p, rs);
				all.add(p);
		}}catch(Exception e) {
			e.printStackTrace();
		}
	
		return all;
	}
	public Product save(Product toBeSaved) {
		try(Connection c = JdbcUtil.getConnection()) {
			PreparedStatement pt = c.prepareStatement("Insert into product(product_name,product_price,product_qoh) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pt.setString(1, toBeSaved.getName());
			pt.setFloat(2, toBeSaved.getPrice());
			pt.setInt(3, toBeSaved.getQoh());
			pt.executeUpdate();
			
			ResultSet keys = pt.getGeneratedKeys();
			keys.next();
			toBeSaved.setId(keys.getInt(1));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return toBeSaved;
	}
}
