package com.niitbejai.electroworldFE.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niitbejai.electroworldBE.dao.CartItemDAO;
import com.niitbejai.electroworldBE.dao.OrderDAO;
import com.niitbejai.electroworldBE.dto.CartItem;
import com.niitbejai.electroworldBE.dto.Order;

@Component
public class CheckoutHandler 
{
	@Autowired
	Order order;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	CartItem cartItem;
	
	@Autowired
	CartItemDAO cartItemDAO;
	

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
		String status = "success";
		
		// Add to Order table
		if(!orderDAO.add(order))
			return "failure";
		
		
		// delete from cart
		CartItem cartItem = cartItemDAO.getCartByUserIdAndProduct(order.getUserid(), order.getProductId());
		if(!cartItemDAO.deleteCartItemGivenCartItem(cartItem))
			return "failure";
		
	
		return status;

	}

}
