package com.web.selenium.webSelenium.api.config;


import com.web.selenium.webSelenium.driver.SessionManager;

public class ConfigManager {
	

    public static String getConfig(String config){
        return SessionManager.getSesson().getGlobalConfig().get(config);
    }

    public static void setConfig(String key, String value){
    	SessionManager.getSesson().getGlobalConfig().put(key, value);
    }

}
