package com.conalytics.services;

import java.util.List;

import com.conalytics.domain.Inventory;
import com.conalytics.domain.Shop;

public interface InventoryService {
	
	public void insertData(Inventory invent);

	public void updateData(Inventory invent);

	public void deleteData(Double id);
	
	public List<Inventory> getInventorybyPartId(Double partId);
	
    public List<Inventory> getInventorybyShopList(List<Shop> shopl, Double partid);

	Inventory getInventorybyShopandPartId(Double shopid, Double partid);
	

}
