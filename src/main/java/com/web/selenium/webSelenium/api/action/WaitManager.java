package com.web.selenium.webSelenium.api.action;

import java.time.Duration;

import com.web.selenium.webSelenium.annotation.inject.InjectDriver;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;
import com.web.selenium.webSelenium.api.element.EnhancedElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {

	@InjectDriver
	private EnhancedDriver enhancedDriver;
	
	public boolean waitForElementVisibility(EnhancedElement element, long time) {
		return new WebDriverWait(enhancedDriver, Duration.ofSeconds(time))
				.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

}
