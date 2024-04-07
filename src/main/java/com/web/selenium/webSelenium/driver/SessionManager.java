package com.web.selenium.webSelenium.driver;

import org.openqa.selenium.WebDriver;

public class SessionManager {

    private static final ThreadLocal<WebDriver> sessionDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver(){
        if(sessionDriver.get() == null){
            throw new RuntimeException("Web Driver is not instantiate yet !!!!!!");
        }
        return sessionDriver.get();
    }

    public static Boolean isDriverRunning(){
        return sessionDriver.get() == null ? true : false;
    }

    public static void putDriver(WebDriver driver){
        sessionDriver.set(driver);
    }

    public static void removeThread(){
        sessionDriver.remove();
    }
    
}
