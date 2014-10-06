package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.Auto;

public class AutoRowMapper implements RowMapper<Auto> {

	@Override
	public Auto mapRow(ResultSet resultSet, int line) throws SQLException {
		AutoExtractor autoExtractor = new AutoExtractor();
		return autoExtractor.extractData(resultSet);
	}

}
