package com.web.selenium.webSelenium.elements;

import lombok.Getter;
import lombok.Setter;

import com.web.selenium.webSelenium.enums.Locator;

@Getter
@Setter
public abstract class AbstractElement {
    private String key;
    private Locator locator;

    public AbstractElement(String key, Locator locator){
        this.key = key;
        this.locator = locator;
    }

}
