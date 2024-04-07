package com.web.selenium.webSelenium.selenium;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumConfig {
	
	private DesiredCapabilities capabilities  = new DesiredCapabilities();
	
	public DesiredCapabilities getCapabilities(String browserName){
        switch (browserName){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--headless");
                capabilities.setBrowserName("chrome");
                capabilities.merge(chromeOptions);
                return capabilities;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-infobars");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--disable-notifications");
//                if(isHeadLess()){
//                    firefoxOptions.addArguments("--headless");
//                }
                capabilities.setBrowserName("firefox");
                capabilities.merge(firefoxOptions);
                return capabilities;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-infobars");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--disable-notifications");
//                if(isHeadLess()){
//                    edgeOptions.addArguments("--headless");
//                }
                capabilities.setBrowserName("MicrosoftEdge");
                capabilities.merge(edgeOptions);
                return capabilities;
        }
        return capabilities;
    }

}
