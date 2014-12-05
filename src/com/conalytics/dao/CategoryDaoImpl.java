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

	public List<Category> getCategoryList() {
		String sql = "SELECT * FROM CATEGORY order by CATEGORY_DESC";
		return getList(sql);
	}

	public List<Category> getParentCategoryList() {
		String sql = "SELECT * FROM CATEGORY where PARENT_CATEGORYID is NULL order by CATEGORY_DESC";
		return getList(sql);
	}

	@Override
	public List<Category> getCategoryList(Double id) {
		String sql = "SELECT * FROM CATEGORY WHERE ID ='" + id + "'";
		return getList(sql);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Category> getList(String sql) {
		List categoryList = new ArrayList();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		categoryList = jdbcTemplate.query(sql, new CategoryRowMapper());
		return categoryList;

	}
}
