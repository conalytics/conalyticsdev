package com.conalytics.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.StateDao;
import com.conalytics.domain.State;


public class StateServiceImpl implements StateService {
	@Autowired
	StateDao stateDao;

	@Override
	public void insertData(State state) {
		// TODO Auto-generated method stub
		stateDao.insertData(state);
	}

	@Override
	public void deleteData(Double stateid) {
		// TODO Auto-generated method stub
		stateDao.deleteData(stateid);
	}

	@Override
	public State getStatebyId(Double stateid) {
		// TODO Auto-generated method stub
		return stateDao.getStatebyId(stateid);
	}

	@Override
	public void updateData(State state) {
		// TODO Auto-generated method stub
		stateDao.updateData(state);
	}
	
	public List<State> getStateList()
	{
		
		return stateDao.getStateList();
	}



	
}
