package com.web.selenium.webSelenium.api.data;

import com.web.selenium.webSelenium.driver.SessionManager;

public class WebDataMapper  {

    public static String mapData(String input) {
        return SessionManager.getWebDriver().getDataMapper().mapValue(input);
    }
    public static void updateData(String key, String input) {
    	SessionManager.getWebDriver().getDataMapper().updateValue(key, input);
    }
    public static void setData(String key, String input) {
    	SessionManager.getWebDriver().getDataMapper().setValue(key, input);
    }
    public static String queryData(String query) {
    	return SessionManager.getWebDriver().getDataMapper().mapValue(query);
    }
}
