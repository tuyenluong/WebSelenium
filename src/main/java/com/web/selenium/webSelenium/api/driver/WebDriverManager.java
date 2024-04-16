package com.web.selenium.webSelenium.api.driver;

import com.web.selenium.webSelenium.config.GlobalConfig;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.driver.ImproveDriver;
import com.web.selenium.webSelenium.selenium.SeleniumDriverManager;


public class WebDriverManager{

    public static void startDriver(){
        SeleniumDriverManager.startWebDriver();
    }

    public static GlobalConfig getGlobalConfig(){
        return SessionManager.getWebDriver().getGlobalConfig();
    }

    public static void removeBrowserDriver(){
        SessionManager.getWebDriver().quit();
    }

    public static void removeThreadLocal(){
        SessionManager.removeDriver();
    }

    public static ImproveDriver getWebDriver(){
        return SessionManager.getWebDriver();
    }

}
