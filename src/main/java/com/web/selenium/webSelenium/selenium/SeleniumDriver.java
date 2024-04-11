package com.web.selenium.webSelenium.selenium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.web.selenium.webSelenium.config.GlobalConfig;
import com.web.selenium.webSelenium.driver.ImproveDriver;

public class SeleniumDriver extends RemoteWebDriver implements ImproveDriver{
	
	public SeleniumDriver(URL url, DesiredCapabilities capabilities){
        super(url,capabilities);
    }
}
