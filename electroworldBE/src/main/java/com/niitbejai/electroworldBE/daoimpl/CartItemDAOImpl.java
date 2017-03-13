package com.niitbejai.electroworldBE.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitbejai.electroworldBE.dao.CartDAO;
import com.niitbejai.electroworldBE.dao.CartItemDAO;
import com.niitbejai.electroworldBE.dto.Cart;
import com.niitbejai.electroworldBE.dto.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO 
{
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	@Autowired
	private CartDAO cartDAO;	
	
	@Override
	public CartItem get(int id) 
	{
		return sessionFactory.getCurrentSession().get(CartItem.class, Integer.valueOf(id));	
	}
	
	@Override
	public CartItem getCartByUserId(int userId) 
	{
		
		String selectActiveCategory = "FROM CartItem WHERE userid = :parameter";
		
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory, CartItem.class);
		
		query.setParameter("parameter", userId);
		
		return query.getSingleResult();				
		
	}	
	
	@Override
	public CartItem getCartByUserIdAndProduct(int userId, int productId) 
	{
		
		String selectActiveCategory = "FROM CartItem WHERE userid = :param1 and productid = :param2";
		
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory, CartItem.class);
		
		query.setParameter("param1", userId);
		query.setParameter("param2", productId);
		
		try {
			// stragely getSingleResult is throwing an exception when there is no matching row in the table
			// hence catching the exception and returning null. - This needs further investigation.
			return query.getSingleResult();
		}
		catch(Exception ex)
		{
			return null;
		}
		
	}		

	@Override
	public List<CartItem> list(int userid) 
	{
		// v v imp here that the "cartitem" is the entity name and not the table name.
		// In case in the class when using the @Entity annotation is used, if no  name is given
		// then it default picks the class name as entity name.
		
		String selectActiveCategory = "FROM CartItem WHERE userid = :parameter";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("parameter", userid);
		
		return query.getResultList();			
	
	}

	@Override
	public boolean add(CartItem cartItem) 
	{
		try
		{
			// persist this category in the database
			sessionFactory.getCurrentSession().persist(cartItem);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean update(CartItem cartItem) 
	{
		try
		{
			// update this category in the database
			sessionFactory.getCurrentSession().update(cartItem);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
		
	}

	@Override
	public boolean delete(int id) 
	{

		CartItem cartItem = this.get(id); 
		try
		{
			// delete this category from the database
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
		
	}


	@Override
	public boolean deleteCartItemGivenCartItem(CartItem cartItem) 
	{
		helperDeleteCartItem(cartItem);
		return true;
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
		

}
