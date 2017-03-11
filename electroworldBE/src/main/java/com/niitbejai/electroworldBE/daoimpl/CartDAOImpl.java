package com.niitbejai.electroworldBE.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitbejai.electroworldBE.dao.CartDAO;
import com.niitbejai.electroworldBE.dto.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO 
{
	
	@Autowired
	private SessionFactory sessionFactory; 		

	@Override
	public Cart get(int id) 
	{
		return sessionFactory.getCurrentSession().get(Cart.class, Integer.valueOf(id));	
		
	}
	
	@Override
	public Cart getCartByUserId(int userId) 
	{
		
		String selectActiveCategory = "FROM Cart WHERE userid = :parameter";
		
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory, Cart.class);
		
		query.setParameter("parameter", userId);
		
		try
		{
			return query.getSingleResult();
		}
		catch(Exception ex)
		{
			return null;
		}
	}	

	@Override
	public List<Cart> list() 
	{
		// v v imp here that the "cart" is the entity name and not the table name.
		// In case in the class when using the @Entity annotation is used, if no  name is given
		// then it default picks the class name as entity name.
		
		String selectActiveCategory = "FROM Cart WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();			
	}

	@Override
	public boolean add(Cart cart) 
	{
		try
		{
			// persist this category in the database
			sessionFactory.getCurrentSession().persist(cart);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean update(Cart cart) 
	{
		try
		{
			// update this category in the database
			sessionFactory.getCurrentSession().update(cart);
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

		Cart cart = this.get(id); 
		try
		{
			// delete this category from the database
			sessionFactory.getCurrentSession().delete(cart);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

}
