package com.niitbejai.electroworldBE.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; // make sure this is orm and not java

import com.niitbejai.electroworldBE.dao.CategoryDAO;
import com.niitbejai.electroworldBE.dto.Category;

//Adding the Repository annotation to this class with paramater with the same name as the object created in the 
// page controller class. These two names should MATCH.
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 

	/*
	 * Not needed after integrating with database 
	 
	private static List<Category> categories = new ArrayList<>();
	
	static
	{
		Category category = new Category();
		
		//Adding first category
		
		category.setId(1);
		category.setName("Television");
		category.setDescription("Sone Description for Television");
		category.setImageURL("CAT_1_Img.png");
		
		categories.add(category);
		
		category = new Category();
		
		//Adding second category
		
		category.setId(2);
		category.setName("Laptpp");
		category.setDescription("Sone Description for Laptop");
		category.setImageURL("CAT_2_Img.png");
		
		categories.add(category);	
		
		
		
		category = new Category();
		
		//Adding third category
		
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("Sone Description for Mobiles");
		category.setImageURL("CAT_3_Img.png");
		
		categories.add(category);		
	} 
	*/
	
	@Override
	public List<Category> list() {
		
		// v v imp here that the "Category" is the entity name and not the table name.
		// In case in the class when using the @Entity annotation is used, if no class name is given
		// then it default picks the class name as entity name.
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
		//return categories;
		
	}

	/*
	 * Method for getting a single category based on ID
	 */
	@Override
	public Category get(int id) {
		
		//loop through the list to search a caterogy with the given categoryid
		/* 
		 * Not needed after integrating with database
		 
		for(Category category: categories)
		{
			if(category.getId() == id)
				return category;
		}
		*/
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override 
	public boolean add(Category category) 
	{
		try
		{
			// persist this category in the database
			sessionFactory.getCurrentSession().persist(category);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
		
	}
	
	@Override 
	public boolean update(Category category) 
	{
		try
		{
			// update this category in the database
			sessionFactory.getCurrentSession().update(category);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
		
	}
	


	@Override
	public boolean delete(Category category) 
	{
		// instead of deleting what is usually done is to set the flag as false so that the fetch command 
		// ignores it. Makes it easy when the same item has to be added again
		category.setActive(false);
		
		try
		{
			// delete this category from the database
			sessionFactory.getCurrentSession().update(category);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

}
