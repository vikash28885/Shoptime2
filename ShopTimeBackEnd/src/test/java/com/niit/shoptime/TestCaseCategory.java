package com.niit.shoptime;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoptime.dao.CategoryDAO;
import com.niit.shoptime.model.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDAO categoryDAO;
	
	
	@Autowired
    Category category;	
	
	AnnotationConfigApplicationContext context;
	
	//to initialise we need a metghod
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
		
	}
	
	@Test
	public void deleteCategoryTestCase(){
		category.setId("1001");
		boolean flag = categoryDAO.delete(category);
		assertEquals("deleteCategoryTestCase",flag,true);
	}
	
	@Test
	public void addCategoryTestCase(){
		category.setId("mob2");
		category.setName("Electronic");
		category.setDescription("gjkdhldhll");
		categoryDAO.save(category);
		assertEquals("addCategoryTestCase",categoryDAO.save(category), true);
	}
	
	
	@Test
	public void categoryListTestCase(){
		List<Category> list = categoryDAO.list();
		int rowcount = list.size();
		assertEquals("Category List Test Case", rowcount,0);
	}

	@Test
	public void updateCategoryTestCase(){
		category.setId("1");
		category.setName("Electronics");
		category.setDescription("samsung smart LED");
		assertEquals("updateCategoryTestCase",categoryDAO.update(category), true);
	}
	
	@Test
	public void getCategoryTestCase(){
		List<Category> list = categoryDAO.list();
		assertEquals("getCategoryTestCase",categoryDAO.get("1"), null);
	}
}
