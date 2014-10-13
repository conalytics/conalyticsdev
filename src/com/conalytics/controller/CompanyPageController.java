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

import com.conalytics.domain.Company;
import com.conalytics.services.CompanyService;

@Controller
@SessionAttributes("currentMenuItem")
public class CompanyPageController {

	@Autowired
	CompanyService companyService;

	@RequestMapping("registerCompany")
	public ModelAndView registerCompany(@ModelAttribute Company company) {
		ModelAndView modelAndView = new ModelAndView("registerCompany");
		modelAndView.addObject("currentMenuItem", "Add Vehicle");
		return modelAndView;
	}

	@RequestMapping("insertCompany")
	public String inserData(@ModelAttribute Company company) {
		if (company != null)
			companyService.insertData(company);
		return "redirect:/getCompanyList";
	}

	@RequestMapping("getCompanyList")
	public ModelAndView getCompanyLIst() {
		List<Company> companyList = companyService.getCompanyList();
		ModelAndView modelAndView = new ModelAndView("companyList", "companyList", companyList);
		modelAndView.addObject("currentMenuItem", "Vehicle List");
		return modelAndView;
	}

	@RequestMapping("editCompany")
	public ModelAndView editCompany(@RequestParam Double id,
			@ModelAttribute Company company) {

		company = companyService.getCompany(id);
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("company", company);
		return new ModelAndView("editCompany", "map", map);

	}

	@RequestMapping("updateCompany")
	public String updateCompany(@ModelAttribute Company company) {
		companyService.updateData(company);
		return "redirect:/getCompanyList";

	}

	@RequestMapping("deleteCompany")
	public String deleteCompany(@RequestParam Double id) {
		System.out.println("id = " + id);
		companyService.deleteData(id);
		return "redirect:/getCompanyList";
	}
}