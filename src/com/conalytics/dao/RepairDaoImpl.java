package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conalytics.domain.Repair;
import com.conalytics.jdbc.RepairRowMapper;

public class RepairDaoImpl implements RepairDao {

	@Autowired
	DataSource dataSource;
	
	@Override
	public void insertRepair(Repair repair) {

		String sql = "INSERT INTO REPAIR_LIST (REPAIR_DESC, CLAIM_ID, PART_ID, PARTS_DESC, QUANTITY) VALUES ( ?, ?, ?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						repair.getRepairDesc(),
						repair.getClaimId(),
						repair.getPartId(),
						repair.getPartDesc(),
						repair.getQuantity()
				 });

	}


	@Override
	public void deleteRepair(Double id) {
		// TODO Auto-generated method stub
		String sql = "delete from REPAIR_LIST where ID=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}

	@Override
	public void deleteRepairbyClaim(Double claimid) {
		// TODO Auto-generated method stub
		String sql = "delete from REPAIR_LIST where CLAIM_ID=" + claimid.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}

	@Override
	public void updateRepair(Repair repair) {
		// TODO Auto-generated method stub
		String sql = "UPDATE REPAIR_LIST set  REPAIR_DESC=?, PART_ID=?, PARTS_DESC=? , QUANTITY=? where ID = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						repair.getRepairDesc(),
						repair.getPartId(),
						repair.getPartDesc(),
						repair.getQuantity() });
		
	}

	@Override
	public void updateShopIdRepair(Double repairId, Double shopId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE REPAIR_LIST set  SHOP_ID=? where ID = ?";
		System.out.println(sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { shopId , repairId });
		
	}

	@Override
	public void updateShopIdRepair(Double repairId, Double shopId , Double partId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE REPAIR_LIST set  SHOP_ID=?,PART_ID=? where ID = ?";
		System.out.println(sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { shopId ,partId, repairId });
		
	}
	
	@Override
	public List<Repair> getRepairList(Double id) {
		// TODO Auto-generated method stub
		List<Repair> repairList = new ArrayList<Repair>();
		String sql = "select * from REPAIR_LIST where CLAIM_ID=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		repairList = jdbcTemplate.query(sql, new RepairRowMapper());
		System.out.println(sql);
		System.out.println(repairList.size());
		return repairList;
	}

	
	@Override
	public Repair getRepairListId(Double id) {
		// TODO Auto-generated method stub
		List<Repair> repairList = new ArrayList<Repair>();
		String sql = "select * from REPAIR_LIST where ID=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		repairList = jdbcTemplate.query(sql, new RepairRowMapper());
		System.out.println(sql);
		System.out.println(repairList.size());
		return repairList.get(0);
	}

}
