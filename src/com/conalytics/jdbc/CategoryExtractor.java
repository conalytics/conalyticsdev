package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Category;;

public class CategoryExtractor implements ResultSetExtractor<Category> {

	public Category extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Category cat = new Category();
		
		cat.setId(resultSet.getDouble(1));
		cat.setCategoryCode(resultSet.getString(2));
		cat.setCategoryDesc(resultSet.getString(3));
		cat.setParentCategoryId(resultSet.getDouble(4));
		
		
		return cat;
	}

}
