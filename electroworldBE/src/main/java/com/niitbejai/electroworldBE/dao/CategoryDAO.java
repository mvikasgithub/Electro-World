package com.niitbejai.electroworldBE.dao;

import java.util.List;

import com.niitbejai.electroworldBE.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);

}
