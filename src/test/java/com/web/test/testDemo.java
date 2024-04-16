package com.web.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.web.selenium.webSelenium.data.DataMapper;
import com.web.selenium.webSelenium.data.InjectData;
import com.jayway.jsonpath.DocumentContext;
import com.web.selenium.webSelenium.api.data.WebDataMapper;
import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.selenium.SeleniumDriverManager;
import com.web.selenium.webSelenium.utils.JsonPathParser;

import pageUi.HomePageUI;

public class testDemo {
	
	@BeforeTest
	public void before(){
		GlobalConfigBuilder.getInstace().getConfig();
		SeleniumDriverManager.startWebDriver();
		String usser = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\web\\data\\test.json";
		DataMapper data = new DataMapper(usser,"fr");
		SessionManager.getWebDriver().setDataMapper(data);
		
		JsonPathParser json = new JsonPathParser();
		json.parser(usser);
		String data1 = json.getData("$.fr.url");
		
		SessionManager.getWebDriver().setDataMapper(data);
	}
	
	@AfterTest
	public void after(){
		SessionManager.getWebDriver().quit();
		SessionManager.removeThread();
	}
	
//	@InjectData(jsonPath = "./data/test.json")
	@Test
	public void testDemo1() throws InterruptedException {
		GlobalConfigBuilder.getInstace().getConfig().get("browserName");
		String url = "https://www."+ WebDataMapper.mapData("url");
		SessionManager.getWebDriver().navigate().to(url);
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.BTN_MENU)).click();
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean status = SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.LBL_H4)).isEnabled();
		new Assertion().assertEquals(status, true);
	}

}
