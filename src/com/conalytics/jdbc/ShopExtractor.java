package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Shop;

public class ShopExtractor implements ResultSetExtractor<Shop> {

	public Shop extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Shop shop = new Shop();
		shop.setShopId(resultSet.getDouble(1));
		shop.setCityId(resultSet.getDouble(2));
		shop.setTownMuni(resultSet.getString(3));
		shop.setShopName(resultSet.getString(4));
		shop.setShopDesc(resultSet.getString(5));
		shop.setPhoneNumber(resultSet.getString(6));
		shop.setWebsite(resultSet.getString(7));
		shop.setEmail(resultSet.getString(8));
		shop.setAddress(resultSet.getString(9));
		shop.setStdHrlyLaborRate(resultSet.getDouble(10));
		return shop;
	}

}
