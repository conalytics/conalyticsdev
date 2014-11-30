package com.conalytics.dao;

import java.util.List;

import com.conalytics.domain.Part;

public interface PartDao {
	public void insertData(Part part);

	public List<Part> getPartList();

	public void updateData(Part part);

	public void deleteData(Double id);

	public Part getPart(Double id);

	public List<Part> getPartsdata();

	public List<Part> getPartsdata(Double catId, Double AutoId);
}
