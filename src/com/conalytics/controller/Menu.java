package com.conalytics.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

public class Menu {
	public static String getMenuItems() throws IOException {
		JSONParser parser = new JSONParser();
		String menuItems = null;
		try {
			Object obj = parser.parse(new FileReader(new ClassPathResource("menu_json.txt").getFile()));
			JSONArray jsonObject = (JSONArray) obj;
			menuItems = jsonObject.toJSONString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return menuItems;
	}
}