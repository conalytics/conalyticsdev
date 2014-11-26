package com.conalytics.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.conalytics.domain.Claim;
import com.conalytics.domain.Inventory;
import com.conalytics.domain.Repair;
import com.conalytics.domain.Shop;
import com.conalytics.services.ClaimService;
import com.conalytics.services.InventoryService;
import com.conalytics.services.InventoryServiceImpl;
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

	@Autowired
	InventoryServiceImpl inventoryService;

	@RequestMapping("registerClaim")
	public ModelAndView registerClaim(@ModelAttribute Claim claim) {
		ModelAndView modelAndView = new ModelAndView("registerClaim",
				"claimMap", getClaimList());
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
		ModelAndView modelAndView = new ModelAndView("claimList", "claimList",
				claimList);
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

	@SuppressWarnings("unchecked")
	@RequestMapping("workOnClaim")
	public ModelAndView workOnClaim(@RequestParam Double id,
			@ModelAttribute Claim claim, @ModelAttribute Repair repair) {

		claim = claimService.getClaimbyId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("claim", claim);

		List<Repair> repairList = repairService.getRepairList(id);

		// get shop details / price to show on screen
		Double ppClaim_Cost = 0.0;
		Double rpClaim_Cost = 0.0;
		ModelAndView modelAndView = new ModelAndView("workOnClaim");
		modelAndView.addObject("map", map);
		modelAndView.addObject("repairList", repairList);
		System.out.println("in work on claim view with repairs "
				+ repairList.size());

		// get list of assigned shops to repairs and show them on the screen.
		List<String> geocodelist = new ArrayList<String>();
		JSONArray latlonArray = new JSONArray();
		for (int i = 0; i < repairList.size(); i++) {
			Repair r = repairList.get(i);
			System.out.println(r.toString());
			System.out.println(r.getShopid());
			if (null != r.getShopid() && r.getShopid() > 0) {
				Shop shop = shopService.getShopbyId(r.getShopid());
				repairList.get(i).setAddress(shop.getAddress());
				repairList.get(i).setShopName(shop.getShopName());
				JSONObject latlon = new JSONObject();
				latlon.put("lat", shop.getGclat());
				latlon.put("lon", shop.getGclong());
				//repair id to show on map
				
				latlon.put("rid",shop.getShopName());
				geocodelist.add(latlon.toJSONString());
				latlonArray.add(latlon);

				Inventory inv1 = invService.getInventorybyShopandPartId(r.getShopid(), r.getPartId());
				repairList.get(i).setQuantityav(inv1.getQTY_AVAILABLE());
				repairList.get(i).setShPPU(inv1.getPRICE_PER_UNIT());
				repairList.get(i).setShRPU(inv1.getRTL_PRICE_PER_UNIT());
				ppClaim_Cost = ppClaim_Cost + (inv1.getPRICE_PER_UNIT() * repairList.get(i).getQuantity());
				rpClaim_Cost = rpClaim_Cost + (inv1.getRTL_PRICE_PER_UNIT() * repairList.get(i).getQuantity());
				
				//calculate the max distance between vehicle and a repair shop
				
				
				
			} else {
				geocodelist.add(null);
			}
		}
		System.out.println(latlonArray.toJSONString());
		modelAndView.addObject("jsongeocode", latlonArray.toJSONString());
		modelAndView.addObject("ppc", ppClaim_Cost);
		modelAndView.addObject("rpc", rpClaim_Cost);

		return modelAndView;

	}

	@RequestMapping("insertRepair")
	public String insertRepair(@ModelAttribute Repair repair) {
		repairService.insertRepair(repair);
		return "redirect:/workOnClaim?id=" + repair.getClaimId();
		// workOnClaim

	}

	@RequestMapping("sourceParts")
	public ModelAndView sourceParts(@RequestParam Double repairId) {

		System.out.println("Here in sourceparts");
		Repair ritem = repairService.getRepairListbyId(repairId);
		// double rlId = ritem.getRepairId();
		// double rlClId = ritem.getClaimId();
		// double prQuan = ritem.getQuantity();
		// Get geoCode of the vehicle location
		Double partId = ritem.getPartId();
		
		// check if partId exists in database
		
		
		
		Claim claim = claimService.getClaimbyId(ritem.getClaimId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("claim", claim);
		String lat = claim.getGclat();
		String lon = claim.getGclong();
		// Search for shops where
		// proximity service
		int radius = 5;
		List<Inventory> sourceParts = null;
		List<Inventory> sourceParts2 = null;
		List<Shop> shopl = null;
		for (int i = 1; i <= 5; i++) {
			// check for shops within geocode location
			shopl = shopService.getShopListwithinGC(lat, lon,Integer.toString(radius));
			System.out.println(shopl.toString());
			if (shopl.size() > 0) {

				// check for shops inventory by part ID
				sourceParts = invService.getInventorybyShopList(shopl, partId);
			//	sourceParts2 = invService.getInventorybyShopListandPartDesc(shopl, ritem.getPartDesc());
				if (sourceParts.size() > 0) {
					break;
				}

			}
			radius = radius + 50;

		}

		for (int i = 0; i < sourceParts.size(); i++) {
			Inventory inv = sourceParts.get(i);

			for (int j = 0; j < shopl.size(); j++) {
				Shop sl = shopl.get(j);
				String ds = shopl.get(j).getDistance();
				if (sl.getShopId() == inv.getSHOP_ID()) {

					sourceParts.get(i).setDistance(ds);
					sourceParts.get(i).setShopdesc(sl.getShopName());

				}
			}
			System.out.println("distance" + inv.getDistance());
		}

		// build inventory with shop information list object
		ModelAndView modelAndView = new ModelAndView("sourceParts",
				"sourceParts", sourceParts);
		modelAndView.addObject("ritem", ritem);
		modelAndView.addObject("map", map);

		return modelAndView;

	}

	@RequestMapping("selectShop")
	public String selectShop(@RequestParam Double shopid,
			@RequestParam Double repairid) {
		Repair ritem = repairService.getRepairListbyId(repairid);
		// update shop id
		repairService.updateShopIdRepair(repairid, shopid);
		return "redirect:/workOnClaim?id=" + ritem.getClaimId();
	}

	@RequestMapping(value = "/getUserImage/{id}")
	public void getUserImage(HttpServletResponse response,
			@PathVariable("id") int shopPartId) throws IOException {
		response.setContentType("image/jpeg");
		byte[] buffer = inventoryService
				.getImagebyInvId(new Double(shopPartId));
		InputStream in1 = new ByteArrayInputStream(buffer);
		IOUtils.copy(in1, response.getOutputStream());
	}
	
	
	
	@RequestMapping("deleteRepair")
	public String deleteRepair(@RequestParam Double repairId) {
	
	Repair ritem = repairService.getRepairListbyId(repairId);
	repairService.deleteRepair(repairId);
	return "redirect:/workOnClaim?id=" + ritem.getClaimId();

	}

	
	
}