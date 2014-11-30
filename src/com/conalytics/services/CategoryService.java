package com.conalytics.services;

import java.util.List;


import com.conalytics.domain.Category;

public interface CategoryService {
	
	

	public List<Category> getCategoryList();

	public List<Category> getCategoryList(Double id);
	
}
