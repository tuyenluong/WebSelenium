package com.web.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.grid.Main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.web.selenium.webSelenium.data.DataMapper;
import com.web.page.pageUi.HomePageUI;
import com.web.selenium.webSelenium.api.data.WebDataMapper;
import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.selenium.SeleniumDriverManager;


import io.github.bonigarcia.wdm.WebDriverManager;

public class testDemo {
	
	@BeforeSuite
	private void initGrid() {
		GlobalConfigBuilder.getInstace();
		if(Boolean.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("isLocalExecution"))) {
			final String s = System.getProperty("user.dir") + "/src/test/resources/drivers/";
			WebDriverManager.chromedriver().cachePath(s).avoidTmpFolder().setup();
	        WebDriverManager.edgedriver().cachePath(s).avoidTmpFolder().setup();
	        WebDriverManager.firefoxdriver().cachePath(s).avoidTmpFolder().setup();
			try {
				Main.main(new String[] { "standalone", "--port", "4444", "--override-max-sessions", "true", "--max-sessions", "10", "--session-timeout", "700" });
		        Thread.sleep(2000L);
			}catch(InterruptedException a) {
				a.printStackTrace();
			}
		}
	}
	
	@BeforeMethod
	public void before(){
		SeleniumDriverManager.startWebDriver();
		
		// Setup data
		String testData = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\web\\data\\test.json";
		DataMapper data = new DataMapper(testData,"fr");
		SessionManager.getWebDriver().setDataMapper(data);
	}
	
	@Test
	public void testDemoDataInDynamicStructure() throws InterruptedException {
		//Use Dynamic data to query
		String url = WebDataMapper.queryData("$.fr.url");
		//Test
		SessionManager.getWebDriver().navigate().to(url);
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.BTN_MENU)).click();
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean status = SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.LBL_H4)).isEnabled();
		new Assertion().assertEquals(status, true);
	}
	
	@Test
	public void testDemoDataInFixStructure() throws InterruptedException {
		//Used data in fix structure
		String url = WebDataMapper.mapData("url");
		//Test
		SessionManager.getWebDriver().navigate().to(url);
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.BTN_MENU)).click();
		SessionManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		boolean status = SessionManager.getWebDriver().findElement(By.xpath(HomePageUI.LBL_H4)).isEnabled();
		new Assertion().assertEquals(status, true);
	}
	
	
	@AfterMethod
	public void after(){
		SessionManager.getWebDriver().quit();
		SessionManager.removeThread();
	}

}
