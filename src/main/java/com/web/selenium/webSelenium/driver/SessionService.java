package com.web.selenium.webSelenium.driver;

import org.openqa.selenium.WebDriver;
import com.web.selenium.webSelenium.config.GlobalConfig;
import com.web.selenium.webSelenium.data.DataMapper;

public class SessionService implements SessionImp {
	
	
	private DataMapper dataMapper;
	private GlobalConfig globalConfig;
	private WebDriver driver;

	@Override
	public void setDataMapper(DataMapper dataMapper) {
		this.dataMapper = dataMapper;
	}

	@Override
	public DataMapper getDataMapper() {
		return dataMapper;
	}

	@Override
	public void setGlobalConfig(GlobalConfig globalConfig) {
		this.globalConfig = globalConfig;
	}

	@Override
	public GlobalConfig getGlobalConfig() {
		return globalConfig;
	}

	@Override
	public void setWebDriver(WebDriver driver) {
		this.driver = driver;
		
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

}
