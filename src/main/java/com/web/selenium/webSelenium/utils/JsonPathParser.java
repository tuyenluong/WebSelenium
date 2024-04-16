package com.web.selenium.webSelenium.utils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;

public class JsonPathParser {
	
	private DocumentContext data;
	
	public void parser(String path) {
		Configuration configuration = Configuration.builder()
	             .jsonProvider(new JacksonJsonProvider())
	             .build();
		this.data = JsonPath.using(configuration).parse(path);
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
