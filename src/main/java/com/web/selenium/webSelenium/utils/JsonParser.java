package com.web.selenium.webSelenium.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser < T > {

    public JsonParser(){
    }

    public T  parse (String path, Class<T> clazz) {
        T value = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            value= mapper.readValue(bytes,clazz);
        } catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        return value;
    }
    
	public DocumentContext jsonPathParser(String path) {
		DocumentContext document = null;
		try {
			String json = new String(Files.readAllBytes(Paths.get(path)));
			document = JsonPath.parse(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
}
