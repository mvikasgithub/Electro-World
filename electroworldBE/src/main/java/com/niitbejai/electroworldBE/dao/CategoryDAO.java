package com.niitbejai.electroworldBE.dao;

import java.util.List;

import com.niitbejai.electroworldBE.dto.Category;

public interface CategoryDAO {
		
	Category get(int id);
	List<Category> list();
	
	//Methods for JUnit
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	

}
