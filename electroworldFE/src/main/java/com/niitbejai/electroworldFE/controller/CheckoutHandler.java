package com.niitbejai.electroworldFE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niitbejai.electroworldBE.dao.OrderDAO;
import com.niitbejai.electroworldBE.dto.Order;

@Component
public class CheckoutHandler 
{
	@Autowired
	Order order;
	
	//@Autowired
	//OrderDAO orderDAO;

	public Order initFlow() 
	{
		return order;
	}
	
	public String validateDetails(Order order ,MessageContext messageContext)
	{
		return "success";	
	}
	
	public String addOrderSuccess()
	{
		//return orderDAO.add(order) ? "success" : "failure";
		return "true";
	}

}
