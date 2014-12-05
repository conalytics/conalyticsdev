package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conalytics.domain.Part;
import com.conalytics.jdbc.PartRowMapper;

public class PartDaoImpl implements PartDao {

	@Autowired
	DataSource dataSource;

	public void insertData(Part part) {

		String sql = "INSERT INTO PART(PART_ID, AUTO_ID, PART_NAME, PART_DESC, MODEL, VERSION, YEAR_BUILT, OEM_NUMBER, COLOUR, MSRP) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { part.getPartId(),
						part.getAutoId(),
						part.getPartName(),
						part.getPartDesc(),
						part.getModel(),
						part.getVersion(),
						part.getYearBuilt(),
						part.getOemNumber(),
						part.getColor(),
						part.getMsrp() });

	}

	public List<Part> getPartList() {
		List partList = new ArrayList();

		String sql = "select * from PART";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		partList = jdbcTemplate.query(sql, new PartRowMapper());
		return partList;
	}

	@Override
	public void deleteData(Double id) {
		String sql = "delete from PART where part_id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(Part part) {

		String sql = "UPDATE PART SET AUTO_ID=?, PART_NAME=?, PART_DESC=?, MODEL=?, VERSION=?, YEAR_BUILT=?, OEM_NUMBER=?, COLOUR=?, MSRP=? "
				+ "WHERE PART_ID=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						part.getAutoId(),
						part.getPartName(),
						part.getPartDesc(),
						part.getModel(),
						part.getVersion(),
						part.getYearBuilt(),
						part.getOemNumber(),
						part.getColor(),
						part.getMsrp(),
						part.getPartId()});

	}

	@Override
	public Part getPart(Double id) {
		List<Part> partList = new ArrayList<Part>();
		String sql = "select * from PART where part_id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		partList = jdbcTemplate.query(sql, new PartRowMapper());
		return partList.get(0);
	}
	
	
	@Override
	public List<Part> getPartsdata() {
		return getPartsdata(null, null);
	}

	@Override
	public List<Part> getPartsdata(Double catId, Double autoId) {
		// TODO Auto-generated method stub
		// String sql ="select * from PART where CATEGORY_ID="+catId+" and AUTO_ID="+AutoId;
		String sql ="select `PART_ID`, `AUTO_ID`, `PART_NAME`, `PART_DESC`, `MODEL`, `VERSION`, `YEAR_BUILT`, `OEM_NUMBER`, `COLOUR`, `MSRP`, `CATEGORY_ID`, C.`CATEGORY_DESC` "
				+ " from PART P, CATEGORY C "
				+ " where C.ID = P.CATEGORY_ID";
		if(null != catId) {
			sql =  sql + " and P.CATEGORY_ID=" + catId;
		}
		if(null != autoId) {
			sql = sql +  " and P.AUTO_ID="+autoId;
		}
        System.out.println(sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Part> invPart = new ArrayList<Part>();
		invPart = jdbcTemplate.query(sql, new PartRowMapper());
		return invPart;	
	}

}
