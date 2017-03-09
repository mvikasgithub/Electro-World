package com.niitbejai.electroworldBE.dao;

import java.util.List;

import com.niitbejai.electroworldBE.dto.User;


public interface UserDAO {
	
	User get(int id);
	List<User> list();
	
	//Methods for JUnit
	String add(User user);
	String update(User user);
	boolean delete(int id);	
}
