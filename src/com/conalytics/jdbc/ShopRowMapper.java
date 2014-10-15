package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.Shop;

public class ShopRowMapper implements RowMapper<Shop> {

	@Override
	public Shop mapRow(ResultSet resultSet, int line) throws SQLException {
		ShopExtractor stateExtractor = new ShopExtractor();
		return stateExtractor.extractData(resultSet);
	}

}
