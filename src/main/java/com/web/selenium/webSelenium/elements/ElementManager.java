package com.web.selenium.webSelenium.elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.web.selenium.webSelenium.enums.Locator;

public class ElementManager {
	
	public static ElementHandle<WebElement> elementInit(String key, Locator locator){
		return  new ElementHandle<WebElement>(() -> 
		FindElement.initializeWebElement(key, locator));
	}
	
	public static ElementHandle<List<WebElement>> elementListInit(String key, Locator locator){
		return new ElementHandle<List<WebElement>>(() -> 
		FindElement.initializeWebElementList(key, locator));
	}

}
