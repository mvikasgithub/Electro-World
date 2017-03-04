package com.niitbejai.electroworldBE.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niitbejai.electroworldBE.dao.CategoryDAO;
import com.niitbejai.electroworldBE.dto.Category;

//Adding the Repository annotation to this class with paramater with the same name as the object created in the 
// page controller class. These two names should MATCH.
@Repository("categoryDAO") 
public class CategoryDAOImpl implements CategoryDAO {

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
	
	@Override
	public List<Category> list() {
		
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//loop through the list to search a caterogy with the given categoryid
		
		for(Category category: categories)
		{
			if(category.getId() == id)
				return category;
		}
		
		return null;
	}

}
