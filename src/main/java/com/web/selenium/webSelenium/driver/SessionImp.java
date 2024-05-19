package com.web.selenium.webSelenium.driver;

import org.openqa.selenium.WebDriver;
import com.web.selenium.webSelenium.config.GlobalConfig;
import com.web.selenium.webSelenium.data.DataMapper;

public interface SessionImp {
	
	void setDataMapper(DataMapper obj);

    DataMapper getDataMapper();
    
    void setGlobalConfig(GlobalConfig obj);

    GlobalConfig getGlobalConfig();
    
    void setWebDriver(WebDriver obj);
    
    WebDriver getWebDriver();
}
