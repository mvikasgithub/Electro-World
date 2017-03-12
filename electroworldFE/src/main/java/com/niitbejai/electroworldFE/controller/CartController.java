package com.niitbejai.electroworldFE.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niitbejai.electroworldBE.dao.CartDAO;
import com.niitbejai.electroworldBE.dao.CartItemDAO;
import com.niitbejai.electroworldBE.dao.OrderDAO;
import com.niitbejai.electroworldBE.dao.ProductDAO;
import com.niitbejai.electroworldBE.dao.UserDAO;
import com.niitbejai.electroworldBE.dto.Cart;
import com.niitbejai.electroworldBE.dto.CartItem;
import com.niitbejai.electroworldBE.dto.Order;
import com.niitbejai.electroworldBE.dto.Product;
import com.niitbejai.electroworldBE.dto.User;

@Controller
public class CartController {
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CartDAO cartDAO;
		

	@Autowired
	private UserDAO userDAO;
	
	
	@Autowired
	private Cart cart;

	@Autowired
	private User user;
	
	@Autowired
	private Order order;

	@RequestMapping(value = "/customer/viewcart")
	public String customerviewcart(Principal principal, Model mv) 
	{
		System.out.println("Inside customerviewcart method !!!!");

		if (principal != null) 
		{
			user = userDAO.getUserBuUsername(principal.getName());

			if (user.getRole().equals("ADMIN"))
				return "redirect:/admin/show/product/management";

		}

		// ModelAndView mv = new ModelAndView("page"); // internally
		// productmanagement.jsp
		// will be shown
		mv.addAttribute("title", "Customer - View Cart");
		mv.addAttribute("productlist", productDAO.list());
		mv.addAttribute("cartitemlist", cartItemDAO.list(user.getId()));

		mv.addAttribute("userClickedViewCart", true);
		return "page";
	}

	@RequestMapping(value = "/customer/addtocart/{id}/product")
	public String customeraddproducttocart(@PathVariable("id") int id, Principal principal, Model mv) 
	{
		System.out.println("Inside customeraddproducttocart method !!!!");

		if (principal != null) 
		{
			user = userDAO.getUserBuUsername(principal.getName());

			if (user.getRole().equals("ADMIN"))
				return "redirect:/admin/show/product/management";
		}
		
		Product product = null;
		
		product = productDAO.get(id);
		
		
		CartItem cartItem = new CartItem();
		cartItem.setUserid(user.getId());
		cartItem.setQuantity(1);
		cartItem.setProductid(id);
		cartItem.setUnitprice(product.getPrice());
		
		helperAddAndUpdateCartItem(cartItem);
		mv.addAttribute("userClickedViewCart", true);
		return "redirect:/customer/viewcart";
	}
	
	@RequestMapping(value = "/customer/delete/{id}/product")
	public String customerdeleteproductfromcart(@PathVariable("id") int id, Principal principal, Model mv) 
	{
		System.out.println("Inside customeraddproducttocart method !!!!");

		if (principal != null) 
		{
			user = userDAO.getUserBuUsername(principal.getName());

			if (user.getRole().equals("ADMIN"))
				return "redirect:/admin/show/product/management";
		}
		
		Product product = null;
		
		product = productDAO.get(id);
		
		
		CartItem cartItem = new CartItem();
		cartItem.setUserid(user.getId());
		cartItem.setQuantity(1);
		cartItem.setProductid(id);
		cartItem.setUnitprice(product.getPrice());
		
		helperDeleteCartItem(cartItem);
		mv.addAttribute("userClickedViewCart", true);
		return "redirect:/customer/viewcart";
	}
	
