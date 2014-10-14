package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.State;

public class StateExtractor implements ResultSetExtractor<State> {

	public State extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		State state = new State();
		state.setId(resultSet.getDouble(1));
		state.setStateDesc(resultSet.getString(2));
		state.setStateABB(resultSet.getString(3));

		return state;
	}

}
