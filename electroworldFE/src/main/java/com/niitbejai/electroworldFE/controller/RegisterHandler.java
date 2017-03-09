package com.niitbejai.electroworldFE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niitbejai.electroworldBE.dao.UserDAO;
import com.niitbejai.electroworldBE.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	UserDAO userDAO;
	
	public User initFlow()
	{
		return new User();
	}
	
	public String validateDetails(User user ,MessageContext messageContext)
	{
		String status = "success";
		// No need of validating ID because it is auto-generated and not entered by user
		
		if(user.getEmail().isEmpty())
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		
		if(user.getPassword()==null)
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"Password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
		
		if(user.getBillingaddress()==null)
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"Address").defaultText("Address cannot be Empty").build());
			status = "failure";
		}
		
		if(user.getState()==null)
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"State").defaultText("State cannot be Empty").build());
			status = "failure";
		}
		
		if(user.getCity()==null)
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"City").defaultText("City cannot be Empty").build());
			status = "failure";
		}
		
		if(user.getZip()==null)
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"Zip").defaultText("Zip cannot be Empty").build());
			status = "failure";
		}

		return status;
	}	
	
	public String addUser(User user)
	{
		return userDAO.add(user);
	}

}
