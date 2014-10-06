package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.AutoDao;
import com.conalytics.domain.Auto;


public class AutoServiceImpl implements AutoService {

	@Autowired
	AutoDao autodao;

	@Override
	public void insertData(Auto auto) {
		autodao.insertData(auto);
	}

	@Override
	public List<Auto> getAutoList() {
		return autodao.getAutoList();
	}

	@Override
	public void deleteData(String id) {
		autodao.deleteData(id);
		
	}

	@Override
	public Auto getAuto(String id) {
		return autodao.getAuto(id);
	}

	@Override
	public void updateData(Auto auto) {
		autodao.updateData(auto);
		
	}


	
}
