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



import com.conalytics.domain.Claim;
import com.conalytics.services.ClaimService;


@Controller
@SessionAttributes("currentMenuItem")
public class ClaimPageController {

	@Autowired
	ClaimService claimService;


	@RequestMapping("registerClaim")
	public ModelAndView registerClaim(@ModelAttribute Claim claim) {
		ModelAndView modelAndView = new ModelAndView("registerClaim", "claimMap", getClaimList());
		return modelAndView;
	}


	@RequestMapping("insertClaim")
	public String inserData(@ModelAttribute Claim claim) {
		if (claim != null)
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
		ModelAndView modelAndView = new ModelAndView("workOnClaim");
		modelAndView.addObject("map", map);
		return modelAndView;

	}
}