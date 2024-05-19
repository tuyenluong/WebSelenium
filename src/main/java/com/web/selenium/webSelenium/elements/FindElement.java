//package com.web.selenium.webSelenium.elements;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.web.selenium.webSelenium.driver.SessionManager;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FindElement{
//
//    private static WebElement webElement;
//    private static List<WebElement> webElementList;
//    private static String noElement ="Encounter no element or element's not intractable exception!!!<br />\n";
//    private static String staleElement ="Encounter timeout exception or state element, find again!!!<br />\n";
//
//    private static String detectNewline(String des){
//        if(des.contains("<br />")){
//            return des.replace("<br />","");
//        }
//        return des;
//    }
//    private static String alignStackTrace(StackTraceElement[] stack){
//        StringBuilder build = new StringBuilder();
//        for(StackTraceElement s : stack){
//            build.append(s.getFileName()).append("<br />\n");
//        }
//        return build.toString();
//    }
//    private static WebElement getWebDriverWait(By by) {
//        try {
//            webElement = new WebDriverWait(SessionManager.getWebDriver(), Duration.ofSeconds(SessionManager.getWebDriver().getGlobalConfig("")))
//                    .until(ExpectedConditions.presenceOfElementLocated(by));
//        } catch (NoSuchElementException | ElementNotInteractableException e) {
//            JeremyLogger.log(Finder.class,detectNewline(noElement) + alignStackTrace(e.getStackTrace()), LogLevel.FAIL);
//            throw new RuntimeException(detectNewline(noElement));
//        } catch(StaleElementReferenceException | TimeoutException e){
//            JeremyLogger.log(Finder.class,detectNewline(staleElement) + alignStackTrace(e.getStackTrace()),LogLevel.ERROR);
//             webElement = new WebDriverWait(SessionManager.getWebDriver(), Duration.ofSeconds(SessionManager.getGlobalConfig().getTimeout()))
//                     .until(ExpectedConditions.presenceOfElementLocated(by));
//            return webElement;
//        }
//        return webElement;
//    }
//
//    public static WebElement initializeWebElement(String key, Identifier identifier) {
//        switch (identifier){
//            case id:
//                webElement = getWebDriverWait(By.id(key));
//                break;
//            case css:
//                webElement = getWebDriverWait(By.cssSelector(key));
//                break;
//            case xpath:
//                webElement = getWebDriverWait(By.xpath(key));
//                break;
//            case tagName:
//                webElement = getWebDriverWait(By.tagName(key));
//                break;
//            case linkText:
//                webElement = getWebDriverWait(By.linkText(key));
//                break;
//            case className:
//                webElement = getWebDriverWait(By.className(key));
//                break;
//            case partialLinkText:
//                webElement = getWebDriverWait(By.partialLinkText(key));
//                break;
//        }
//        return webElement;
//    }
//
//    private static List<WebElement> getWebDriverWaitList(By by){
//        try {
//            webElementList = new WebDriverWait(SessionManager.getWebDriver(), Duration.ofSeconds(SessionManager.getGlobalConfig().getTimeout()))
//                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
//        } catch (NoSuchElementException | ElementNotInteractableException e) {
//            JeremyLogger.log(Finder.class,detectNewline(noElement) + alignStackTrace(e.getStackTrace()), LogLevel.FAIL);
//            throw new RuntimeException(detectNewline(noElement));
//        } catch(StaleElementReferenceException | TimeoutException e){
//            JeremyLogger.log(Finder.class,detectNewline(staleElement) + alignStackTrace(e.getStackTrace()),LogLevel.ERROR);
//            webElementList = new WebDriverWait(SessionManager.getWebDriver(), Duration.ofSeconds(SessionManager.getGlobalConfig().getTimeout()))
//                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
//            return webElementList;
//        }
//        return webElementList;
//    }
//
//
//    public static List<WebElement> initializeWebElementList(String key, Identifier identifier) {
//        switch (identifier){
//            case id:
//                webElementList = getWebDriverWaitList(By.id(key));
//                break;
//            case css:
//                webElementList = getWebDriverWaitList(By.cssSelector(key));
//                break;
//            case xpath:
//                webElementList = getWebDriverWaitList(By.xpath(key));
//                break;
//            case tagName:
//                webElementList = getWebDriverWaitList(By.tagName(key));
//                break;
//            case linkText:
//                webElementList = getWebDriverWaitList(By.linkText(key));
//                break;
//            case className:
//                webElementList = getWebDriverWaitList(By.className(key));
//                break;
//            case partialLinkText:
//                webElementList = getWebDriverWaitList(By.partialLinkText(key));
//                break;
//        }
//        return webElementList;
//    }
//}
