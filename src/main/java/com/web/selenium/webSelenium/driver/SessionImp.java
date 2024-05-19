package com.web.selenium.webSelenium.driver;

import com.web.selenium.webSelenium.config.GlobalConfig;

public interface SessionImp {
	
    void setGlobalConfig(GlobalConfig obj);

    GlobalConfig getGlobalConfig();
    
    void setEnhancedDriver(EnhancedDriverImp obj);
    
    EnhancedDriverImp getEnhancedDriver();
}
