package com.web.selenium.webSelenium.api.driver;

import org.openqa.selenium.WebDriver;

import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.selenium.SeleniumDriverManager;


public class DriverManager{

    public static void startDriver(){
        SeleniumDriverManager.startWebDriver();
    }

    public static void quit(){
        SessionManager.getSesson().getWebDriver().quit();
    }

    public static WebDriver getWebDriver(){
        return SessionManager.getSesson().getWebDriver();
    }

}