	@RequestMapping(value = "/customer/checkout/{productid}/product")
	public String customercheckoutproduct(@PathVariable("productid") int productid, Principal principal, Model mv) 
	{
		System.out.println("Inside customercheckoutproduct method !!!!");

		if (principal != null) 
		{
			user = userDAO.getUserBuUsername(principal.getName());

			if (user.getRole().equals("ADMIN"))
				return "redirect:/admin/show/product/management";
		}
		
		cart = cartDAO.getCartByUserId(user.getId());
		
		order.setUserid(user.getId());
		order.setBillingaddress(user.getBillingaddress());
		order.setTotalitems(cart.getTotalitems());
		order.setTotalvalue(cart.getTotalvalueofitems());
		
		return "redirect:/checkout"; // to kick start the webform
	}
	
	
	public void helperDeleteCartItem(CartItem cartItem) 
	{
		Cart cart = new Cart();

		CartItem existingcartitem = cartItemDAO.getCartByUserIdAndProduct(cartItem.getUserid(),	cartItem.getProductid());

		if (existingcartitem == null || existingcartitem.getId() == 0) 
		{
			// this cannot and should not happen ie no cart with items in the
			// view
		} 
		else 
		{
			if (existingcartitem.getQuantity() == 1)
				cartItemDAO.delete(existingcartitem.getId());
			else 
			{
				existingcartitem.setQuantity(existingcartitem.getQuantity() - 1);
				existingcartitem.setTotalprice(existingcartitem.getTotalprice() - cartItem.getUnitprice());
				cartItemDAO.update(existingcartitem);
			}
		}

		Cart existingcart = cartDAO.getCartByUserId(cartItem.getUserid());
		if (existingcart == null || existingcart.getId() == 0) 
		{
			// this cannot and should not happen ie no cart with items in the
			// view

		} 
		else 
		{
			if (existingcart.getTotalitems() == 1) 
			{
				// only one item in the cart. so delete it.
				cartDAO.delete(existingcart.getId());
			} 
			else 
			{
				existingcart.setTotalvalueofitems(existingcart.getTotalvalueofitems() - cartItem.getUnitprice()); // deleting
																													// one																											// item
				existingcart.setTotalitems(existingcart.getTotalitems() - cartItem.getQuantity());
				cartDAO.update(existingcart);
			}

		}
	}
	
	

	  public void helperAddAndUpdateCartItem(CartItem cartItem) 
	  { 
		  Cart cart = new Cart();
		  
	  
		  //first check if that particular product is already in the cartitem, in which case we need to just update the quantity 
		  // else we need to add a new cartitem. If we need to add a new cartitem then we may need to add a new cart as well. 
		  // need to check that as well. Else just updating cart is sufficient
		  
		  cartItem.setTotalprice(cartItem.getUnitprice() * cartItem.getQuantity());
		  
		  // check if an entry for this product exists in the cart CartItem
		  CartItem  existingcartitem =  cartItemDAO.getCartByUserIdAndProduct(cartItem.getUserid(), cartItem.getProductid());
		  
		  if(existingcartitem == null ||  existingcartitem.getId() == 0) 
		  { 
			  // If the item does not exist in the  cartitem then add the item in cartitem
			  cartItemDAO.add(cartItem);
		  
			  // Check if there is an entry for this userid in the cart Cart
			  Cart existingcart = cartDAO.getCartByUserId(cartItem.getUserid());
			  
			  if(existingcart == null || existingcart.getId() == 0) 
			  { 
				  // this happens  when this is the first product for the user in the cart. so create a new cart (use add methodf) 
				  // If this is the first item, then add a row in the "cart" (dont confuse with cartitem)
				  
				  cart.setTotalitems(cartItem.getQuantity());
				  cart.setUserid(cartItem.getUserid());
				  cart.setTotalvalueofitems(cartItem.getTotalprice());
				  
				  cartDAO.add(cart); 
			  } 
			  else 
			  { 
				  // new product being added to cartitem but  cart entry already exists (some other productid added eariler) 
				  // so  update the cart 
				  existingcart.setTotalitems(existingcart.getTotalitems() +  cartItem.getQuantity()); 
				  existingcart.setUserid(cartItem.getUserid());
				  existingcart.setTotalvalueofitems(existingcart.getTotalvalueofitems() + cartItem.getTotalprice());
				  cartDAO.update(existingcart); 
			  } 
		  } 
		  else 
		  { 
			  // if the item exists increase  the quantity by 1 and update the item		  
			  existingcartitem.setQuantity(existingcartitem.getQuantity() + cartItem.getQuantity()); // means one more row in the cartitem table
			  existingcartitem.setTotalprice(existingcartitem.getTotalprice() +  cartItem.getTotalprice());
			  cartItemDAO.update(existingcartitem);
		  
			  Cart existingcart = cartDAO.getCartByUserId(cartItem.getUserid());
			  if(existingcart == null || existingcart.getId() == 0) 
			  { 
				  // code should not come here - ie cartitem exists but cart does not exist 
			  } 
			  else 
			  { 
				  // cart exists and needs to be updatedf
		  
				  existingcart.setTotalitems(existingcart.getTotalitems() +
				  cartItem.getQuantity()); existingcart.setUserid(cartItem.getUserid());
				  existingcart.setTotalvalueofitems(existingcart.getTotalvalueofitems() +
				  cartItem.getTotalprice());
				  cartDAO.update(existingcart); 
			  }
		  
		  }
	  
	  }

}
