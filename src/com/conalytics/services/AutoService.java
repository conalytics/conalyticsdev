package com.conalytics.services;

import java.util.List;

import com.conalytics.domain.Auto;

public interface AutoService {
	public void insertData(Auto auto);

	public List<Auto> getAutoList();

	public void deleteData(String id);

	public Auto getAuto(String id);

	public void updateData(Auto auto);
}
