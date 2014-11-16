package com.conalytics.dao;


import java.util.List;

import com.conalytics.domain.Inventory;
import com.conalytics.domain.Shop;

public interface InventoryDao {
	public void insertData(Inventory invent);

	public void updateData(Inventory invent);

	public void deleteData(Double id);
	
	public List<Inventory> getInventorybyPartId(Double partId);

	public List<Inventory> getInventorybyShopList(List<Shop> shopl ,Double PartId);
	
	public Inventory getInventorybyShopandPartId(Double shopid,Double partid);
	
	public byte[] getImagebyInvId(Double invId);

	public List<Inventory> getShopPartsdata();

}
