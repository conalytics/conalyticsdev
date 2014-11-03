package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.Repair;

public class RepairRowMapper implements RowMapper<Repair> {

	@Override
	public Repair mapRow(ResultSet resultSet, int line) throws SQLException {
		RepairExtractor repairExtractor = new RepairExtractor();
		return repairExtractor.extractData(resultSet);
	}

}
