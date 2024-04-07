package com.web.selenium.webSelenium.selenium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDriver extends RemoteWebDriver{
	
	public SeleniumDriver(URL url, DesiredCapabilities capabilities){
        super(url,capabilities);
    }
}
