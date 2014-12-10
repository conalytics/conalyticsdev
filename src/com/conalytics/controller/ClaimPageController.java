package com.conalytics.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.conalytics.domain.Auto;
import com.conalytics.domain.Category;
import com.conalytics.domain.Claim;
import com.conalytics.domain.Company;
import com.conalytics.domain.Inventory;
import com.conalytics.domain.Part;
import com.conalytics.domain.Repair;
import com.conalytics.domain.Shop;
import com.conalytics.services.AutoService;
import com.conalytics.services.CategoryService;
import com.conalytics.services.ClaimService;
import com.conalytics.services.CompanyService;
import com.conalytics.services.InventoryService;
import com.conalytics.services.MapService;
import com.conalytics.services.PartService;
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
	CategoryService catService;

	@Autowired
	PartService partService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AutoService autoService;
	
	@Autowired
	CompanyService companyService;

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


		
		for (int i = 0; i < claimList.size(); i++) {
			Claim cl = claimList.get(i);
           Claim cl2= new Claim();
           cl2.setClaimId(cl.getClaimId());
           cl2.setColor(cl.getColor());
           cl2.setDate(cl.getDate());
           cl2.setVIN(cl.getVIN());
           cl2.setLocation(cl.getLocation());
           
        Auto auto=autoService.getAuto(claimList.get(i).getModelId());
        Company comp= companyService.getCompany(auto.getCompanyId());
        cl2.setVinfo(auto.getYearBuilt()+" "+comp.getCompanyName()+" "+auto.getAutoName()+" "+auto.getModel());
        claimList.set(i, cl2);
		}
		//System.out.println(claimList.toString());
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

	@RequestMapping("showClaim")
	public ModelAndView showClaim(@RequestParam Double id, @ModelAttribute Claim claim, @ModelAttribute Repair repair) {
		return workOnClaim(id, null, claim, repair);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("workOnClaim")
	public ModelAndView workOnClaim(@RequestParam Double id, @RequestParam Double catId, @ModelAttribute Claim claim, @ModelAttribute Repair repair) {

		claim = claimService.getClaimbyId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("claim", claim);
        Auto auto=autoService.getAuto(claim.getModelId());
        Company comp= companyService.getCompany(auto.getCompanyId());
		List<Repair> repairList = repairService.getRepairList(id);

		// get shop details / price to show on screen
		Double ppClaim_Cost = 0.0;
		Double rpClaim_Cost = 0.0;
		ModelAndView modelAndView = new ModelAndView("workOnClaim");
		modelAndView.addObject("map", map);
		modelAndView.addObject("repairList", repairList);
		modelAndView.addObject("auto", auto);
		modelAndView.addObject("comp", comp);
		
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
				// repair id to show on map

				latlon.put("rid", shop.getShopName());
				geocodelist.add(latlon.toJSONString());
				latlonArray.add(latlon);

				Inventory inv1 = invService.getInventorybyShopandPartId(
						r.getShopid(), r.getPartId());
				repairList.get(i).setQuantityav(inv1.getQTY_AVAILABLE());
				repairList.get(i).setShPPU(inv1.getPRICE_PER_UNIT());
				repairList.get(i).setShRPU(inv1.getRTL_PRICE_PER_UNIT());
				ppClaim_Cost = ppClaim_Cost
						+ (inv1.getPRICE_PER_UNIT() * repairList.get(i)
								.getQuantity());
				rpClaim_Cost = rpClaim_Cost
						+ (inv1.getRTL_PRICE_PER_UNIT() * repairList.get(i)
								.getQuantity());

				// calculate the max distance between vehicle and a repair shop

			} else {
				geocodelist.add(null);
			}
		}
		System.out.println(latlonArray.toJSONString());
		modelAndView.addObject("jsongeocode", latlonArray.toJSONString());
		modelAndView.addObject("ppc", ppClaim_Cost);
		modelAndView.addObject("rpc", rpClaim_Cost);

		// check if repair item category is selected
		List<Category> catList = null;
		if (catId == null) {
			catList = catService.getCategoryList();
		} else {
			catList = catService.getCategoryList(catId);
		}

		modelAndView.addObject("category", getCategoryMap(catList));

		return modelAndView;

	}

	@RequestMapping("insertRepair")
	public String insertRepair(@ModelAttribute Repair repair) {

		if(repair.getPartDesc().length() > 1)
		{
			repair.setPartId(null);
		}
		repair.setPartDesc(repair.getPartDesc().replaceAll(",", ""));
		repairService.insertRepair(repair);
		return "redirect:/showClaim?id=" + repair.getClaimId();
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
        Auto auto=autoService.getAuto(claim.getModelId());
        Company comp= companyService.getCompany(auto.getCompanyId());

		String lat = claim.getGclat();
		String lon = claim.getGclong();
		// Search for shops where
		// proximity service
		int radius = 50;
		int radiusInc = 50;
		List<Inventory> sourceParts = null;
		List<Inventory> sourceParts2 = null;
		List<Shop> shopl = null;
		while (radius < 4000) {
			// check for shops within geocode location

			shopl = shopService.getShopListbetweenradius(lat, lon,
					Integer.toString(radius),
					Integer.toString(radius - radiusInc));
			System.out.println("shops found :" + shopl.size());
			if (shopl != null && shopl.size() > 0) {

				// check for shops inventory by part ID
				if(partId !=null && partId > 0 )
				{
				sourceParts = invService.getInventorybyShopList(shopl, partId);
				}
				System.out.println("ritem.getPartDesc()"+ritem.getPartDesc()+"dddd");
				if(ritem.getPartDesc() != null && ritem.getPartDesc().length() > 1 )
				{
				sourceParts2 = invService.getInventorybyShopListandPartDesc(
						shopl, ritem.getPartDesc());
				}
				if ((sourceParts != null && sourceParts.size() > 0)
						|| (sourceParts2 != null && sourceParts2.size() > 0)) {
					break;
				}

			}
			radius = radius + 100;

		}
		if (sourceParts2 != null) {
			
			if(sourceParts !=null)
			{
			for (int i = 0; i < sourceParts2.size(); i++) {
				Inventory e = sourceParts2.get(i);
				sourceParts.add(e);
			}
			}
			else
			{
				sourceParts = sourceParts2;
			}
		}

		if (sourceParts != null) {
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
		}

		// build inventory with shop information list object
		ModelAndView modelAndView = new ModelAndView("sourceParts",
				"sourceParts", sourceParts);
		modelAndView.addObject("ritem", ritem);
		modelAndView.addObject("map", map);
		modelAndView.addObject("auto", auto);
		modelAndView.addObject("comp", comp);

		return modelAndView;

	}

	@RequestMapping("selectShop")
	public String selectShop(@RequestParam Double shopid,
			@RequestParam Double repairid ,@RequestParam Double partid) {
		Repair ritem = repairService.getRepairListbyId(repairid);
		// update shop id
		System.out.println("repair id"+ritem.getPartId());
		if(ritem.getPartId() == 0)
		{
			repairService.updateShopIdRepair(repairid, shopid,partid);
		}
		else
		{
		repairService.updateShopIdRepair(repairid, shopid);
		}
		return "redirect:/workOnClaim?id=" + ritem.getClaimId()+ "&catId=";
	}

	@RequestMapping(value = "/getUserImage/{id}")
	public void getUserImage(HttpServletResponse response,
			@PathVariable("id") int shopPartId) throws IOException {
		response.setContentType("image/jpeg");
		byte[] buffer = invService.getImagebyInvId(new Double(shopPartId));
		InputStream in1 = new ByteArrayInputStream(buffer);
		IOUtils.copy(in1, response.getOutputStream());
	}

	@RequestMapping("deleteRepair")
	public String deleteRepair(@RequestParam Double repairId) {

		Repair ritem = repairService.getRepairListbyId(repairId);
		repairService.deleteRepair(repairId);
		return "redirect:/workOnClaim?id=" + ritem.getClaimId()+ "&catId=";

	}

	@RequestMapping("getCategoryList")
	public String getCategoryList(@RequestParam Double id,
			@ModelAttribute Repair repair) {

		// List<Category> catList = catService.getCategoryList(id);

		return "redirect:/workOnClaim?id=" + repair.getClaimId() + "&catId="
				+ id;

	}

	private Map<Double, String> getCategoryMap(List<Category> catList) {
		Map<Double, String> categoryMap = new HashMap<Double, String>();

		for (Category cat : catList) {
			categoryMap.put(cat.getId(), cat.getCategoryCode());
		}
		return categoryMap;
	}
	
	
	@RequestMapping(value = "/getAllCategories")
	public @ResponseBody
	String getAllCategories(HttpServletResponse response) throws IOException {
		List<Category> parentCategoryList = categoryService.getParentCategoryList();
		List<Category> categoryList = categoryService.getCategoryList();
		Map<String, TreeMap<String, String>> allCatDetails = new TreeMap<String, TreeMap<String, String>>();
		Map<String, String> parentCategories = new TreeMap<String, String>();
		
		for(Category category: parentCategoryList){
			parentCategories.put(category.getId().toString(),  category.getCategoryCode());
		}
		
		for(Category category: categoryList){
			if(null != category.getParentCategoryId()) {
				String parentCategoryCode = parentCategories.get(category.getParentCategoryId().toString());
				if(null == parentCategoryCode) {
					parentCategoryCode = "Others";
					
				}
				if(null == allCatDetails.get(parentCategoryCode)) {
					allCatDetails.put(parentCategoryCode, new TreeMap<String,String>());
				}
				allCatDetails.get(parentCategoryCode).put(category.getId().toString(), category.getCategoryCode());				
			}
		}
		String jsonString = getJsonArrayForDropdown(allCatDetails).toJSONString();
		System.out.println(jsonString);
		return jsonString;
	}
	
	@RequestMapping(value = "/getPartDesc/{catId}/{claimId}")
	public @ResponseBody
	String getPartDesc(HttpServletResponse response,
			@PathVariable("catId") Double catId,
			@PathVariable("claimId") Double claimId) throws IOException {
		System.out.println("here in get partDesc");
		Claim claim = claimService.getClaimbyId(claimId);
		List<Part> pList = partService.getPartsdata(catId, claim.getModelId());
		Map<String, TreeMap<String, String>> partsCatDetails = new HashMap<String, TreeMap<String, String>>();
		for (Part part : pList) {
			if(null == partsCatDetails.get(part.getCategoryName())) {
				partsCatDetails.put(part.getCategoryName(), new TreeMap<String,String>());
			}
			partsCatDetails.get(part.getCategoryName()).put(part.getPartId().toString(), part.getYearBuilt() +  "_" + part.getPartDesc());
		}
		String jsonString = getJsonArrayForDropdown(partsCatDetails).toJSONString();
		System.out.println(jsonString);
		return jsonString;
	}

	@SuppressWarnings("unchecked")
	private JSONArray getJsonArrayForDropdown(Map<String, TreeMap<String, String>> partsCatDetails) {
		JSONArray jsonCatArray = new JSONArray();
		JSONArray jsonPartsArray = new JSONArray();
		JSONObject partJsonObj = new JSONObject();
		JSONObject catJsonObj = new JSONObject();
		Iterator<String> catItr = partsCatDetails.keySet().iterator();
		while(catItr.hasNext()) {
			String category = catItr.next();
			Map<String, String> catParts = partsCatDetails.get(category);
			Iterator<String> catPartsItr = catParts.keySet().iterator();
			jsonPartsArray = new JSONArray();
			while(catPartsItr.hasNext()) {
				String partId = catPartsItr.next();
				String partName = catParts.get(partId);
				partJsonObj = new JSONObject();
				catJsonObj = new JSONObject();
				partJsonObj.put("name", partId);
				partJsonObj.put("label", partName);
				jsonPartsArray.add(partJsonObj);
			}
			catJsonObj.put("category", category);
			catJsonObj.put("parts", jsonPartsArray);
			jsonCatArray.add(catJsonObj);
		}
		return jsonCatArray;
	}
	

}