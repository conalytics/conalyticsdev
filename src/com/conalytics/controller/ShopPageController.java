package com.conalytics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.conalytics.domain.City;
import com.conalytics.domain.Company;
import com.conalytics.domain.Shop;
import com.conalytics.domain.State;
import com.conalytics.services.CityService;
import com.conalytics.services.MapService;
import com.conalytics.services.ShopService;
import com.conalytics.services.MapService;
import com.conalytics.services.StateService;

@Controller
@SessionAttributes("currentMenuItem")
public class ShopPageController {

	@Autowired
	ShopService shopService;
	
	@Autowired
	StateService stateService;
	
	@Autowired
	CityService cityService;

	@RequestMapping("registerShop")
	public ModelAndView registerShop(@ModelAttribute Shop shop) {
		
		ModelAndView modelAndView = new ModelAndView("registerShop", "stateMap", getStateMap());
		//ModelAndView modelAndView = new ModelAndView("registerAuto", "companyMap", getCompanyMap());
		return modelAndView;
	}

	
	private Map<Double, String> getStateMap() {
		Map<Double, String> companyMap = new HashMap<Double, String>();
		List<State> stateList = stateService.getStateList();
		for(State state : stateList) {
			companyMap.put(state.getId(), state.getStateDesc());
		}
		return companyMap;
	}
	
	
	private Map<Double, String> getCityMap(Double id) {
		Map<Double, String> companyMap = new HashMap<Double, String>();
		List<City> cityList = cityService.getCityListbysid(id);
		for(City city : cityList) {
			companyMap.put(city.getCityId(), city.getStateDesc());
		}
		return companyMap;
	}
	
	@RequestMapping("insertShop")
	public String insertData(@ModelAttribute Shop shop) {
		
		if (shop != null)
		{
			//validate if the address is GEOCODABLE to city 
			
		MapService proximityService = new MapService();
		 Float[] coords = proximityService.performGeoCoding(shop.getAddress());
		 shop.setGclat(coords[0].toString());
		 shop.setGclong(coords[1].toString());
			
			shopService.insertData(shop);
		
		}
		return "redirect:/getShopList";
	}


	@RequestMapping("editShop")
	public ModelAndView editShop(@RequestParam Double id,
			@ModelAttribute Shop shop) {

		shop = shopService.getShopbyId(id);
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("shop", shop);
		return new ModelAndView("editShop", "map", map);

	}

	@RequestMapping("updateShop")
	public String updateShop(@ModelAttribute Shop shop) {
		shopService.updateData(shop);
		return "redirect:/getShopList";

	}

	@RequestMapping("deleteShop")
	public String deleteShop(@RequestParam Double id) {
		System.out.println("id = " + id);
		shopService.deleteData(id);
		return "redirect:/getShopList";
	}
	
	
	@RequestMapping("getShopList")
	public ModelAndView getShopList() {
		List<Shop> shopList = shopService.getShopList();
		ModelAndView modelAndView = new ModelAndView("shopList", "shopList", shopList);
		return modelAndView;
	}
}