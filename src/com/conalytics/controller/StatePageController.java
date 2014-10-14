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
import com.conalytics.domain.State;
import com.conalytics.services.StateService;

@Controller
@SessionAttributes("currentMenuItem")
public class StatePageController {

	@Autowired
	StateService stateService;

	@RequestMapping("registerState")
	public ModelAndView registerState(@ModelAttribute State state) {
		ModelAndView modelAndView = new ModelAndView("registerState");
		modelAndView.addObject("currentMenuItem", "Add State");
		return modelAndView;
	}

	@RequestMapping("insertState")
	public String insertData(@ModelAttribute State state) {
		if (state != null)
			stateService.insertData(state);
		return "redirect:/getStateList";
	}


	@RequestMapping("editState")
	public ModelAndView editState(@RequestParam Double id,
			@ModelAttribute State state) {

		state = stateService.getStatebyId(id);
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("state", state);
		return new ModelAndView("editState", "map", map);

	}

	@RequestMapping("updateState")
	public String updateState(@ModelAttribute State state) {
		stateService.updateData(state);
		return "redirect:/getStateList";

	}

	@RequestMapping("deleteState")
	public String deleteState(@RequestParam Double id) {
		System.out.println("id = " + id);
		stateService.deleteData(id);
		return "redirect:/getStateList";
	}
	
	
	@RequestMapping("getStateList")
	public ModelAndView getStateList() {
		List<State> stateList = stateService.getStateList();
		ModelAndView modelAndView = new ModelAndView("stateList", "stateList", stateList);
		modelAndView.addObject("currentMenuItem", "States List");
		return modelAndView;
	}
}