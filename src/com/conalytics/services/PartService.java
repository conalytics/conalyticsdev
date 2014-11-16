package com.conalytics.services;

import java.util.List;

import com.conalytics.domain.Part;

public interface PartService {
	public void insertData(Part part);

	public List<Part> getPartList();

	public void deleteData(Double id);

	public Part getPart(Double id);

	public void updateData(Part part);
	
	public List<Part> getPartsdata();
}
