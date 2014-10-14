package com.conalytics.dao;

import java.util.List;


import com.conalytics.domain.City;

public interface CityDao {
	public void insertData(City city);

	public void updateData(City city);

	public void deleteData(Double id);

	public List<City> getCityListbysid(Double stateid);
	
	public List<City> getCityList();

	public City getCitybyId(Double cityid);

	public City getCitybyZip(String zipcode);

}
