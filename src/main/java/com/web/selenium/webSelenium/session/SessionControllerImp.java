package com.web.selenium.webSelenium.session;

import com.web.selenium.webSelenium.annotation.common.InjectObject;
import com.web.selenium.webSelenium.api.config.GlobalConfig;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;
import com.web.selenium.webSelenium.api.session.SessionController;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SessionControllerImp implements SessionController {

    @InjectObject
    private GlobalConfig globalConfig;

    @InjectObject
    private EnhancedDriver enhancedDriver;

}
