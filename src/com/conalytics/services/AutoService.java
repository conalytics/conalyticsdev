package com.conalytics.services;

import java.util.List;

import com.conalytics.domain.Auto;

public interface AutoService {
	public void insertData(Auto auto);

	public List<Auto> getAutoList();

	public void deleteData(Double id);

	public Auto getAuto(Double id);

	public void updateData(Auto auto);

	public List<String> getAutoname(String query);
}
