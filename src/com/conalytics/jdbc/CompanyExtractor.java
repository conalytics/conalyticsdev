package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Company;

public class CompanyExtractor implements ResultSetExtractor<Company> {

	public Company extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Company company = new Company();
		company.setCompanyId(resultSet.getDouble(1));
		company.setCompanyName(resultSet.getString(2));
		company.setCompanyDesc(resultSet.getString(3));
		company.setPhoneNumber(resultSet.getString(4));
		company.setWebsiteAddress(resultSet.getString(5));
		company.setEmailId(resultSet.getString(6));
		company.setAddress(resultSet.getString(7));	
		return company;
	}
}
