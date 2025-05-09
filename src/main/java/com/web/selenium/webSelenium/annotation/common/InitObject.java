package com.web.selenium.webSelenium.annotation.common;

import com.web.selenium.webSelenium.api.enums.FetchType;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InitObject {

    Class<?>[] clazz() default {};

    FetchType fetch() default FetchType.LAZY;
}
