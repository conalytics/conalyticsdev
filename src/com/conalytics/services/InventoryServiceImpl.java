package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.InventoryDao;
import com.conalytics.domain.Inventory;
import com.conalytics.domain.Shop;



public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao invdao;

	@Override
	public void insertData(Inventory invent) {
		// TODO Auto-generated method stub
		invdao.insertData(invent);
	}

	@Override
	public void updateData(Inventory invent) {
		// TODO Auto-generated method stub
		invdao.updateData(invent);
	}

	@Override
	public void deleteData(Double id) {
		// TODO Auto-generated method stub
		invdao.deleteData(id);
	}

	@Override
	public List<Inventory> getInventorybyPartId(Double partId) {
		// TODO Auto-generated method stub
		return invdao.getInventorybyPartId(partId);
	}

	@Override
	public List<Inventory> getInventorybyShopList(List<Shop> shopl, Double partid) {
		// TODO Auto-generated method stub
		return invdao.getInventorybyShopList(shopl,partid);
	}

	
	@Override
	public Inventory getInventorybyShopandPartId(Double shopid,Double partid) {
		// TODO Auto-generated method stub
		return invdao.getInventorybyShopandPartId(shopid,partid);
	}

	@Override
	public byte[] getImagebyInvId(Double invId) {
		// TODO Auto-generated method stub
		return invdao.getImagebyInvId(invId);
	}

	@Override
	public List<Inventory> getShopPartsdata() {
		// TODO Auto-generated method stub
		return invdao.getShopPartsdata();
	}

	@Override
	public List<Inventory> getInventorybyShopListandPartDesc(List<Shop> shopl,String pdesc) {
		// TODO Auto-generated method stub
		return invdao.getInventorybyShopListandPartDesc(shopl,pdesc);
	}
	
}
