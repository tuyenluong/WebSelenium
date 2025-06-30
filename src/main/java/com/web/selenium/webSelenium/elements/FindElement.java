package com.web.selenium.webSelenium.elements;

import com.web.selenium.webSelenium.annotation.common.InjectObject;
import com.web.selenium.webSelenium.annotation.inject.InjectDriver;
import com.web.selenium.webSelenium.api.config.GlobalConfig;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.selenium.webSelenium.enums.Locator;

import java.time.Duration;
import java.util.List;

public class FindElement{

    @InjectDriver
    private EnhancedDriver enhancedDriver;
    @InjectObject
    private GlobalConfig globalConfig;

    private final long TIME_OUT = Long.parseLong(globalConfig.get("timeout"));

    private WebElement getWebDriverWait(By by) {
        return getWebDriverWait(by, TIME_OUT);
    }
    private WebElement getWebDriverWait(By by, long waitTime) {
        WebElement webElement;
        try {
            webElement = new WebDriverWait(enhancedDriver, Duration.ofSeconds(waitTime))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            throw new RuntimeException(e);
        } catch(StaleElementReferenceException | TimeoutException e){
             webElement = new WebDriverWait(enhancedDriver, Duration.ofSeconds(waitTime))
                     .until(ExpectedConditions.visibilityOfElementLocated(by));
            return webElement;
        }
        return webElement;
    }
    public WebElement initializeWebElement(String key, Locator locator) {
        return initializeWebElement(key, locator, TIME_OUT);
    }
    public WebElement initializeWebElement(String key, Locator locator, long waitTime) {
        WebElement webElement = null;
        switch (locator){
            case id:
                webElement = getWebDriverWait(By.id(key), waitTime);
                break;
            case css:
                webElement = getWebDriverWait(By.cssSelector(key), waitTime);
                break;
            case xpath:
                webElement = getWebDriverWait(By.xpath(key), waitTime);
                break;
            case tagName:
                webElement = getWebDriverWait(By.tagName(key), waitTime);
                break;
            case linkText:
                webElement = getWebDriverWait(By.linkText(key), waitTime);
                break;
            case className:
                webElement = getWebDriverWait(By.className(key), waitTime);
                break;
            case partialLinkText:
                webElement = getWebDriverWait(By.partialLinkText(key), waitTime);
                break;
        }
        return webElement;
    }
    private List<WebElement> getWebDriverWaitList(By by){
        return getWebDriverWaitList(by, TIME_OUT);
    }
    private List<WebElement> getWebDriverWaitList(By by, long waitTime){
        List<WebElement> webElementList;
        try {
            webElementList = new WebDriverWait(enhancedDriver, Duration.ofSeconds(waitTime))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            throw new RuntimeException(e);
        } catch(StaleElementReferenceException | TimeoutException e){
            webElementList = new WebDriverWait(enhancedDriver, Duration.ofSeconds(waitTime))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            return webElementList;
        }
        return webElementList;
    }
    public List<WebElement> initializeWebElementList(String key, Locator locator) {
        return initializeWebElementList(key, locator, TIME_OUT);
    }
    public List<WebElement> initializeWebElementList(String key, Locator locator, long waitTime) {
        List<WebElement> webElementList = List.of();
        switch (locator){
            case id:
                webElementList = getWebDriverWaitList(By.id(key), waitTime);
                break;
            case css:
                webElementList = getWebDriverWaitList(By.cssSelector(key), waitTime);
                break;
            case xpath:
                webElementList = getWebDriverWaitList(By.xpath(key), waitTime);
                break;
            case tagName:
                webElementList = getWebDriverWaitList(By.tagName(key), waitTime);
                break;
            case linkText:
                webElementList = getWebDriverWaitList(By.linkText(key), waitTime);
                break;
            case className:
                webElementList = getWebDriverWaitList(By.className(key), waitTime);
                break;
            case partialLinkText:
                webElementList = getWebDriverWaitList(By.partialLinkText(key), waitTime);
                break;
        }
        return webElementList;
    }
}
