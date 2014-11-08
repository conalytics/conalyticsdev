package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.Inventory;

public class InventoryRowMapper implements RowMapper<Inventory> {

	@Override
	public Inventory mapRow(ResultSet resultSet, int line) throws SQLException {
		InventoryExtractor invExtractor = new InventoryExtractor();
		return invExtractor.extractData(resultSet);
	}

}
