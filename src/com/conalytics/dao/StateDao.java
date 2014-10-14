package com.conalytics.dao;


import java.util.List;

import com.conalytics.domain.State;

public interface StateDao {
	public void insertData(State state);

	public void updateData(State state);

	public void deleteData(Double id);

	public State getStatebyId(Double id);
	
	public List<State> getStateList();

}
