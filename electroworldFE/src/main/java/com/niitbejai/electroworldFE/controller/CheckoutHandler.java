package com.niitbejai.electroworldFE.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

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
	
	public String validateDetails(@Valid Order order ,MessageContext messageContext)
	{
		if(order.isSameAsShipping())
		{
			order.setShippingaddress(order.getBillingaddress());
			return "success";
		}
		else
		{
			if(order.getShippingaddress().isEmpty())
			{
				messageContext.addMessage(new MessageBuilder().error().source(
						"shippingaddress").defaultText("Shipping Address cannot be Empty").build());
				return "failure";
			}
		}
		return "success";	
	}
	
	public String addOrderSuccess(Order order)
	{
		//return orderDAO.add(order) ? "true" : "false";

		return "true";
	}

}
