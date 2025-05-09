package com.web.page.pageObject;

import com.web.page.pageUi.HomePageElements;
import com.web.selenium.webSelenium.annotation.inject.InjectDriver;
import com.web.selenium.webSelenium.annotation.inject.InjectPageElement;
import com.web.selenium.webSelenium.annotation.define.PageObject;
import com.web.selenium.webSelenium.api.action.PageManager;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;

@PageObject
public class HomePageObject extends PageManager{

	@InjectPageElement
	private HomePageElements homePageElements;

	@InjectDriver
	private EnhancedDriver enhancedDriver;

	public String getTest(){
		enhancedDriver.get("");
		return homePageElements.getBtn_financialData().getText();
	}



}
