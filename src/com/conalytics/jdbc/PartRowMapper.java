package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.Part;

public class PartRowMapper implements RowMapper<Part> {

	@Override
	public Part mapRow(ResultSet resultSet, int line) throws SQLException {
		PartExtractor partExtractor = new PartExtractor();
		return partExtractor.extractData(resultSet);
	}

}
