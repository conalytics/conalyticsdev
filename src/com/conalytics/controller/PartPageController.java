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

import com.conalytics.domain.Auto;
import com.conalytics.domain.Part;
import com.conalytics.services.AutoService;
import com.conalytics.services.PartService;

@Controller
@SessionAttributes("currentMenuItem")
public class PartPageController {

	@Autowired
	PartService partService;
	
	@Autowired
	AutoService autoService;

	@RequestMapping("registerPart")
	public ModelAndView registerPart(@ModelAttribute Part part) {
		return new ModelAndView("registerPart", "autoMap", getAutoList());
	}

	private Map<Double, String> getAutoList() {
		Map<Double, String> autoMap = new HashMap<Double, String>();
		List<Auto> autoList = autoService.getAutoList();
		for(Auto auto : autoList) {
			autoMap.put(auto.getAutoId(), auto.getAutoName());
		}
		return autoMap;
	}

	@RequestMapping("insertPart")
	public String inserData(@ModelAttribute Part part) {
		if (part != null)
			partService.insertData(part);
		return "redirect:/getPartList";
	}

	@RequestMapping("getPartList")
	public ModelAndView getPartLIst() {
		List<Part> partList = partService.getPartList();
		ModelAndView modelAndView = new ModelAndView("partList", "partList", partList);
		return modelAndView;
	}

	@RequestMapping("editPart")
	public ModelAndView editPart(@RequestParam Double id, @ModelAttribute Part part) {
		part = partService.getPart(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("part", part);

		ModelAndView modelAndView = new ModelAndView("editPart");
		modelAndView.addObject("autoMap", getAutoList());
		modelAndView.addObject("map", map);
		return modelAndView;

	}

	@RequestMapping("updatePart")
	public String updatePart(@ModelAttribute Part part) {
		partService.updateData(part);
		return "redirect:/getPartList";

	}

	@RequestMapping("deletePart")
	public String deletePart(@RequestParam Double id) {
		System.out.println("id = " + id);
		partService.deleteData(id);
		return "redirect:/getPartList";
	}
}