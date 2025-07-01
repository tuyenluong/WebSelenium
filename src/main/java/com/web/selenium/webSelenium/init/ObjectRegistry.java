package com.web.selenium.webSelenium.init;

import java.util.HashMap;
import java.util.Map;

public class ObjectRegistry {
    private static final Map<Class<?>, Object> registry = new HashMap<>();

    public static void register(Class<?> clazz, Object instance) {
        registry.put(clazz, instance);
    }

    public static Object get(Class<?> clazz) {
        return registry.get(clazz);
    }
}
