package com.conalytics.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Menu {
	public static String getMenuItems() {
		JSONParser parser = new JSONParser();
		String menuItems = null;
		try {

			Object obj = parser.parse(new FileReader("c:/tmp/menu_json.txt"));
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

	public static void main(String[] args) {
		System.out.println(getMenuItems());
	}

}