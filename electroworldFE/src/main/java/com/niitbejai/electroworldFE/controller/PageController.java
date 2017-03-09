package com.niitbejai.electroworldFE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niitbejai.electroworldBE.dao.CategoryDAO;
import com.niitbejai.electroworldBE.dto.Category;

/*
 * The @Controller annotation indicates that a particular class serves the role of a controller. 
 * The @Controller annotation acts as a stereotype for the annotated class, indicating its role. 
 * The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.
 * 
 * In plain English @Controller means that this class will have all the request mappings and works in 
 * conjunction with the dispatcher   
 */

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	/*
	 * If / or /home or /index is used for this website then map it to this
	 * method
	 */
	@RequestMapping(value = { "/", "home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page"); // later this will be
													// created as master page
		mv.addObject("title", "Home");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickedHome", true);
		return mv;
	}

	// display the login view

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("error", "Authentication Failed - Invalid credentials!");
		}
		model.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page"); // later this will be
													// created as master page
		mv.addObject("title", "About us");
		mv.addObject("userClickedAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page"); // later this will be
													// created as master page
		mv.addObject("title", "Contact us");
		mv.addObject("userClickedContact", true);
		return mv;
	}

	@RequestMapping(value = "/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("registration"); // later this will
															// be created as
															// master page
		mv.addObject("title", "Registration");
		mv.addObject("userClickedRegistration", true);
		return mv;
	}

	/*
	 * For view products
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page"); // later this will be
													// created as master page
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickedAllProducts", true);
		return mv;
	}

	/*
	 * For displaying particular category products
	 */
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page"); // later this will be
													// created as master page

		// categoryDAO to fetch a single category

		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());
		// System.out.println(category.getName());

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		// passing the single category
		mv.addObject("category", category);

		mv.addObject("userClickedCatgoryProducts", true);
		return mv;
	}

	/*
	 * Get list of all categories from DB so that it is available in the FE form
	 * (while adding product)
	 */
	/*
	 * @ModelAttribute("categories") public List<String> initializeCategories()
	 * {
	 * 
	 * List<String> categories = categoryDAO.list(); categories.add(""); return
	 * categories; }
	 */

	/*
	 * For Admin
	 * 
	 * @RequestMapping(value= "/admin") public ModelAndView admin() {
	 * ModelAndView mv = new ModelAndView("admin"); // later this will be
	 * created as master page mv.addObject("title", "Admin");
	 * 
	 * // passing the list of categories //mv.addObject("categories",
	 * categoryDAO.list());
	 * 
	 * 
	 * mv.addObject("userClickedAdmin", true); return mv; }
	 */

	/*
	 * Query string handling is demonstrated using the below two methods.
	 * Commenting this out as we will not need it for the rest of the programs
	 * 
	 * @RequestMapping(value= "/test") public ModelAndView
	 * test(@RequestParam(value="greeting", required=false )String userGreeting)
	 * { if(usergreeting == null) { userGreeting = "James Gosling !!"; }
	 * ModelAndView mv = new ModelAndView("page"); // later this will be created
	 * as master page mv.addObject("greeting",
	 * "Hello World from Electro World !!" + " Message from " + userGreeting);
	 * return mv; }
	 * 
	 * @RequestMapping(value= "/test/{usergreeting}") public ModelAndView
	 * test(@PathVariable("usergreeting")String usergreeting) { if(usergreeting
	 * == null) { usergreeting = "James Gosling !!"; } ModelAndView mv = new
	 * ModelAndView("page"); // later this will be created as master page
	 * mv.addObject("greeting", "Hello World from Electro World !!" +
	 * " Message from " + usergreeting); return mv; }
	 */

}
