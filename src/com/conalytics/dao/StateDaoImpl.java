package com.conalytics.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



import com.conalytics.domain.State;
import com.conalytics.jdbc.StateRowMapper;

public class StateDaoImpl implements StateDao {

	@Autowired
	DataSource dataSource;

	@Override
	public void insertData(State state) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO STATE (STATE_ID,STATE_DESC, STATE_ABB) VALUES (?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						state.getId(),
						state.getStateDesc(),
						state.getStateABB()
							});
	}

	@Override
	public void updateData(State state) {
		// TODO Auto-generated method stub
		

		String sql = "UPDATE STATE set STATE_DESC=?,STATE_ABB=?  where STATE_ID = ?";
		
		System.out.println(state.toString());
		System.out.println(sql);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 

						state.getStateDesc(),
						state.getStateABB(),
						state.getId()
							});
    
	}

	@Override
	public void deleteData(Double id) {
		// TODO Auto-generated method stub
		String sql = "delete from STATE where state_id=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}

	@Override
	public State getStatebyId(Double id) {
		// TODO Auto-generated method stub
		List<State> stateList = new ArrayList<State>();
		String sql = "select * from STATE where STATE_ID=" + id ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		stateList = jdbcTemplate.query(sql, new StateRowMapper());
		return stateList.get(0);
	}
	
	public List<State> getStateList() {
		List<State> stateList = new ArrayList<State>();
		String sql = "select * from STATE" ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		stateList = jdbcTemplate.query(sql, new StateRowMapper());
		return stateList;	
	}


}
