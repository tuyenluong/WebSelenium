package com.web.selenium.webSelenium.annotation.inject;

import com.web.selenium.webSelenium.api.enums.FetchType;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectWebElement {

    Class<?>[] page();
    FetchType fetch() default FetchType.LAZY;
}
