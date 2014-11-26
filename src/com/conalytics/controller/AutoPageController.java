package com.conalytics.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

import com.conalytics.domain.Auto;
import com.conalytics.domain.Company;
import com.conalytics.services.AutoService;
import com.conalytics.services.CompanyService;

@Controller
@SessionAttributes("currentMenuItem")
public class AutoPageController {

	@Autowired
	AutoService autoService;

	@Autowired
	CompanyService companyService;
	
	
	
	@RequestMapping("home")
	public ModelAndView home(@ModelAttribute Auto auto) {
		return new ModelAndView("conalyticsHomePage");
	}
	
	@RequestMapping("homePage")
	public ModelAndView homePage(@ModelAttribute Auto auto) {
		return new ModelAndView("homePage");
	}
	
	@RequestMapping("registerAuto")
	public ModelAndView registerAuto(@ModelAttribute Auto auto) {
		ModelAndView modelAndView = new ModelAndView("registerAuto", "companyMap", getCompanyMap());
		return modelAndView;
	}

	private Map<Double, String> getCompanyMap() {
		Map<Double, String> companyMap = new HashMap<Double, String>();
		List<Company> companyList = companyService.getCompanyList();
		for(Company company : companyList) {
			companyMap.put(company.getCompanyId(), company.getCompanyName());
		}
		return companyMap;
	}

	@RequestMapping("insertAuto")
	public String inserData(@ModelAttribute Auto auto) {
		if (auto != null)
			autoService.insertData(auto);
		return "redirect:/getAutoList";
	}

	@RequestMapping("getAutoList")
	public ModelAndView getAutoLIst() {
		List<Auto> autoList = autoService.getAutoList();
		ModelAndView modelAndView = new ModelAndView("autoList", "autoList", autoList);
		modelAndView.addObject("currentMenuItem", "Vehicle List");
		return modelAndView;
	}

	@RequestMapping("editAuto")
	public ModelAndView editAuto(@RequestParam Double id,
			@ModelAttribute Auto auto) {

		auto = autoService.getAuto(id);
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("auto", auto);
		ModelAndView modelAndView = new ModelAndView("editAuto");
		modelAndView.addObject("map", map);
		modelAndView.addObject("companyMap", getCompanyMap());
		return modelAndView;

	}

	@RequestMapping("updateAuto")
	public String updateAuto(@ModelAttribute Auto auto) {
		autoService.updateData(auto);
		return "redirect:/getAutoList";

	}

	@RequestMapping("deleteAuto")
	public String deleteAuto(@RequestParam Double id) {
		System.out.println("id = " + id);
		autoService.deleteData(id);
		return "redirect:/getAutoList";
	}
	
	@RequestMapping(value="/getautoDetails")
	public @ResponseBody String getAutoDetails(HttpServletResponse response) throws IOException{
		return getAutoDetails(response, null);
	}
	
	@RequestMapping(value="/getautoDetails/{autoYear}")
	public @ResponseBody String getAutoDetails(HttpServletResponse response , @PathVariable("autoYear") Integer autoYear
															) throws IOException{
		Map<String, String> autoDetails = autoService.getAutoDetails(autoYear);
		return JSONValue.toJSONString(autoDetails);
	}
}