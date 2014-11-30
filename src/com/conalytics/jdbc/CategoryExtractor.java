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
		
		cat.setID(resultSet.getDouble(1));
		cat.setCATEGORY_CODE(resultSet.getString(2));
		cat.setCATEGORY_DESC(resultSet.getString(3));
		cat.setPARENT_CATEGORYID(resultSet.getDouble(4));
		
		
		return cat;
	}

}
