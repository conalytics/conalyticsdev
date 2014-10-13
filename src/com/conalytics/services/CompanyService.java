package com.conalytics.services;

import java.util.List;

import com.conalytics.domain.Company;

public interface CompanyService {
	public void insertData(Company company);

	public List<Company> getCompanyList();

	public void deleteData(Double id);

	public Company getCompany(Double id);

	public void updateData(Company company);
}
