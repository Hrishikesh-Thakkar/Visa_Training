package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class SQLClient {

	public static void main(String[] args) {
		Product p=new Product(5,"Redmi",29999.00,"Phone",3);
		String CREATE_INSERT = SQLUtil.generateInsertSQL(p);
		System.out.println(CREATE_INSERT);
		//int id, String name, double price, String category, int count)
		String CREATE_SQL = SQLUtil.generateCreateSQL(Product.class);
		System.out.println(CREATE_SQL);
	}
}
