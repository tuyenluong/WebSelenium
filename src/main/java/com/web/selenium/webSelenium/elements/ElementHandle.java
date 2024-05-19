package com.web.selenium.webSelenium.elements;


import java.util.function.Supplier;


public class ElementHandle<T> implements Supplier<T> {
	
    private Supplier<T> supplier;
    private T value;

    public ElementHandle(Supplier<T> supplier) {
    	this.supplier = supplier;
    }

	@Override
    public T get() {
        if (value == null) {
            value = supplier.get();
        }
        return value;
    }
	
}
