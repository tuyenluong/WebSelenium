package com.web.selenium.webSelenium.api.action;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.selenium.webSelenium.api.driver.DriverManager;

public abstract class PageManager {
	
	public PageManager() {
		waitForPageToLoad();
    }
	
	public void waitForPageToLoad() {
		waitForJQuerySuccess();
		waitForJSLoadSuccess();
		waitForAngularLoad();
	}
	private void waitForJQuerySuccess() {
        explicitWait = initWebDriverWait(30);
        jsExecutor = (JavascriptExecutor) DriverManager.getEnhancedDriver();

        ExpectedCondition<Boolean> jQueryLoad = driver12 -> {
            try {
                return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };
        try {
            explicitWait.until(jQueryLoad);
        } catch (Throwable error) {
        }
    }
	private void waitForJSLoadSuccess() {
        explicitWait = initWebDriverWait(30);
        jsExecutor = (JavascriptExecutor) DriverManager.getEnhancedDriver();
        ExpectedCondition<Boolean> jsLoad =
                driver1 -> jsExecutor.executeScript("return document.readyState").toString().equals("complete");
        try {
            explicitWait.until(jsLoad);
        } catch (Throwable error) {
        }
    }
	private boolean isAngular(){
        jsExecutor = (JavascriptExecutor) DriverManager.getEnhancedDriver();
        boolean status = (boolean) jsExecutor.executeScript("return window.angular ? true : false");
        return status;
    }
	private void waitForAngularLoad() {
        if(isAngular()){
            explicitWait = initWebDriverWait(20);
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getEnhancedDriver();
            final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
            //Wait for ANGULAR to load
            ExpectedCondition<Boolean> angularLoad = driver -> {
                assert driver != null;
                return Boolean.valueOf(((JavascriptExecutor) driver)
                        .executeScript(angularReadyScript).toString());
            };
            //Get Angular is Ready
            boolean angularReady = Boolean.parseBoolean(js.executeScript(angularReadyScript).toString());
            //Wait ANGULAR until it is Ready!
            if (!angularReady) {
                //Wait for Angular to load
                try {
                    //Wait for jQuery to load
                    explicitWait.until(angularLoad);
                } catch (Throwable error) {
                }
            }
        }
    }
    private WebDriverWait initWebDriverWait(int seconds){
        return new WebDriverWait(DriverManager.getEnhancedDriver(), Duration.ofSeconds(seconds));
    }
    JavascriptExecutor jsExecutor;
    WebDriverWait explicitWait;
}
