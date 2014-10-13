package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conalytics.domain.Company;
import com.conalytics.jdbc.AutoRowMapper;
import com.conalytics.jdbc.CompanyRowMapper;

public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	DataSource dataSource;

	public void insertData(Company company) {

		String sql = "INSERT INTO COMPANY(COMPANY_ID, COMPANY_NAME, COMPANY_DESC, PHONE_NUMBER, WEBSITE, EMAIL, ADDRESS) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { company.getCompanyId(), company.getCompanyName(), company.getCompanyDesc(),
						company.getPhoneNumber(), company.getWebsiteAddress(), company.getEmailId(), company.getAddress() });

	}

	public List<Company> getCompanyList() {
		List companyList = new ArrayList();

		String sql = "select * from COMPANY";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		companyList = jdbcTemplate.query(sql, new CompanyRowMapper());
		return companyList;
	}

	@Override
	public void deleteData(Double id) {
		String sql = "delete from COMPANY where company_id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(Company company) {

		String sql = "UPDATE COMPANY SET COMPANY_NAME=?,COMPANY_DESC=?,PHONE_NUMBER=?,WEBSITE=?,EMAIL=?,ADDRESS=? "
				+ "WHERE COMPANY_ID=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { company.getCompanyName(), company.getCompanyDesc(), company.getPhoneNumber(), company.getWebsiteAddress(), 
								company.getEmailId(), company.getAddress(), company.getCompanyId() });

	}

	@Override
	public Company getCompany(Double id) {
		List<Company> companyList = new ArrayList<Company>();
		String sql = "select * from COMPANY where company_id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		companyList = jdbcTemplate.query(sql, new CompanyRowMapper());
		return companyList.get(0);
	}

}
