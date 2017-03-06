package com.niitbejai.electroworldFE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niitbejai.electroworldBE.dao.ProductDAO;
import com.niitbejai.electroworldBE.dto.Product;

/*
 * The @Controller annotation indicates that a particular class serves the role of a controller. 
 * The @Controller annotation acts as a stereotype for the annotated class, indicating its role. 
 * The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.
 * 
 * In plain English @Controller means that this class will have all the request mappings and works in 
 * conjunction with the dispatcher   
 */

@Controller 
@RequestMapping("/admin")
public class AdminController 
{

	@Autowired
	private ProductDAO productDAO;
	
	/*
	 * For getting data in JSON format to be displayed in data tables
	 */
	@RequestMapping ("/all/data")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDAO.list();
	}
	
	
	/*
	 * For Admin
	 */
	@RequestMapping(value= "/")
	public ModelAndView admin()
	{
		ModelAndView mv = new ModelAndView("admin"); 
		mv.addObject("title", "Admin");
		
		mv.addObject("userClickedAdmin", true);
		return mv;
	}	
	
	/*
	 * To be invoked when user clicks in Admin in the NavBar.
	 * We need to show the /admin/show/product/management page
	 * 
	 */
	
	@RequestMapping(value= "/show/product/management")
	public ModelAndView productmanagement()
	{
		//JOptionPane.showMessageDialog(null, "Inside showproductmanagement method !!!!");
		
		ModelAndView mv = new ModelAndView("page"); // internally productmanagement.jsp will be shown 
		mv.addObject("title", "Admin - Product Management");
		
		mv.addObject("userClickedAdminProductManagement", true);
		return mv;
	}	
	
	
	
	@RequestMapping(value= "/edit/{id}/product")
	public ModelAndView editProduct(@PathVariable("id")int id)
	{
		//JOptionPane.showMessageDialog(null, "Inside showproductmanagement method !!!!");
		
		ModelAndView mv = new ModelAndView("page"); // internally productmanagement.jsp will be shown 
		mv.addObject("title", "Admin - Product Management");
		
		mv.addObject("userClickedAdminProductManagement", true);
		mv.addObject("product",productDAO.get(id));
		return mv;
	}	
	
	
	
	
	
	
	
	
	/*
     * This method will serve as default GET handler.
     *
     */
/*    @RequestMapping(value="/show/product", method = RequestMethod.GET) 
    public ModelAndView showproduct(ModelMap model) 
    {
    	JOptionPane.showMessageDialog(null, "Inside showproduct method !!!!");
    	System.out.println("Inside showproduct method !!!!");
    	
    	ModelAndView mv = new ModelAndView("admin");
        Product product = new Product();
        //product = productDAO.get(1); 
        model.addAttribute("product", product);
        mv.addObject("userClickedShowProduct", true);
        return mv;
    }
 */   
    
	/*
     * This method will serve as default GET handler.
     *
     */
/*    @RequestMapping(value="/show/Add/product", method = RequestMethod.POST)
    public String showaddproduct(ModelMap model)   
    {
    	JOptionPane.showMessageDialog(null, "Inside showAddProduct method !!!!");
    	System.out.println("Inside showaddproduct method !!!!");
    	
    	ModelAndView mv = new ModelAndView("admin");
    	Product product = new Product();
    	model.addAttribute("product", product);
        mv.addObject("userClickedShowAddProduct", true);
              
        return "redirect:/admin/show/product";
        
    }
 */   
	/*
     * This method will serve as default GET handler.
     *
     */
 /*   @RequestMapping(value="/show/Update/product", method = RequestMethod.POST)
    public ModelAndView showupdateproduct(ModelMap model) 
    {
    	JOptionPane.showMessageDialog(null, "Inside showUpdateProduct method !!!!");
    	System.out.println("Inside showupdateproduct method !!!!");
    	
    	ModelAndView mv = new ModelAndView("admin");
        Product product = new Product();
        product = productDAO.get(1); 
        model.addAttribute("product", product);
        mv.addObject("userClickedShowUpdateProduct", true);
        return mv;
    }
 */   
 
    /*
     * This method will be called on form submission, handling POST request
     * It also validates the user input
     */
/*    @RequestMapping(value = "/save/product",  method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result, ModelMap model){
    	
    	JOptionPane.showMessageDialog(null, "Inside saveProduct method !!!!");
    	System.out.println("Inside saveProduct method !!!!");
 
        if(result.hasErrors()) {
        	JOptionPane.showMessageDialog(null, "Some Errors: result.hasErrors !!!!");
                return "admin";
        }
        
        productDAO.add(product);
        
		//Assert.assertEquals("Successfully added a category inside the table !", true, productDAO.add(product));        
 
        //model.addAttribute("success !!", "Product with code"+ product.getCode()+" , - Registration completed successfully");
        return "redirect:/admin";
    }
 */
    /*
     * Method used to populate the Section list in view.
     * Note that here you can call external systems to provide real data.
     */
 /*   @ModelAttribute("productadminoptions")
    public List<String> initializeProductAdminOptions() {
 
        List<String> sections = new ArrayList<String>();
        sections.add("Add");
        sections.add("Update");
        sections.add("Delete");
        return sections;
    }	
*/	

}
