package com.conalytics.controller;

import java.util.ArrayList;
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












import com.conalytics.domain.Claim;
import com.conalytics.domain.Inventory;
import com.conalytics.domain.Repair;
import com.conalytics.domain.Shop;
import com.conalytics.services.ClaimService;
import com.conalytics.services.InventoryService;
import com.conalytics.services.MapService;
import com.conalytics.services.RepairService;
import com.conalytics.services.ShopService;


@Controller
@SessionAttributes("currentMenuItem")
public class ClaimPageController {

	@Autowired
	ClaimService claimService;
	
	@Autowired
	RepairService repairService;
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	InventoryService invService;

	@RequestMapping("registerClaim")
	public ModelAndView registerClaim(@ModelAttribute Claim claim) {
		ModelAndView modelAndView = new ModelAndView("registerClaim", "claimMap", getClaimList());
		return modelAndView;
	}


	@RequestMapping("insertClaim")
	public String inserData(@ModelAttribute Claim claim) {
		System.out.println("here in insert Claim");
		if (claim != null)
			System.out.println(claim.toString());

		MapService proximityService = new MapService();
		 Float[] coords = proximityService.performGeoCoding(claim.getLocation());
		 claim.setGclat(coords[0].toString());
		 claim.setGclong(coords[1].toString());
			claimService.insertClaim(claim);
		return "redirect:/getClaimList";
	}

	@RequestMapping("getClaimList")
	public ModelAndView getClaimList() {
		List<Claim> claimList = claimService.getClaimList();
		ModelAndView modelAndView = new ModelAndView("claimList", "claimList", claimList);
		modelAndView.addObject("currentMenuItem", "Claim List");
		
		return modelAndView;
	}

	@RequestMapping("editClaim")
	public ModelAndView editClaim(@RequestParam Double id,
			@ModelAttribute Claim claim) {

		claim = claimService.getClaimbyId(id);
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("claim", claim);
		ModelAndView modelAndView = new ModelAndView("editClaim");
		modelAndView.addObject("map", map);
		return modelAndView;

	}

	@RequestMapping("updateClaim")
	public String updateClaim(@ModelAttribute Claim claim) {
		claimService.updateClaim(claim);
		return "redirect:/getClaimList";

	}

	@RequestMapping("deleteClaim")
	public String deleteClaim(@RequestParam Double id) {
		System.out.println("id = " + id);
		claimService.deleteClaim(id);
		return "redirect:/getClaimList";
	}
	
	
	@RequestMapping("workOnClaim")
	public ModelAndView workOnClaim(@RequestParam Double id,
			@ModelAttribute Claim claim) {

		claim = claimService.getClaimbyId(id);
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("claim", claim);
			
			List<Repair> repairList = repairService.getRepairList(id);
			
		ModelAndView modelAndView = new ModelAndView("workOnClaim");
		modelAndView.addObject("map", map);
		modelAndView.addObject("repairList", repairList);
		System.out.println("in work on claim view with repairs "+repairList.size());
		
		//get list of assigned shops to repairs and show them on the screen.
		List<String> geocodelist = new ArrayList<String>();
		String jsongeocode="[";
		for (int i = 0; i < repairList.size(); i++) {
			Repair r=repairList.get(i);
			System.out.println(r.toString());
			System.out.println(r.getShopid());
			String lat=shopService.getShopbyId(r.getShopid()).getGclat();
            String lon=shopService.getShopbyId(r.getShopid()).getGclong();
			String latlon="{\"lat\":"+lat+","+"\"lon\":"+lon+"}";
	        geocodelist.add(i, latlon);
	        if(i < repairList.size()-1)
	        {
	        	jsongeocode=jsongeocode+latlon+",";
	        }
	        else
	        {
	        	jsongeocode=jsongeocode+latlon;
	        }
		}
		jsongeocode=jsongeocode+"]";
		System.out.println(jsongeocode);
		modelAndView.addObject("jsongeocode", jsongeocode);
		
		return modelAndView;

	}
	
	@RequestMapping("sourceParts")
	public ModelAndView sourceParts(@RequestParam Double repairId) {

		System.out.println("Here in sourceparts");
		Repair ritem  = repairService.getRepairListbyId(repairId);
		//double rlId   = ritem.getRepairId();
		//double rlClId = ritem.getClaimId();
		//double prQuan = ritem.getQuantity();
		//Get geoCode of the vehicle location
		Double partId = ritem.getPartId();
		Claim claim=claimService.getClaimbyId(ritem.getClaimId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("claim", claim);
		String lat =claim.getGclat();
		String lon =claim.getGclong();
		//Search for shops where 
		//proximity service
		int radius =5;
		List<Inventory> sourceParts = null;
		
		for(int i=1; i<=5; i++)
		{
			
			List<Shop> shopl=shopService.getShopListwithinGC(lat, lon, Integer.toString(radius));
		
				if(shopl.size() > 0)
		        {
					sourceParts = invService.getInventorybyShopList(shopl, partId);
					if(sourceParts.size() > 0)
					{
						break;
					}
					
				}
				radius= radius * 10;
				
		}

		//build inventory with shop information list object 
		ModelAndView modelAndView = new ModelAndView("sourceParts", "sourceParts", sourceParts);
		modelAndView.addObject("ritem", ritem);
		modelAndView.addObject("map", map);
		
		return modelAndView;

		
	}
	
	
	@RequestMapping("selectShop")
	public ModelAndView selectShop(@RequestParam Double shopid, @RequestParam Double repairid ) {
		
		Repair ritem  = repairService.getRepairListbyId(repairid);
		
		//update shop id
		repairService.updateShopIdRepair(repairid, shopid);
		
		
		
		Claim claim = claimService.getClaimbyId(ritem.getClaimId());
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("claim", claim);
			
			List<Repair> repairList = repairService.getRepairList(ritem.getClaimId());
			
		ModelAndView modelAndView = new ModelAndView("workOnClaim");
		modelAndView.addObject("map", map);
		modelAndView.addObject("repairList", repairList);
		System.out.println("in work on selectshop view "+repairList.size());
		
		return modelAndView;
	}
	
}