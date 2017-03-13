package com.niitbejai.electroworldBE.dao;

import java.util.List;


import com.niitbejai.electroworldBE.dto.CartItem;

public interface CartItemDAO 
{
	CartItem get(int id);
	List<CartItem> list(int userid);
	
	//Methods for JUnit
	boolean add(CartItem cartItem);
	boolean update(CartItem cartItem);
	boolean delete(int id);	
	public CartItem getCartByUserId(int userId); 
	public CartItem getCartByUserIdAndProduct(int userId, int productId);
	public boolean deleteCartItemGivenCartItem(CartItem cartItem);
}
