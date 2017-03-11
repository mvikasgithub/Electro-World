package com.niitbejai.electroworldBE.dao;

import java.util.List;


import com.niitbejai.electroworldBE.dto.CartItem;

public interface CartItemDAO 
{
	CartItem get(int id);
	List<CartItem> list();
	
	//Methods for JUnit
	boolean add(CartItem cartItem);
	boolean update(CartItem cartItem);
	boolean delete(int id);	
	public CartItem getCartByUserId(int userId); 
	public CartItem getCartByUserIdAndProduct(int userId, int productId); 
}
