package com.niitbejai.electroworldFE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * The @Controller annotation indicates that a particular class serves the role of a controller. 
 * The @Controller annotation acts as a stereotype for the annotated class, indicating its role. 
 * The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.
 * 
 * In plain English @Controller means that this class will have all the request mappings and works in 
 * conjunction with the dispatcher   
 */

@Controller //Tells the 
public class PageController {
	
	/*
	 * If / or /home or /index is used for this website then map it to this method 
	 */
	@RequestMapping(value= {"/", "home", "/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page"); // later this will be created as master page
		mv.addObject("greeting", "Hello World from Electro World !!");
		return mv;
	}

}
