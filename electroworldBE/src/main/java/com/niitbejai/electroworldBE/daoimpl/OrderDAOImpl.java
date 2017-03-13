package com.niitbejai.electroworldBE.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitbejai.electroworldBE.dao.OrderDAO;
import com.niitbejai.electroworldBE.dto.Order;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO 
{
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public Order get(int id) 
	{
		return sessionFactory.getCurrentSession().get(Order.class, Integer.valueOf(id));	
	}

	@Override
	public Order getCartByUserId(int userId) 
	{
		String selectActiveCategory = "FROM Order WHERE userid = :parameter";
		
		Query<Order> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory, Order.class);
		
		query.setParameter("parameter", userId);
		
		return query.getSingleResult();				
	}
	
	@Override
	public List<Order> list(int userid) 
	{
		// v v imp here that the "Order" is the entity name and not the table name.
		// In case in the class when using the @Entity annotation is used, if no  name is given
		// then it default picks the class name as entity name.
		
		String selectActiveCategory = "FROM Order WHERE userid = :parameter";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("parameter", userid);
		
		return query.getResultList();			}

	@Override
	public boolean add(Order order) 
	{
		try
		{
			// persist this category in the database
			sessionFactory.getCurrentSession().persist(order);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
		
	}

	@Override
	public boolean update(Order order) 
	{
		try
		{
			// update this category in the database
			sessionFactory.getCurrentSession().update(order);
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
		Order order = this.get(id); 
		try
		{
			// delete this category from the database
			sessionFactory.getCurrentSession().delete(order);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		}



}
