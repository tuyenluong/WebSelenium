package com.web.selenium.webSelenium.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;

import com.web.selenium.webSelenium.driver.ImproveWebDriver;
import com.web.selenium.webSelenium.driver.SessionManager;

public class SeleniumDriverManager {
	
	
	public static void startWebDriver() {
        String browserDisplayName = System.getenv("browserName");
        System.out.println(SeleniumDriverManager.class + " Browser name is: " + browserDisplayName);
        SessionManager.putDriver(initLocalWebDriver(browserDisplayName));
    }
	
	private static ImproveWebDriver initLocalWebDriver(String browserName){
		return (ImproveWebDriver) new ChromeDriver();
    }

	
	private static ImproveWebDriver initRemoteWebDriver(String browserName){
		ImproveWebDriver driver = null;
        try{
            driver =new SeleniumDriver(new URL(""), new SeleniumConfig().getCapabilities(browserName));
        }catch (MalformedURLException e){
        	System.out.println("dsadas");
        }
        return driver;
    }

}
