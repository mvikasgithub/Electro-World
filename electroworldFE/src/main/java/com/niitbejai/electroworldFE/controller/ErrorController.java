package com.niitbejai.electroworldFE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	
	@RequestMapping(value = "/error/{errorCode}")
	public ModelAndView showSingleProducts(@PathVariable("errorCode") int errorCode) 
	{
		ModelAndView mv = new ModelAndView("ErrorPage");
		
		if(errorCode == 404)
			mv.addObject("userEncountered404Error", true);
		
		mv.addObject("statusCode", errorCode);

		mv.addObject("title", "OOPs - You are Lost !!");
		
		return mv;
	}

}
