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
	
	private static User userDAO;
	private User user;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niitbejai.electroworldBE");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("useryDAO");
		  
	}	
	
	@Test
	public void testAddUser()
	{
		user = new User();
		/*
		// first user
		user.setFname("Sachin");
		user.setSname("Tendulkar");
		user.setEmail("sachin.t@sansad.nic.in");
		user.setBillingaddress("19-A, Perry Cross Road, Bandra (West)");
		user.setCity("Mumbai");
		user.setState("Maharashtra");
		user.setZip("400050");
		*/
		
		/*
		//second user
		user.setFname("Amitabh");
		user.setSname("Bachchan");
		user.setEmail("amitabh.bachchan@gmail.com");
		user.setBillingaddress("Jalsa, B/2, Kapol Housing Society, VL Mehta Road, Juhu,");
		user.setCity("Mumbai");
		user.setState("Maharashtra");
		user.setZip("400049");
		*/
		
		//third user
		user.setFname("Lata");
		user.setSname("Mangeshkar");
		user.setEmail("lata.mangeshkar@gmail.com");
		user.setBillingaddress("101, Prabhu Kunj, Pedder Road");
		user.setCity("Mumbai");
		user.setState("Maharashtra");
		user.setZip("400032");
		
		assertEquals("Successfully added a category inside the table !", true, categoryDAO.add(category));
	}		

}
