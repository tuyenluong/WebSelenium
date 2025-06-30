package com.web.selenium.webSelenium.init;

import com.web.selenium.webSelenium.annotation.common.InitObject;
import com.web.selenium.webSelenium.driver.EnhancedDriverImp;
import com.web.selenium.webSelenium.session.SessionManager;
import org.reflections.Reflections;

import java.util.Set;

public class Inject {

    public static void main(String[] args) throws Exception {
        // Use your base package name here
        Reflections reflections = new Reflections("com.web.selenium.webSelenium.session");

        // Find all classes annotated with @InitObject
        Set<Class<?>> initClasses = reflections.getTypesAnnotatedWith(InitObject.class);

        for (Class<?> clazz : initClasses) {
            System.out.println("Found @InitObject class: " + clazz.getName());
            SessionManager instance = (SessionManager) clazz.getDeclaredConstructor().newInstance();

            System.out.println(instance.init());
            // You can register this instance into a registry if you want
//            ObjectRegistry.register(clazz, instance);
        }
    }
}
