package com.conalytics.services;


import java.util.List;


import com.conalytics.domain.Shop;

public interface ShopService {
	public void insertData(Shop shop);

    public void deleteData(Double shopid);

	public Shop getShopbyId(Double shopid);

	public void updateData(Shop shop);
	
	public List<Shop> getShopList();

}
