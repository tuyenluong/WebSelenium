package com.web.selenium.webSelenium.driver;

public class SessionManager {

    private static final ThreadLocal<SessionImp> sessionDriver = new ThreadLocal<>();

    public static SessionImp getSesson(){
        if(sessionDriver.get() == null){
            throw new RuntimeException("Web Driver is not instantiate yet !!!!!!");
        }
        return sessionDriver.get();
    }
    
    
    public static void setSesson(SessionImp sesson) {
    	sessionDriver.set(sesson);
    }
    public static Boolean isDriverRunning(){
        return sessionDriver.get() == null ? true : false;
    }

    public static void removeThread(){
        sessionDriver.remove();
    }
    
    
}
