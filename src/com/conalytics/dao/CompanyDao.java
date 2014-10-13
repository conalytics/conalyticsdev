package com.conalytics.dao;

import java.util.List;

import com.conalytics.domain.Company;

public interface CompanyDao {
	public void insertData(Company company);

	public List<Company> getCompanyList();

	public void updateData(Company company);

	public void deleteData(Double id);

	public Company getCompany(Double id);

}
