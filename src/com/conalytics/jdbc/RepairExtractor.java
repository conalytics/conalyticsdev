package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Repair;

public class RepairExtractor implements ResultSetExtractor<Repair> {

	public Repair extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Repair repair = new Repair();
		
		repair.setRepairId(resultSet.getDouble(1));
		repair.setRepairDesc(resultSet.getString(2));
		repair.setClaimId(resultSet.getDouble(3));
		repair.setPartId(resultSet.getDouble(4));
		repair.setPartDesc(resultSet.getString(5));
		repair.setQuantity(resultSet.getDouble(6));
		repair.setShopid(resultSet.getDouble(7));
       
		
		System.out.println(repair.toString());
		return repair;
	}

}
