package com.conalytics.dao;

import java.util.List;

import com.conalytics.domain.Repair;

public interface RepairDao {


	public void insertRepair(Repair repair);

	public void deleteRepair(Double claimId);

	public void updateRepair(Repair repair);
	
	public  List<Repair> getRepairList(Double id);
	
	public Repair getRepairListId(Double id);

	public void updateShopIdRepair(Double repairId , Double shopId);

	public void updateShopIdRepair(Double repairId, Double shopId, Double partId);

	public void deleteRepairbyClaim(Double claimid);

}
