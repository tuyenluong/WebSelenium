package com.web.selenium.webSelenium.annotation.common;

import com.web.selenium.webSelenium.api.enums.ObjectScope;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    ObjectScope type();
}
