package com.conalytics.dao;

import java.util.List;

import com.conalytics.domain.Auto;

public interface AutoDao {
	public void insertData(Auto auto);

	public List<Auto> getAutoList();

	public void updateData(Auto auto);

	public void deleteData(Double id);

	public Auto getAuto(Double id);

	public List<Auto> getAutoDetails(Integer autoYear);

}
