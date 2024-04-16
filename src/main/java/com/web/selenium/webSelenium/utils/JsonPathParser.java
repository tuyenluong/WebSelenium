package com.web.selenium.webSelenium.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathParser {
	
	private DocumentContext data;
	
	public void parser(String filePath) {
		try {
			String json = new String(Files.readAllBytes(Paths.get(filePath)));
			this.data = JsonPath.parse(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getData(String query) {
		Object result = null;
		try {
			result = data.read(query);
			return result.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
	
}
