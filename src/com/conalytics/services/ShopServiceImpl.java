package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.ShopDao;
import com.conalytics.domain.Shop;

public class ShopServiceImpl implements ShopService {
	@Autowired
	ShopDao shopDao;

	@Override
	public void insertData(Shop shop) {
		// TODO Auto-generated method stub
		shopDao.insertData(shop);
	}

	@Override
	public void deleteData(Double shopid) {
		// TODO Auto-generated method stub
		shopDao.deleteData(shopid);
	}

	@Override
	public Shop getShopbyId(Double shopid) {
		// TODO Auto-generated method stub
		return shopDao.getShopbyId(shopid);
	}

	@Override
	public void updateData(Shop shop) {
		// TODO Auto-generated method stub
		shopDao.updateData(shop);
	}

	@Override
	public List<Shop> getShopList() {
		return shopDao.getShopList();
	}

	@Override
	public List<Shop> getShopListwithinGC(String lat, String lon,String distanceinKM) {
		// TODO Auto-generated method stub
		return shopDao.getShopListwithinGC(lat, lon, distanceinKM);
	}

	@Override
	public List<Shop> getShopListbetweenradius(String lat, String lon,
			String maxdistanceinKM, String mindistanceinKM) {
		// TODO Auto-generated method stub
		return shopDao.getShopListbetweenradius(lat,lon,maxdistanceinKM,mindistanceinKM);
	}

}
