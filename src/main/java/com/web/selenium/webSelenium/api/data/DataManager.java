package com.web.selenium.webSelenium.api.data;

import com.web.selenium.webSelenium.driver.SessionManager;

public class DataManager {

    public static String mapData(String input) {
        return SessionManager.getSesson().getDataMapper().mapValue(input);
    }
    public static void updateData(String key, String input) {
    	SessionManager.getSesson().getDataMapper().updateValue(key, input);
    }
    public static void setData(String key, String input) {
    	SessionManager.getSesson().getDataMapper().setValue(key, input);
    }
    public static String queryData(String query) {
    	return SessionManager.getSesson().getDataMapper().queryData(query);
    }
}
