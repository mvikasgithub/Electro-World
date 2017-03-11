package com.niitbejai.electroworldBE.dao;

import java.util.List;

import com.niitbejai.electroworldBE.dto.Cart;

public interface CartDAO 
{
	
	Cart get(int id);
	List<Cart> list();
	
	//Methods for JUnit
	boolean add(Cart cart);
	boolean update(Cart cart);
	boolean delete(int id);	
	public Cart getCartByUserId(int userId); 

}
