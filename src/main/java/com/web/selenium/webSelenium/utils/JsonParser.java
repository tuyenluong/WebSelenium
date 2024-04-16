package com.web.selenium.webSelenium.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

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
            //Tracer.printStackTrace(JsonParser.class,e.getMessage());
        }
        return value;
    }
}
