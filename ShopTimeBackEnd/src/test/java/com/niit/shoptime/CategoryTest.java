package com.niit.shoptime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoptime.dao.CategoryDAO;
import com.niit.shoptime.model.Category;
import com.niit.shoptime.model.Product;

public class CategoryTest {

	
	
	public static void main(String[] args){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		
    CategoryDAO categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	Category category = (Category)  context.getBean("category");
	
	
		category.setId("1001");
		category.setName("Electronics");
		category.setDescription("21135646");
		
		
		if(categoryDAO.save(category)== true){
			System.out.println("Category created success");
		}
		else{
			System.out.println("Not able to create the category");
		}
		
		
	}
}