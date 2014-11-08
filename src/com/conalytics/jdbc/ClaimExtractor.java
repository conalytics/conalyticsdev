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
		claim.setLocation(resultSet.getString(3));
		claim.setModelId(resultSet.getDouble(4));
		claim.setColor(resultSet.getString(5));
		claim.setDate(resultSet.getString(6));
        claim.setGclat(resultSet.getString(7));
        claim.setGclong(resultSet.getString(8));
       
		
		System.out.println(claim.toString());
		return claim;
	}

}
