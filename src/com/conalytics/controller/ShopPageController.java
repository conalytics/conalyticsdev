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
import com.conalytics.domain.Shop;
import com.conalytics.services.ShopService;

@Controller
@SessionAttributes("currentMenuItem")
public class ShopPageController {

	@Autowired
	ShopService shopService;

	@RequestMapping("registerShop")
	public ModelAndView registerShop(@ModelAttribute Shop shop) {
		ModelAndView modelAndView = new ModelAndView("registerShop");
		return modelAndView;
	}

	@RequestMapping("insertShop")
	public String insertData(@ModelAttribute Shop shop) {
		if (shop != null)
			shopService.insertData(shop);
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