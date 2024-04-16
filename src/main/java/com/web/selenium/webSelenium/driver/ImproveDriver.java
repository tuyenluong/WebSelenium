package com.web.selenium.webSelenium.driver;

import org.openqa.selenium.WebDriver;

import com.web.selenium.webSelenium.data.DataMapper;
import com.web.selenium.webSelenium.config.GlobalConfig;

public interface ImproveDriver extends WebDriver {

	
	void setDataMapper(DataMapper obj);

    DataMapper getDataMapper();

    void setGlobalConfig(GlobalConfig obj);

    GlobalConfig getGlobalConfig();

//    void setExtentTest(ExtentTest obj);
//
//    ExtentTest getExtentTest();

}
