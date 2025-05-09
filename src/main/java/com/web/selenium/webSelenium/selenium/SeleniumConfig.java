package com.web.selenium.webSelenium.selenium;

import com.web.selenium.webSelenium.annotation.common.InitObject;
import com.web.selenium.webSelenium.annotation.common.InjectObject;
import com.web.selenium.webSelenium.api.config.GlobalConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.web.selenium.webSelenium.enums.Browsers;

public class SeleniumConfig {

	@InjectObject
	private GlobalConfig globalConfig;

	@InitObject
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public boolean isHeadless() {
		return Boolean.parseBoolean(globalConfig.get("--headless"));
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-notifications");
		if (isHeadless()) {
			chromeOptions.addArguments("--headless");
		}
		return chromeOptions;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--disable-infobars");
		firefoxOptions.addArguments("--start-maximized");
		firefoxOptions.addArguments("--disable-notifications");
		if (isHeadless()) {
			firefoxOptions.addArguments("--headless");
		}
		return firefoxOptions;
	}
	
	public EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-infobars");
		edgeOptions.addArguments("--start-maximized");
		edgeOptions.addArguments("--disable-notifications");
		if (isHeadless()) {
			edgeOptions.addArguments("--headless");
		}
		return edgeOptions;
	}

	public DesiredCapabilities getCapabilities(String browserName) {
		Browsers browser = Browsers.valueOf(browserName);
		switch (browser) {
			case chrome -> {
				capabilities.setBrowserName("chrome");
				capabilities.merge(getChromeOptions());
			}
			case firefox -> {
				capabilities.setBrowserName("firefox");
				capabilities.merge(getFirefoxOptions());
			}
			case edge -> {
				capabilities.setBrowserName("MicrosoftEdge");
				capabilities.merge(getEdgeOptions());
			}
			default -> {
				capabilities.setBrowserName("chrome");
				capabilities.merge(getChromeOptions());
			}
		}
		return capabilities;
	}
}
