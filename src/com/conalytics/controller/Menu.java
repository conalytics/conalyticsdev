package com.conalytics.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

public class Menu {
	private static String menuItems = null;	
	public static String getMenuItems(String appContext) throws IOException {
		if(null == menuItems) {
			loadMenuItems(appContext);
		}
		return menuItems;
	}
	
	public static void loadMenuItems(String appContext) throws IOException {
		System.out.println(appContext);
		JSONParser parser = new JSONParser();
		try {
			String jsonString = FileUtils.readFileToString(new ClassPathResource("menu_json.txt").getFile());
			jsonString = jsonString.replaceAll("_APP_CONTEXT_", appContext);
			Object obj = parser.parse(jsonString);
			JSONArray jsonObject = (JSONArray) obj;
			menuItems = jsonObject.toJSONString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
}