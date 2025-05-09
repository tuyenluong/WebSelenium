package com.web.selenium.webSelenium.annotation.inject;

import com.web.selenium.webSelenium.api.enums.FetchType;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectComponent {

    FetchType fetch() default FetchType.LAZY;
}

