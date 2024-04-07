package com.web.selenium.webSelenium.driver;

public class SessionManager {

    private static final ThreadLocal<ImproveWebDriver> sessionDriver = new ThreadLocal<>();

    public static ImproveWebDriver getWebDriver(){
        if(sessionDriver.get() == null){
            throw new RuntimeException("Web Driver is not instantiate yet !!!!!!");
        }
        return sessionDriver.get();
    }

    public static Boolean isDriverRunning(){
        return sessionDriver.get() == null ? true : false;
    }

    public static void putDriver(ImproveWebDriver driver){
        sessionDriver.set(driver);
    }

    public static void removeThread(){
        sessionDriver.remove();
    }

}
