package com.conalytics.services;

import java.util.List;

import com.conalytics.domain.City;

public interface CityService {
	public void insertData(City city);

	public List<City> getCityListbysid(Double stateid);

	public void deleteData(Double cityid);

	public City getCitybyId(Double cityid);

	public void updateData(City city);
	
	public City getCitybyZip(String zipcode);
	
	public List<City> getCityList();
}
