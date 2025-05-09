package com.web.selenium.webSelenium.api.element;

import org.openqa.selenium.WebElement;

public interface EnhancedElement extends WebElement {

	void scrollToElement();

	void scrollToElement(String block);

	void scrollToElement(String behavior, String block);

	boolean waitForElementVisibility(Long seconds);

	boolean waitForElementToBePresent(Long seconds);
}
