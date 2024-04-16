package com.web.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.web.selenium.webSelenium.data.DataMapper;
import com.web.selenium.webSelenium.data.InjectData;
import com.web.selenium.webSelenium.api.data.WebDataMapper;
import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.selenium.SeleniumDriverManager;

import pageUi.HomePageUI;

public class testDemo {
	
	@BeforeTest
	public void before(){
		GlobalConfigBuilder.getInstace().getConfig();
		SeleniumDriverManager.startWebDriver();
	}
	
	@AfterTest
	public void after(){
		SessionManager.getWebDriver().quit();
		SessionManager.removeThread();
	}
	
	@InjectData(jsonPath = "./data/test.json")
	@Test
	public void testDemo1() throws InterruptedException {
		GlobalConfigBuilder.getInstace().getConfig().get("browserName");
		SessionManager.getWebDriver().get(WebDataMapper.mapData("#url"));
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.BTN_MENU)).click();
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean status = SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.LBL_H4)).isEnabled();
		new Assertion().assertEquals(status, true);
	}

}
