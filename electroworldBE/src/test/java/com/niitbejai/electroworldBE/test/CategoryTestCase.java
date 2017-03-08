package com.niitbejai.electroworldBE.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niitbejai.electroworldBE.dao.CategoryDAO;
import com.niitbejai.electroworldBE.dto.Category;
import com.niitbejai.electroworldBE.dto.User;

public class CategoryTestCase 
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	

	private Category category;

	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niitbejai.electroworldBE");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		  
		
	}
	

/*	
	@Test
	public void testAddCategory()
	{
		category = new Category();
		
		category.setName("Television");
		category.setDescription("Sone Description for Television");
		category.setImageURL("CAT_1_Img.png");
		
		assertEquals("Successfully added a category inside the table !", true, categoryDAO.add(category));
	}
*/
/*	
	@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(1);
		
		assertEquals("Successfully fetched a single category from the table !", "Television", category.getName());
	}
*/	
/*	
	@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.get(1);
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table !", true, categoryDAO.update(category));
	}
*/
/*	
	@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.get(1);
		
		assertEquals("Successfully deleted a single category in the table !", true, categoryDAO.delete(category));
	}
*/
/*	
	@Test
	public void testListCategory()
	{
		assertEquals("Successfully fetched the list of categories from the table !", 1, categoryDAO.list().size());
	}
*/
/*	
	@Test
	public void testCRUDCategory()
	{
		// Add an item
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("Sone Description for Laptop");
		category.setImageURL("CAT_2_Img.png");
		
		assertEquals("Successfully added a category inside the table !", true, categoryDAO.add(category));
		
		// Add another item
		category = new Category();
		
		category.setName("Mobil"); // purposefully inserting a typo. which will be updated 
		category.setDescription("Sone Description for Mobile");
		category.setImageURL("CAT_3_Img.png");
		
		assertEquals("Successfully added a category inside the table !", true, categoryDAO.add(category));
		
		// Now update the name from Mobil to Mobile
		category = categoryDAO.get(3);
		category.setName("Mobile");
		
		assertEquals("Successfully updated a single category in the table !", true, categoryDAO.update(category));

		// Deleting (actaully setting active=false for the item with id = 2
		category = categoryDAO.get(2);
		
		assertEquals("Successfully deleted a single category in the table !", true, categoryDAO.delete(category));

		// Now count the number of active items
		assertEquals("Successfully fetched the list of categories from the table !", 2, categoryDAO.list().size());

		// Now update item with id=2 to active=true
		// Deleting (actaully setting active=false for the item with id = 2
		category = categoryDAO.get(2);

		category.setActive(true);
		assertEquals("Successfully deleted a single category in the table !", true, categoryDAO.update(category));

		// Now count the number of active items and it should be 3
		assertEquals("Successfully fetched the list of categories from the table !", 3, categoryDAO.list().size());
		
	}
*/	
}
