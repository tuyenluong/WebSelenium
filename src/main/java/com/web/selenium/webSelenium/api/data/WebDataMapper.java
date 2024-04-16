package com.web.selenium.webSelenium.api.data;

import com.web.selenium.webSelenium.api.driver.WebDriverManager;

public class WebDataMapper  {

    public static String mapData(String input) {
        return WebDriverManager.getWebDriver().getDataMapper().mapValue(input);
    }
    public static void updateData(String key, String input) {
    	WebDriverManager.getWebDriver().getDataMapper().updateValue(key, input);
    }
    public static void setData(String key, String input) {
    	WebDriverManager.getWebDriver().getDataMapper().setValue(key, input);
    }
}
