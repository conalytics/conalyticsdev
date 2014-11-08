package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conalytics.domain.Claim;
import com.conalytics.jdbc.ClaimRowMapper;

public class ClaimDaoImpl implements ClaimDao {

	@Autowired
	DataSource dataSource;
	
	@Override
	public void insertClaim(Claim claim) {

		String sql = "INSERT INTO CLAIM (VIN, REPAIR_LOCATION_ID, AUTO_ID, COLOR, GCLAT,GCLONG , DATE) VALUES ( ?, ?, ?, ?, ?,?,CURDATE())";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						claim.getVIN(),
						claim.getLocation(),
						claim.getModelId(),
						claim.getColor(),
						claim.getGclat(),
						claim.getGclong()
						});

	}



	@Override
	public void deleteClaim(Double id) {
		String sql = "delete from CLAIM where CLAIM_ID=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateClaim(Claim claim) {

		String sql = "UPDATE CLAIM set  VIN=?, REPAIR_LOCATION_ID=?, AUTO_ID=?, COLOR=? ,GCLAT=?, GCLONG=? where CLAIM_ID = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						claim.getVIN(),
						claim.getLocation(),
						claim.getModelId(),
						claim.getColor(),
						claim.getGclat(),
						claim.getGclong(),
						claim.getClaimId()
						});

	}

	@Override
	public Claim getClaimbyId(Double id) {
		List<Claim> claimList = new ArrayList<Claim>();
		String sql = "select * from CLAIM where CLAIM_ID=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		claimList = jdbcTemplate.query(sql, new ClaimRowMapper());
		return claimList.get(0);

	}
	
	@Override
	public List<Claim> getClaimList() {
		List<Claim> claimList = new ArrayList<Claim>();

		String sql = "select * from CLAIM ";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		claimList = jdbcTemplate.query(sql, new ClaimRowMapper());
		
		
		
		return claimList;
	}


}
