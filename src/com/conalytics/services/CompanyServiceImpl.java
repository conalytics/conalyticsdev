package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.CompanyDao;
import com.conalytics.domain.Company;


public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companydao;

	@Override
	public void insertData(Company company) {
		companydao.insertData(company);
	}

	@Override
	public List<Company> getCompanyList() {
		return companydao.getCompanyList();
	}

	@Override
	public void deleteData(Double id) {
		companydao.deleteData(id);
		
	}

	@Override
	public Company getCompany(Double id) {
		return companydao.getCompany(id);
	}

	@Override
	public void updateData(Company company) {
		companydao.updateData(company);
		
	}


	
}
