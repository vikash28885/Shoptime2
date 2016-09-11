package com.niit.shoptime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Product {
      @Id
	   private String id;
	   private String name;
	   private String description;
	   private int price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Category getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	public Category getSupplier() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
	public void setCategory_id(String id2) {
		// TODO Auto-generated method stub
		
	}
	public void setSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}
	public void setSupplier_id(String id2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
