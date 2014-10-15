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
import com.conalytics.domain.State;
import com.conalytics.services.CityService;
import com.conalytics.services.StateService;

@Controller
@SessionAttributes("currentMenuItem")
public class CityPageController {

	@Autowired
	CityService cityService;

	@Autowired
    StateService stateService;
	@RequestMapping("registerCity")
	public ModelAndView registerCity(@ModelAttribute City city) {
		
		Map<Double, String> stateMap = new HashMap<Double, String>();
		List<State> stateList = stateService.getStateList();
		for(State state : stateList) {
		stateMap.put(state.getId(), state.getStateDesc());
		}
		ModelAndView modelAndView = new ModelAndView("registerCity", "stateMap", stateMap);
		
		modelAndView.addObject("currentMenuItem", "Add City");
		return modelAndView;
	}

	@RequestMapping("insertCity")
	public String insertData(@ModelAttribute City city) {
		if (city != null)
			cityService.insertData(city);
		return "redirect:/getCityList";
	}

	@RequestMapping("getCityList")
	public ModelAndView getCityList() {
		List<City> cityList = cityService.getCityList();
		ModelAndView modelAndView = new ModelAndView("cityList", "cityList", cityList);
		modelAndView.addObject("currentMenuItem", "City List");
		return modelAndView;
	}

	@RequestMapping("editCity")
	public ModelAndView editCity(@RequestParam Double id,
			@ModelAttribute City city) {

		city = cityService.getCitybyId(id);
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("city", city);
		return new ModelAndView("editCity", "map", map);

	}

	@RequestMapping("updateCity")
	public String updateCity(@ModelAttribute City city) {
		cityService.updateData(city);
		return "redirect:/getCityList";

	}

	@RequestMapping("deleteCity")
	public String deleteCity(@RequestParam Double id) {
		System.out.println("id = " + id);
		cityService.deleteData(id);
		return "redirect:/getCityList";
	}
}