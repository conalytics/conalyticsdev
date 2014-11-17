package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conalytics.domain.Auto;
import com.conalytics.jdbc.AutoRowMapper;

public class AutoDaoImpl implements AutoDao {

	@Autowired
	DataSource dataSource;

	public void insertData(Auto auto) {

		String sql = "INSERT INTO AUTO (AUTO_ID,COMPANY_ID, AUTO_NAME, AUTO_DESC, MODEL, VERSION, YEAR_BUILT) VALUES (?, ?, ?, ?, ?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { auto.getAutoId(),
						auto.getCompanyId(),
						auto.getAutoName(),
						auto.getAutoDesc(),
						auto.getModel(),
						auto.getVersion(),
						auto.getYearBuilt() });

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Auto> getAutoList() {
		List autoList = new ArrayList();

		String sql = "SELECT AUTO_ID, C.COMPANY_ID, C.COMPANY_NAME,  AUTO_NAME ,  AUTO_DESC ,  MODEL ,  VERSION ,  YEAR_BUILT "
					+ "FROM AUTO A, COMPANY C "
					+ "WHERE A.COMPANY_ID = C.COMPANY_ID";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		autoList = jdbcTemplate.query(sql, new AutoRowMapper());
		return autoList;
	}

	@Override
	public void deleteData(Double id) {
		String sql = "delete from AUTO where auto_id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(Auto auto) {

		String sql = "UPDATE AUTO set COMPANY_ID=?, AUTO_NAME=?, AUTO_DESC=?, MODEL=?, VERSION=?, YEAR_BUILT=? where AUTO_ID = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						auto.getCompanyId(),
						auto.getAutoName(),
						auto.getAutoDesc(),
						auto.getModel(),
						auto.getVersion(),
						auto.getYearBuilt(),
						auto.getAutoId()});

	}

	@Override
	public Auto getAuto(Double id) {
		List<Auto> autoList = new ArrayList<Auto>();
		String sql =  "SELECT AUTO_ID, C.COMPANY_ID, C.COMPANY_NAME,  AUTO_NAME ,  AUTO_DESC ,  MODEL ,  VERSION ,  YEAR_BUILT "
				+ "FROM AUTO A, COMPANY C "
				+ "WHERE A.COMPANY_ID = C.COMPANY_ID"
				+ " and auto_id= " + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		autoList = jdbcTemplate.query(sql, new AutoRowMapper());
		return autoList.get(0);
	}

	@Override
	public List<Auto> getAutoDetails(int autoYear, String searchText) {
		String sql = "SELECT AUTO_ID, C.COMPANY_ID, C.COMPANY_NAME,  AUTO_NAME ,  AUTO_DESC ,  MODEL ,  VERSION ,  YEAR_BUILT "
				+ "FROM AUTO A, COMPANY C "
				+ "WHERE A.COMPANY_ID = C.COMPANY_ID "
					+ " AND A.YEAR_BUILT = " + autoYear
					+ " AND ("
					+ " 	A.AUTO_NAME LIKE '" + searchText + "'"
					+ " OR  A.AUTO_DESC LIKE '" + searchText + "'"
					+ " OR  A.MODEL LIKE '" + searchText + "'"
					+ " OR  A.VERSION LIKE '" + searchText + "'"
					+ ")";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new AutoRowMapper());
	}

}
