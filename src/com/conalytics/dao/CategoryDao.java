package com.conalytics.dao;

import java.util.List;

import com.conalytics.domain.Category;

public interface CategoryDao {

	public List<Category> getCategoryList();
	
	public List<Category> getCategoryList(Double id);
	
	
}
