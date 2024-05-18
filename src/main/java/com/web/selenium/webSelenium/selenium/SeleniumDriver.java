package com.web.selenium.webSelenium.selenium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.web.selenium.webSelenium.config.GlobalConfig;
import com.web.selenium.webSelenium.data.DataMapper;
import com.web.selenium.webSelenium.driver.ImproveDriver;

public class SeleniumDriver extends RemoteWebDriver implements ImproveDriver{
	
	private DataMapper dataMapper;
	
	public SeleniumDriver(URL url, DesiredCapabilities capabilities){
        super(url,capabilities);
    }

	@Override
	public void setDataMapper(DataMapper dataMapper) {
		this.dataMapper = dataMapper;
	}

	@Override
	public DataMapper getDataMapper() {
		return dataMapper;
	}
}
