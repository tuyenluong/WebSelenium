package com.web.selenium.webSelenium.api.session;

import com.web.selenium.webSelenium.annotation.common.InitObject;
import com.web.selenium.webSelenium.api.config.GlobalConfig;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;


@InitObject
public interface SessionController {

    EnhancedDriver getEnhancedDriver();
    GlobalConfig getGlobalConfig();
    void setEnhancedDriver(EnhancedDriver driver);
    void setGlobalConfig(GlobalConfig globalConfig);
}
