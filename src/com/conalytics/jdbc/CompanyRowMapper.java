package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.Company;

public class CompanyRowMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet resultSet, int line) throws SQLException {
		CompanyExtractor companyExtractor = new CompanyExtractor();
		return companyExtractor.extractData(resultSet);
	}

}
