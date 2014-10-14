package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.City;

public class CityExtractor implements ResultSetExtractor<City> {

	public City extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		City city = new City();
		city.setCityId(resultSet.getDouble(1));
		city.setCityDesc(resultSet.getString(2));
		city.setCityABB(resultSet.getString(3));
		city.setDistrictID(resultSet.getDouble(4));
		city.setDistrictDesc(resultSet.getString(5));
		city.setStateID(resultSet.getDouble(6));
		city.setStateDesc(resultSet.getString(7));
		return city;
	}

}
