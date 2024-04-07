package com.web.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.selenium.SeleniumDriverManager;

public class testDemo {
	
	@BeforeTest
	public void before(){
		SeleniumDriverManager.startWebDriver();
	}
	
	@AfterTest
	public void after(){
		SessionManager.getWebDriver().quit();
	}
	
	@Test
	public void testDemo1() {
		SessionManager.getWebDriver().get("https://www.baeldung.com/maven-java-version");
	}

}
