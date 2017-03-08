package com.niitbejai.electroworldBE.dao;

import java.util.List;

import com.niitbejai.electroworldBE.dto.Product;

public interface ProductDAO {

	
	Product get(int id);
	List<Product> list();
	
	//Methods for JUnit
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(int id);	
	
}
