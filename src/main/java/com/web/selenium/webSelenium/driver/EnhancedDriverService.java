package com.web.selenium.webSelenium.driver;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.web.selenium.webSelenium.data.DataMapper;

public class EnhancedDriverService extends RemoteWebDriver implements EnhancedDriverImp {
	
	private DataMapper dataMapper;
	
	public EnhancedDriverService(URL url, DesiredCapabilities cap) {
		super(url, cap);
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
