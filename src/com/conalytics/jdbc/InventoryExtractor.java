package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Inventory;

public class InventoryExtractor implements ResultSetExtractor<Inventory> {

	public Inventory extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Inventory invent = new Inventory();
		invent.setSHOP_PART_ID(resultSet.getDouble(1));
		invent.setSHOP_ID(resultSet.getDouble(2));
		invent.setPART_ID(resultSet.getDouble(3));

		invent.setQTY_AVAILABLE(resultSet.getDouble(4));
		invent.setPRICE_PER_UNIT(resultSet.getDouble(5));
		invent.setRTL_PRICE_PER_UNIT(resultSet.getDouble(6));
		invent.setSTD_HRLY_PART_LABOR_RATE(resultSet.getDouble(7));	
		invent.setImage(resultSet.getBlob(8));
		return invent;
	}
}
