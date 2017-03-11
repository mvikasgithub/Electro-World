package com.niitbejai.electroworldFE.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niitbejai.electroworldBE.dao.CartItemDAO;
import com.niitbejai.electroworldBE.dao.ProductDAO;
import com.niitbejai.electroworldBE.dao.UserDAO;
import com.niitbejai.electroworldBE.dto.User;

@Controller
public class CartController 
{
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@RequestMapping(value = "/customer/viewcart")
	public String customerviewcart(Principal principal, Model mv) 
	{
		System.out.println("Inside customerviewcart method !!!!");
		
		if(principal != null)
		{
			user = userDAO.getUserBuUsername(principal.getName());
			
			if(user.getRole().equals("ADMIN"))
				return "redirect:/admin/show/product/management";
			
		}
		
		//ModelAndView mv = new ModelAndView("page"); // internally
													// productmanagement.jsp
													// will be shown
		mv.addAttribute("title", "Customer - View Cart");
		mv.addAttribute("productlist", productDAO.list());
		mv.addAttribute("cartitemlist", cartItemDAO.list(user.getId()));

		mv.addAttribute("userClickedViewCart", true);
		return "page";
	}
	
}
