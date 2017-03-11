package com.niitbejai.electroworldBE.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niitbejai.electroworldBE.dao.CartDAO;
import com.niitbejai.electroworldBE.dao.CartItemDAO;
import com.niitbejai.electroworldBE.dto.Cart;
import com.niitbejai.electroworldBE.dto.CartItem;

public class CartItemTestCase {

	private CartItem cartItem;
	private Cart cart;

	private static CartItemDAO cartItemDAO;
	private static CartDAO cartDAO;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niitbejai.electroworldBE");
		context.refresh();

		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
/*	
	 @Test public void testAddAndUpdateCartItem() { CartItem cartItem = new
	 CartItem(); Cart cart = new Cart();
	 * 
	 * // In actual execution will get these values from the front end
	 * 
	 * cartItem.setUserid(1); cartItem.setProductid(2); cartItem.setQuantity(1);
	 * cartItem.setUnitprice(500);
	 * 
	 * //first check if that particular product is already in the cartitem, in
	 * which case we need to just update the quantity // else we need to add a
	 * new cartitem. If we need to add a new cartitem then we may need to add a
	 * new card as well. // need to check that as well. Else just updating cart
	 * is sufficient
	 * 
	 * cartItem.setTotalprice(cartItem.getUnitprice() * cartItem.getQuantity());
	 * 
	 * // check if an entry for this product exists in the cart CartItem
	 * existingcartitem =
	 * cartItemDAO.getCartByUserIdAndProduct(cartItem.getUserid(),
	 * cartItem.getProductid()); if(existingcartitem == null ||
	 * existingcartitem.getId() == 0) { // If the item does not exist in the
	 * cartitem then add the item in cartitem
	 * assertEquals("Successfully added a category inside the table !", true,
	 * cartItemDAO.add(cartItem));
	 * 
	 * // Check if there is an entry for this userid in the cart Cart
	 * existingcart = cartDAO.getCartByUserId(cartItem.getUserid());
	 * if(existingcart == null || existingcart.getId() == 0) { // this happens
	 * when this is the first product for the user in the cart. so create a new
	 * cart (use add methodf) // If this is the first item, then add a row in
	 * the "cart" (dont consfuse with cartitem)
	 * cart.setTotalitems(cartItem.getQuantity());
	 * cart.setUserid(cartItem.getUserid());
	 * cart.setTotalvalueofitems(cartItem.getTotalprice());
	 * assertEquals("Successfully added a category inside the table !", true,
	 * cartDAO.add(cart)); } else { // new product being added to cartitem but
	 * cart entry already exists (some other productid added eariler) // so
	 * update the cart existingcart.setTotalitems(existingcart.getTotalitems() +
	 * cartItem.getQuantity()); existingcart.setUserid(cartItem.getUserid());
	 * existingcart.setTotalvalueofitems(existingcart.getTotalvalueofitems() +
	 * cartItem.getTotalprice());
	 * assertEquals("Successfully added a category inside the table !", true,
	 * cartDAO.update(existingcart)); } } else { // if the item exists increase
	 * the quantity by 1 and update the item
	 * existingcartitem.setQuantity(existingcartitem.getQuantity() +
	 * cartItem.getQuantity()); // means one more row in the cartitem table
	 * existingcartitem.setTotalprice(existingcartitem.getTotalprice() +
	 * cartItem.getTotalprice());
	 * assertEquals("Successfully added a category inside the table !", true,
	 * cartItemDAO.update(existingcartitem));
	 * 
	 * Cart existingcart = cartDAO.getCartByUserId(cartItem.getUserid());
	 * if(existingcart == null || existingcart.getId() == 0) { // code should
	 * not come here - ie cartitem exists but cart does not exist } else { //
	 * cart exists and needs to be updatedf
	 * 
	 * existingcart.setTotalitems(existingcart.getTotalitems() +
	 * cartItem.getQuantity()); existingcart.setUserid(cartItem.getUserid());
	 * existingcart.setTotalvalueofitems(existingcart.getTotalvalueofitems() +
	 * cartItem.getTotalprice());
	 * assertEquals("Successfully added a category inside the table !", true,
	 * cartDAO.update(existingcart)); }
	 * 
	 * 
	 * }
	 * 
	 * }
*/	 

	@Test
	public void testDeleteCartTtem() {
		CartItem cartItem = new CartItem();
		Cart cart = new Cart();

		cartItem.setUserid(1);
		cartItem.setProductid(1);
		cartItem.setQuantity(1);
		cartItem.setUnitprice(1000);

		cartItem.setTotalprice(cartItem.getUnitprice() * cartItem.getQuantity());

		CartItem existingcartitem = cartItemDAO.getCartByUserIdAndProduct(cartItem.getUserid(),
				cartItem.getProductid());

		if (existingcartitem == null || existingcartitem.getId() == 0) 
		{
			// this cannot and should not happen ie no cart with items in the
			// view
		} else 
		{
			if (existingcartitem.getQuantity() == 1)
				assertEquals("Successfully added a category inside the table !", true,cartItemDAO.delete(existingcartitem.getId()));
			else 
			{
				existingcartitem.setQuantity(existingcartitem.getQuantity() - 1);
				existingcartitem.setTotalprice(existingcartitem.getTotalprice() - cartItem.getUnitprice());
				assertEquals("Successfully added a category inside the table !", true,
						cartItemDAO.update(existingcartitem));
			}
		}

		Cart existingcart = cartDAO.getCartByUserId(cartItem.getUserid());
		if (existingcart == null || existingcart.getId() == 0) 
		{
			// this cannot and should not happen ie no cart with items in the
			// view

		} else 
		{
			if (existingcart.getTotalitems() == 1) 
			{
				// only one item in the cart. so delete it.
				assertEquals("Successfully added a category inside the table !", true,
						cartDAO.delete(existingcart.getUserid()));
			} 
			else 
			{
				existingcart.setTotalvalueofitems(existingcart.getTotalvalueofitems() - cartItem.getUnitprice()); // deleting
																													// one
																													// item
				existingcart.setTotalitems(existingcart.getTotalitems() - cartItem.getQuantity());
				assertEquals("Successfully added a category inside the table !", true, cartDAO.update(existingcart));
			}

		}
	}

}
