package com.web.selenium.webSelenium.driver;

import com.web.selenium.webSelenium.config.GlobalConfig;

public class SessionService implements SessionImp {
	
	private GlobalConfig globalConfig;
	private EnhancedDriverImp  enhancedDriver;

	@Override
	public void setGlobalConfig(GlobalConfig globalConfig) {
		this.globalConfig = globalConfig;
	}

	@Override
	public GlobalConfig getGlobalConfig() {
		return globalConfig;
	}

	@Override
	public void setEnhancedDriver(EnhancedDriverImp enhancedDriver) {
		this.enhancedDriver = enhancedDriver;
	}

	@Override
	public EnhancedDriverImp getEnhancedDriver() {
		return enhancedDriver;
	}

}
