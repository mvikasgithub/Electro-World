package com.niitbejai.electroworldBE.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niitbejai.electroworldBE.dao.UserDAO;
import com.niitbejai.electroworldBE.dto.User;

public class UserTestCase 
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	private User user;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niitbejai.electroworldBE");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		  
	}	

/*
	@Test
	public void testAddUser()
	{
		user = new User();
		
		
//		// first user
//		user.setFname("Sachin");
//		user.setSname("Tendulkar");
//		user.setEmail("sachin.t@sansad.nic.in");
//		user.setPassword("123");
//		user.setBillingaddress("19-A, Perry Cross Road, Bandra (West)");
//		user.setCity("Mumbai");
//		user.setState("Maharashtra");
//		user.setZip("400050");
//		user.setPhoneno("123456789");
//		user.setRole("customer");
		
		
		
		//second user
//		user.setFname("Amitabh");
//		user.setSname("Bachchan");
//		user.setEmail("amitabh.b@gmail.com");
//		user.setPassword("123");
//		user.setBillingaddress("Jalsa, B/2, Kapol Housing Society, Juhu,");
//		user.setCity("Mumbai");
//		user.setState("Maharashtra");
//		user.setZip("400049");
//		user.setPhoneno("123456789");
//		user.setRole("customer");
		
		//third user
//		user.setFname("Lata");
//		user.setSname("Mangeshkar");
//		user.setEmail("lata.m@gmail.com");
//		user.setPassword("123");
//		user.setBillingaddress("101, Prabhu Kunj, Pedder Road");
//		user.setCity("Mumbai");
//		user.setState("Maharashtra");
//		user.setZip("400032");
//		user.setPhoneno("123456789");
//		user.setRole("customer");		
		
		
		assertEquals("Successfully added a category inside the table !", "true", userDAO.add(user));
	}		



/*	@Test
	public void testAddUser()
	{
		user = new User();
		
		user.setFname("Thirery");
		user.setSname("Henry");
		user.setEmail("thierry.henry@gmail.com");
		user.setPassword("123");
		user.setBillingaddress("Paris, France");
		user.setCity("Paris");
		user.setState("Paris Central");
		user.setZip("400032");
		user.setPhoneno("123456789");
		
		assertEquals("Successfully added a category inside the table !", true, userDAO.add(user));
	}	*/
	
/*	@Test
	public void testGetUser()
	{
		user = userDAO.get(3);
		
		assertEquals("Successfully fetched a single category from the table !", "Sachin", user.getFname());
	}	*/
	
	
/*	@Test
	public void testUpdateUser()
	{
		user = userDAO.get(6);
		user.setEmail("a.bachchan@gmail.com");
		
		assertEquals("Successfully updated a single category in the table !", true, userDAO.update(user));
	}	*/
	
/*	@Test
	public void testDeleteUser()
	{
		//user = userDAO.get(8);
		
		assertEquals("Successfully deleted a single category in the table !", true, userDAO.delete(8));
	}*/ 	
}