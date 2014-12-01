package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conalytics.domain.Category;
import com.conalytics.jdbc.CategoryRowMapper;

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	DataSource dataSource;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub

			List categoryList = new ArrayList();

			String sql = "SELECT * FROM CATEGORY order by CATEGORY_DESC";

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			categoryList = jdbcTemplate.query(sql, new CategoryRowMapper());
			return categoryList;
		}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Category> getCategoryList(Double id) {
		
		// TODO Auto-generated method stub

		List categoryList = new ArrayList();

		String sql = "SELECT * FROM CATEGORY WHERE ID ='"+id+"'";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		categoryList = jdbcTemplate.query(sql, new CategoryRowMapper());
		return categoryList;
	}

	
}
