package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.Claim;

public class ClaimRowMapper implements RowMapper<Claim> {

	@Override
	public Claim mapRow(ResultSet resultSet, int line) throws SQLException {
		ClaimExtractor claimExtractor = new ClaimExtractor();
		return claimExtractor.extractData(resultSet);
	}

}
