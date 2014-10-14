package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.City;

public class CityRowMapper implements RowMapper<City> {

	@Override
	public City mapRow(ResultSet resultSet, int line) throws SQLException {
		CityExtractor cityExtractor = new CityExtractor();
		return cityExtractor.extractData(resultSet);
	}

}
