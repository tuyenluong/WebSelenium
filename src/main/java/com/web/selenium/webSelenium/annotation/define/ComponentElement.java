package com.web.selenium.webSelenium.annotation.define;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ComponentElement {

    String componentName() default "";
}

