package com.web.selenium.webSelenium.api.driver;

import com.web.selenium.webSelenium.driver.EnhancedDriverImp;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.selenium.SeleniumDriverManager;


public class DriverManager{

    public static void startDriver(){
        SeleniumDriverManager.startWebDriver();
    }
    
    public static void launchGridLocal(){
    	SeleniumDriverManager.launchGridLocal();
    }

    public static void quit(){
        SessionManager.getSesson().getEnhancedDriver();
    }
    
    public static EnhancedDriverImp getEnhancedDriver(){
    	return SessionManager.getSesson().getEnhancedDriver();
    }

}
