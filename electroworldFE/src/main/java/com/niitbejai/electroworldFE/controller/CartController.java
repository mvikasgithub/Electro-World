package com.niitbejai.electroworldFE.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.niitbejai.electroworldBE.dao.CartItemDAO;

public class CartController 
{
	@Autowired
	private CartItemDAO cartItemDAO;
	
}
