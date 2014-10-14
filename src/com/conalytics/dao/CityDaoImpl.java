package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conalytics.domain.City;
import com.conalytics.jdbc.CityRowMapper;

public class CityDaoImpl implements CityDao {

	@Autowired
	DataSource dataSource;

	public void insertData(City city) {

		String sql = "INSERT INTO CITY (CITY_ID,CITY_DESC, CITY_ABB, DISTRICT_ID, DISTRICT_DESC, STATE_ID, STATE_DESC) VALUES (?, ?, ?, ?, ?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						city.getCityId(),
						city.getCityDesc(),
						city.getCityABB(),
						city.getDistrictID(),
						city.getDistrictDesc(),
						city.getStateID(),
						city.getStateDesc() });

	}



	@Override
	public void deleteData(Double id) {
		String sql = "delete from CITY where city_id=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(City city) {

		String sql = "UPDATE CITY set  CITY_DESC=?, CITY_ABB=?, DISTRICT_ID=?, DISTRICT_DESC=?, STATE_ID=?, STATE_DESC=? where CITY_ID = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						city.getCityDesc(),
						city.getCityABB(),
						city.getDistrictID(),
						city.getDistrictDesc(),
						city.getStateID(),
						city.getStateDesc() });

	}

	@Override
	public City getCitybyId(Double id) {
		List<City> cityList = new ArrayList<City>();
		String sql = "select * from CITY where CITY_ID=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cityList = jdbcTemplate.query(sql, new CityRowMapper());
		return cityList.get(0);

	}
	
	
	public City getCitybyZip(String zipcode) {
		List<City> cityList = new ArrayList<City>();
		String sql = "select * from CITY where ZIP_CODE='" + zipcode +"'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cityList = jdbcTemplate.query(sql, new CityRowMapper());
		return cityList.get(0);

	}
	
	
	public List<City> getCityListbysid(Double stateid) {
		List<City> cityList = new ArrayList<City>();

		String sql = "select * from CITY where STATE_ID=" + stateid.doubleValue();

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cityList = jdbcTemplate.query(sql, new CityRowMapper());
		return cityList;
	}
	
	
	public List<City> getCityList() {
		List<City> cityList = new ArrayList<City>();

		String sql = "select * from CITY ";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cityList = jdbcTemplate.query(sql, new CityRowMapper());
		return cityList;
	}
}
