package com.conalytics.services;

import java.util.ArrayList;
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
	public void deleteData(Double id) {
		autodao.deleteData(id);
		
	}

	@Override
	public Auto getAuto(Double id) {
		return autodao.getAuto(id);
	}

	@Override
	public void updateData(Auto auto) {
		autodao.updateData(auto);
	}

	public List<String> getAutoname(String query) {
	        String autoName = null;
	        query = query.toLowerCase();
	        List<String> matched = new ArrayList<String>();
	        List<Auto> ali= getAutoList();
	        
	        for(int i=0; i< ali.size(); i++) {
	        	autoName = ali.get(i).getAutoName().toLowerCase();
	            if(autoName.startsWith(query)) {
	                matched.add(ali.get(i).getAutoName());
	            }
	        }
	        return matched;
	    }
	
}
