package com.web.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.web.selenium.webSelenium.data.DataMapper;
import com.web.page.pageUi.HomePageUI;
import com.web.selenium.webSelenium.api.data.DataManager;
import com.web.selenium.webSelenium.api.driver.DriverManager;
import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.driver.SessionService;

public class testDemo {
	
	@BeforeSuite
	private void beforeSuite() {
		SessionManager.setSesson(new SessionService());
		SessionManager.getSesson().setGlobalConfig(GlobalConfigBuilder.getInstace().getConfig());
	}
	
	@BeforeMethod
	public void before(){
		DriverManager.startDriver();
		
		// Setup data
		String testData = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\web\\data\\test.json";
		DataMapper data = new DataMapper(testData,"fr");
		SessionManager.getSesson().setDataMapper(data);
	}
	
	@Test
	public void testDemoDataInDynamicStructure() throws InterruptedException {
		//Use Dynamic data to query
		String url = DataManager.queryData("$.fr.url");
		//Test
		DriverManager.getWebDriver().navigate().to(url);
		DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DriverManager.getWebDriver().findElement(By.xpath(HomePageUI.BTN_MENU)).click();
		DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean status = SessionManager.getSesson().getWebDriver().findElement(By.xpath(HomePageUI.LBL_H4)).isEnabled();
		new Assertion().assertEquals(status, true);
	}
	
	@Test
	public void testDemoDataInFixStructure() throws InterruptedException {
		//Used data in fix structure
		String url = DataManager.mapData("url");
		//Test
		DriverManager.getWebDriver().navigate().to(url);
		DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DriverManager.getWebDriver().findElement(By.xpath(HomePageUI.BTN_MENU)).click();
		DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean status = SessionManager.getSesson().getWebDriver().findElement(By.xpath(HomePageUI.LBL_H4)).isEnabled();
		new Assertion().assertEquals(status, true);
	}
	
	
	@AfterMethod
	public void after(){
		DriverManager.getWebDriver().quit();
		SessionManager.removeThread();
	}

}
