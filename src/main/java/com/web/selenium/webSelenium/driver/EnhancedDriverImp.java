package com.web.selenium.webSelenium.driver;


import org.openqa.selenium.WebDriver;

import com.web.selenium.webSelenium.data.DataMapper;

public interface EnhancedDriverImp extends WebDriver{
	
	void setDataMapper(DataMapper obj);

    DataMapper getDataMapper();

//    void setExtentTest(ExtentTest obj);
//
//    ExtentTest getExtentTest();

}
