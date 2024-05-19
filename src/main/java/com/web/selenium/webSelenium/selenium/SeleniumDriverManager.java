package com.web.selenium.webSelenium.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.enums.Browsers;


public class SeleniumDriverManager {
	
	public static void startWebDriver() {
		WebDriver driver = null;
		if(Boolean.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("isLocalExecution"))) {
			driver = initLocalWebDriver();
		}else {
			driver = initWebDriver(GlobalConfigBuilder.getInstace().getConfig().get("hubURL"));
		}
		SessionManager.getSesson().setWebDriver(driver);
    }
	
	private static WebDriver initWebDriver(String hub){
		WebDriver driver = null;
        try{
        	String browserName = GlobalConfigBuilder.getInstace().getConfig().get("browserName");
            driver =new SeleniumDriver(new URL(hub), new SeleniumConfig().getCapabilities(browserName));
            System.out.println(SeleniumDriverManager.class + " Browser name is: " + browserName);
        }catch (MalformedURLException e){
        	System.out.println("dsadas");
        }
        return driver;
    }
	
	private static WebDriver initLocalWebDriver() {
		SeleniumConfig seleniumConfig = new SeleniumConfig();
		Browsers browser = Browsers.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("browserName"));
		return switch (browser) {
			case chrome -> new ChromeDriver(seleniumConfig.getChromeOptions());
			case firefox -> new FirefoxDriver(seleniumConfig.getFirefoxOptions());
			case edge -> new EdgeDriver(seleniumConfig.getEdgeOptions());
			default -> new ChromeDriver(seleniumConfig.getChromeOptions());
		};
	}
}
