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
        WebElement webElement;
        try {
            webElement = new WebDriverWait(enhancedDriver, Duration.ofSeconds(TIME_OUT))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            throw new RuntimeException(e);
        } catch(StaleElementReferenceException | TimeoutException e){
             webElement = new WebDriverWait(enhancedDriver, Duration.ofSeconds(TIME_OUT))
                     .until(ExpectedConditions.visibilityOfElementLocated(by));
            return webElement;
        }
        return webElement;
    }

    public WebElement initializeWebElement(String key, Locator locator) {
        WebElement webElement = null;
        switch (locator){
            case id:
                webElement = getWebDriverWait(By.id(key));
                break;
            case css:
                webElement = getWebDriverWait(By.cssSelector(key));
                break;
            case xpath:
                webElement = getWebDriverWait(By.xpath(key));
                break;
            case tagName:
                webElement = getWebDriverWait(By.tagName(key));
                break;
            case linkText:
                webElement = getWebDriverWait(By.linkText(key));
                break;
            case className:
                webElement = getWebDriverWait(By.className(key));
                break;
            case partialLinkText:
                webElement = getWebDriverWait(By.partialLinkText(key));
                break;
        }
        return webElement;
    }

    private List<WebElement> getWebDriverWaitList(By by){
        List<WebElement> webElementList;
        try {
            webElementList = new WebDriverWait(enhancedDriver, Duration.ofSeconds(TIME_OUT))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            throw new RuntimeException(e);
        } catch(StaleElementReferenceException | TimeoutException e){
            webElementList = new WebDriverWait(enhancedDriver, Duration.ofSeconds(TIME_OUT))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            return webElementList;
        }
        return webElementList;
    }


    public List<WebElement> initializeWebElementList(String key, Locator locator) {
        List<WebElement> webElementList = List.of();
        switch (locator){
            case id:
                webElementList = getWebDriverWaitList(By.id(key));
                break;
            case css:
                webElementList = getWebDriverWaitList(By.cssSelector(key));
                break;
            case xpath:
                webElementList = getWebDriverWaitList(By.xpath(key));
                break;
            case tagName:
                webElementList = getWebDriverWaitList(By.tagName(key));
                break;
            case linkText:
                webElementList = getWebDriverWaitList(By.linkText(key));
                break;
            case className:
                webElementList = getWebDriverWaitList(By.className(key));
                break;
            case partialLinkText:
                webElementList = getWebDriverWaitList(By.partialLinkText(key));
                break;
        }
        return webElementList;
    }
}
