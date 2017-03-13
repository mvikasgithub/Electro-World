package com.niitbejai.electroworldBE.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niitbejai.electroworldBE.dto.Order;

public interface OrderDAO 
{
	Order get(int id);
	List<Order> list(int userid);
	
	//Methods for JUnit
	boolean add(Order order);
	boolean update(Order order);
	boolean delete(int id);	
	public Order getCartByUserId(int userId); 
}
