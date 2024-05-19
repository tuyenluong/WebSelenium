package com.web.selenium.webSelenium.elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.web.selenium.webSelenium.enums.Locator;

public abstract class AbstractElement {
    private String key;
    private Locator locator;

    public AbstractElement(String key, Locator locator){
        this.key = key;
        this.locator = locator;
    }

    public String getKey() {
        return key;
    }

    public Locator getLocator() {
        return locator;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLocator(Locator locator) {
        this.locator = locator;
    }

	public List<WebElement> findElements() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
