package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.CategoryDao;
import com.conalytics.domain.Category;


public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	CategoryDao catDao;

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return catDao.getCategoryList();
	}

	@Override
	public List<Category> getCategoryList(Double id) {
		// TODO Auto-generated method stub
		return catDao.getCategoryList(id);
	}
	
		
}
