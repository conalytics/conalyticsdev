package com.conalytics.dao;


import java.util.List;

import com.conalytics.domain.Shop;

public interface ShopDao {
	public void insertData(Shop shop);

	public void updateData(Shop shop);

	public void deleteData(Double id);

	public Shop getShopbyId(Double id);
	
	public List<Shop> getShopList();

}
