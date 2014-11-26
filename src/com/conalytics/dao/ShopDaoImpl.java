package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;




import com.conalytics.domain.Shop;
import com.conalytics.jdbc.ShopRowMapper;

public class ShopDaoImpl implements ShopDao {

	@Autowired
	DataSource dataSource;

	@Override
	public void insertData(Shop shop) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO SHOP( CITY_ID, TOWN_MUNI, SHOP_NAME, SHOP_DESC, PHONE_NUMBER, WEBSITE, EMAIL, ADDRESS, STD_HRLY_LABOR_RATE) "
				+ "VALUES  ( ?, ?, ?, ?, ? ,?, ?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						shop.getCityId(),
						shop.getTownMuni(),
						shop.getShopName(),
						shop.getShopDesc(),
						shop.getPhoneNumber(),
						shop.getWebsite(),
						shop.getEmail(),
						shop.getAddress(),
						shop.getStdHrlyLaborRate()
							});
	}

	@Override
	public void updateData(Shop shop) {
		// TODO Auto-generated method stub
		

		String sql = "UPDATE SHOP set CITY_ID=?, TOWN_MUNI=?, SHOP_NAME=?, SHOP_DESC=?, PHONE_NUMBER=?, WEBSITE=?, EMAIL=?, ADDRESS=?, STD_HRLY_LABOR_RATE=?  where SHOP_ID = ?";
		
		System.out.println(shop.toString());
		System.out.println(sql);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						shop.getCityId(),
						shop.getTownMuni(),
						shop.getShopName(),
						shop.getShopDesc(),
						shop.getPhoneNumber(),
						shop.getWebsite(),
						shop.getEmail(),
						shop.getAddress(),
						shop.getStdHrlyLaborRate(),
						shop.getShopId()
							});
    
	}

	@Override
	public void deleteData(Double id) {
		// TODO Auto-generated method stub
		String sql = "delete from SHOP where shop_id=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}

	@Override
	public Shop getShopbyId(Double id) {
		// TODO Auto-generated method stub
		List<Shop> shopList = new ArrayList<Shop>();
		String sql = "select *,null from SHOP where SHOP_ID=" + id ;
		System.out.println(sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		shopList = jdbcTemplate.query(sql, new ShopRowMapper());
		return shopList.get(0);
	}
	
	@Override
	public List<Shop> getShopList() {
		// TODO Auto-generated method stub
		List<Shop> shopList = new ArrayList<Shop>();
		String sql = "select *,null from SHOP" ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		shopList = jdbcTemplate.query(sql, new ShopRowMapper());
		return shopList;	
	}
	
	
	@Override
	public List<Shop> getShopListwithinGC(String lat, String lon, String distanceinKM) {
		List<Shop> shopList = new ArrayList<Shop>();
		String sql = "select * ,Round("
				 + " ATAN2( " 
				 +        " SQRT( "
				 +            "POW(COS(RADIANS("+lat+")) * "
				 +                "SIN(RADIANS(GCLONG - "+lon+")),2) + "
				 +             "POW(COS(RADIANS(GCLAT)) * SIN(RADIANS("+lat+")) - "
				 + 				   "SIN(RADIANS(GCLAT)) * COS(RADIANS("+lat+")) * " 
				 +                 "COS(RADIANS(GCLONG - "+lon+")), 2)), "
				 +              "(SIN(RADIANS(GCLAT)) * SIN(RADIANS("+lat+")) + "
				 +              "COS(RADIANS(GCLAT)) * COS(RADIANS("+lat+")) * "
				 +              "COS(RADIANS(GCLONG -"+lon+"))) "
				 +              ") * 6372.795 ) AS distance "
				 + "from SHOP HAVING distance < "+  distanceinKM;
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println(sql);
		shopList = jdbcTemplate.query(sql, new ShopRowMapper());
		return shopList;	
	}




}
