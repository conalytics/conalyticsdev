package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.PartDao;
import com.conalytics.domain.Part;


public class PartServiceImpl implements PartService {

	@Autowired
	PartDao partdao;

	@Override
	public void insertData(Part part) {
		partdao.insertData(part);
	}

	@Override
	public List<Part> getPartList() {
		return partdao.getPartList();
	}

	@Override
	public void deleteData(Double id) {
		partdao.deleteData(id);
		
	}

	@Override
	public Part getPart(Double id) {
		return partdao.getPart(id);
	}

	@Override
	public void updateData(Part part) {
		partdao.updateData(part);
		
	}

	@Override
	public List<Part> getPartsdata() {
		// TODO Auto-generated method stub
		return 	partdao.getPartsdata();
	}


	
}
