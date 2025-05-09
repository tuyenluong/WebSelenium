package com.web.selenium.webSelenium.annotation.inject;


import com.web.selenium.webSelenium.api.enums.FetchType;

import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectPageElement {

    Class<?>[] clazz() default {};

    FetchType fetch() default FetchType.LAZY;
}


