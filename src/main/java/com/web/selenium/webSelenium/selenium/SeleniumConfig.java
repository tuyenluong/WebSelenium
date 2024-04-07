package com.web.selenium.webSelenium.selenium;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.enums.Browsers;

public class SeleniumConfig {

	private DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public boolean isHealess() {
		return Boolean.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("isHeadLess"));
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-notifications");
		if (isHealess()) {
			chromeOptions.addArguments("--headless");
		}
		return chromeOptions;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--disable-infobars");
		firefoxOptions.addArguments("--start-maximized");
		firefoxOptions.addArguments("--disable-notifications");
		if (isHealess()) {
			firefoxOptions.addArguments("--headless");
		}
		return firefoxOptions;
	}
	
	public EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-infobars");
		edgeOptions.addArguments("--start-maximized");
		edgeOptions.addArguments("--disable-notifications");
		if (isHealess()) {
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
