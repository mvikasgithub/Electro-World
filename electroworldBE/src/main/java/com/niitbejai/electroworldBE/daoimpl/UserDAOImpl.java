package com.niitbejai.electroworldBE.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitbejai.electroworldBE.dao.UserDAO;
import com.niitbejai.electroworldBE.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 	
		

	@Override
	public User get(int id) 
	{	 
		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(id));
	
	}
	
	@Override
	public User getUserBuUsername(String username) 
	{
		
		String selectActiveCategory = "FROM User WHERE email = :parameter";
		
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory, User.class);
		
		query.setParameter("parameter", username);
		
		return query.getSingleResult();				
	}


	@Override
	public List<User> list() 
	{
		// v v imp here that the "User" is the entity name and not the table name.
		// In case in the class when using the @Entity annotation is used, if no class name is given
		// then it default picks the class name as entity name.
		
		String selectActiveCategory = "FROM User WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();		
	}

	@Override
	public String add(User user) 
	{
		try
		{
			// persist this category in the database
			sessionFactory.getCurrentSession().persist(user);
			return "true";	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "false";
		}	
	}

	@Override
	public String update(User user) 
	{
		try
		{
			// update this category in the database
			sessionFactory.getCurrentSession().update(user);
			return "true";	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "false";
		}		
	}

	@Override
	public boolean delete(int id) 
	{
		// instead of deleting what is usually done is to set the flag as false so that the fetch command 
		// ignores it. Makes it easy when the same item has to be added again
		User user = this.get(id); 
		user.setActive(false);
		
		try
		{
			// delete this category from the database
			sessionFactory.getCurrentSession().update(user);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
		
	}




}
