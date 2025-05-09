package com.web.selenium.webSelenium.annotation.define;


import com.web.selenium.webSelenium.enums.Locator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebElement {

    String identifier();

    Locator locator();
}
