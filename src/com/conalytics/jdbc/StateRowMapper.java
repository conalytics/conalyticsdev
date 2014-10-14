package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conalytics.domain.State;

public class StateRowMapper implements RowMapper<State> {

	@Override
	public State mapRow(ResultSet resultSet, int line) throws SQLException {
		StateExtractor stateExtractor = new StateExtractor();
		return stateExtractor.extractData(resultSet);
	}

}
