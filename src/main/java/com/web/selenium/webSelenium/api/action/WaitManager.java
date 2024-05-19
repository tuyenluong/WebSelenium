package com.web.selenium.webSelenium.api.action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.elements.EnhancedElementImp;

public class WaitManager {
	
	public static boolean waitForElementVisibility(EnhancedElementImp element, long time) {
		return new WebDriverWait(SessionManager.getSesson().getEnhancedDriver(), Duration.ofSeconds(time))
				.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

}
