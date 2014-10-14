package com.conalytics.services;


import java.util.List;


import com.conalytics.domain.State;

public interface StateService {
	public void insertData(State state);

    public void deleteData(Double stateid);

	public State getStatebyId(Double stateid);

	public void updateData(State state);
	
	public List<State> getStateList();

}
