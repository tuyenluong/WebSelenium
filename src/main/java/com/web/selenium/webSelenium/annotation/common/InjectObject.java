package com.web.selenium.webSelenium.annotation.common;

import com.web.selenium.webSelenium.api.enums.FetchType;

import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectObject {

    Class<?>[] clazz() default {};
    FetchType fetch() default FetchType.LAZY;
}
