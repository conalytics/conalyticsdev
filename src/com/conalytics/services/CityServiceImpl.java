package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.CityDao;
import com.conalytics.domain.City;


public class CityServiceImpl implements CityService {

	
	@Autowired
	CityDao cityDao;
	
	public void insertData(City city) {
		// TODO Auto-generated method stub
		cityDao.insertData(city);
	}

	@Override
	public List<City> getCityListbysid(Double stateid) {
		// TODO Auto-generated method stub
		
		return cityDao.getCityListbysid(stateid);
	}

	@Override
	public List<City> getCityList() {
		// TODO Auto-generated method stub
		
		return cityDao.getCityList();
	}
	
	@Override
	public void deleteData(Double cityid) {
		// TODO Auto-generated method stub
		cityDao.deleteData(cityid);
	}

	@Override
	public City getCitybyId(Double cityid) {
		// TODO Auto-generated method stub
		return cityDao.getCitybyId(cityid);
	}

	@Override
	public void updateData(City city) {
		// TODO Auto-generated method stub
		cityDao.updateData(city);
	}

	@Override
	public City getCitybyZip(String zipcode) {
		// TODO Auto-generated method stub
		return cityDao.getCitybyZip(zipcode);
	}

	


	
}
