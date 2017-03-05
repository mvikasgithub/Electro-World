package com.niitbejai.electroworldBE.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitbejai.electroworldBE.dao.ProductDAO;
import com.niitbejai.electroworldBE.dto.Product;

//Adding the Repository annotation to this class with parameter with the same name as the object created in the 
//admin controller class. These two names should MATCH.
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory; 	
	
	@Override
	public Product get(int id) 
	{
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() 
	{
		// v v imp here that the "Product" is the entity name and not the table name.
		// In case in the class when using the @Entity annotation is used, if no class name is given
		// then it default picks the class name as entity name.
		String selectActiveCategory = "FROM Product WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();	
	}

	@Override
	public boolean add(Product product) {
		try
		{
			// persist this category in the database
			sessionFactory.getCurrentSession().persist(product);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try
		{
			// update this category in the database
			sessionFactory.getCurrentSession().update(product);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		// instead of deleting what is usually done is to set the flag as false so that the fetch command 
		// ignores it. Makes it easy when the same item has to be added again
		product.setActive(false);
		
		try
		{
			// delete this category from the database
			sessionFactory.getCurrentSession().update(product);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

}
