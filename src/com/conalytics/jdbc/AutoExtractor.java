package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Auto;

public class AutoExtractor implements ResultSetExtractor<Auto> {

	public Auto extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Auto auto = new Auto();
		auto.setAutoId(resultSet.getDouble(1));
		auto.setCompanyId(resultSet.getDouble(2));
		auto.setCompanyName(resultSet.getString(3));
		auto.setAutoName(resultSet.getString(4));
		auto.setAutoDesc(resultSet.getString(5));
		auto.setModel(resultSet.getString(6));
		auto.setVersion(resultSet.getString(7));
		auto.setYearBuilt(resultSet.getDouble(8));
		return auto;
	}

}
