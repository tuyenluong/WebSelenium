package com.web.selenium.webSelenium.api.driver;

import com.web.selenium.webSelenium.annotation.common.InitObject;
import org.openqa.selenium.WebDriver;


@InitObject
public interface EnhancedDriver extends WebDriver {

    void openURL(String url);

    void quitBrowser();

//    void setExtentTest(ExtentTest obj);
//
//    ExtentTest getExtentTest();
}
