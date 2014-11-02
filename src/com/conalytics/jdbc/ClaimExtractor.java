package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Claim;

public class ClaimExtractor implements ResultSetExtractor<Claim> {

	public Claim extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Claim claim = new Claim();
		
		claim.setClaimId(resultSet.getDouble(1));
		claim.setVIN(resultSet.getString(2));
		claim.setShopId(resultSet.getDouble(3));
		claim.setModelId(resultSet.getDouble(4));
		claim.setColor(resultSet.getString(5));
		claim.setDate(resultSet.getString(6));
       
		
		System.out.println(claim.toString());
		return claim;
	}

}
