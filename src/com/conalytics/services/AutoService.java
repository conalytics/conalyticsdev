package com.conalytics.services;

import java.util.List;
import java.util.Map;

import com.conalytics.domain.Auto;

public interface AutoService {
	public void insertData(Auto auto);

	public List<Auto> getAutoList();

	public void deleteData(Double id);

	public Auto getAuto(Double id);

	public void updateData(Auto auto);

	public List<String> getAutoname(String query);

	public Map<String, String> getAutoDetails(int autoYear, String searchText);
}
