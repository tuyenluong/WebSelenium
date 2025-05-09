package com.web.selenium.webSelenium.driver;

import java.net.URL;

import com.web.selenium.webSelenium.annotation.common.InitObject;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;
import lombok.Data;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.web.selenium.webSelenium.data.DataMapper;

@Data
@InitObject
public class EnhancedDriverImp extends RemoteWebDriver implements EnhancedDriver {
	
	private DataMapper dataMapper;

	public EnhancedDriverImp(URL url, DesiredCapabilities cap) {
		super(url, cap);
	}

	@Override
	public void openURL(String url) {
		this.get(url);
	}

	@Override
	public void quitBrowser() {
		this.quit();
	}
}
