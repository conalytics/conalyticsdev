package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.RepairDao;
import com.conalytics.domain.Repair;


public class RepairServiceImpl implements RepairService {

	
	@Autowired
	RepairDao repairDao;

	@Override
	public void insertRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairDao.insertRepair(repair);
	}

	@Override
	public void deleteRepair(Double claimId) {
		// TODO Auto-generated method stub
		repairDao.deleteRepair(claimId);
	}

	@Override
	public void updateRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairDao.updateRepair(repair);
	}

	@Override
	public List<Repair> getRepairList(Double id) {
		// TODO Auto-generated method stub
		return repairDao.getRepairList(id);
	}

	@Override
	public Repair getRepairListbyId(Double id) {
		// TODO Auto-generated method stub
		return repairDao.getRepairListId(id);
	}

	@Override
	public void updateShopIdRepair(Double repairId, Double shopId) {
		repairDao.updateShopIdRepair(repairId, shopId);
		
	}
	
	@Override
	public void updateShopIdRepair(Double repairId, Double shopId , Double partId) 
	{
		repairDao.updateShopIdRepair(repairId, shopId , partId);
	}
	
}
