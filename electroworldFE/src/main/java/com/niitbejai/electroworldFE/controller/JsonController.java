package com.niitbejai.electroworldFE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niitbejai.electroworldBE.dao.ProductDAO;
import com.niitbejai.electroworldBE.dto.Product;

@Controller
public class JsonController 
{

	@Autowired
	private ProductDAO productDAO;
	/*
	 * For getting data in JSON format to be displayed in data tables
	 */
	@RequestMapping("/all/data")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.list();
	}

}
