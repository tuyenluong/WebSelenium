package com.web.selenium.webSelenium.driver;

public class SessionManager {

    private static final ThreadLocal<SessionImp> sessionService = new ThreadLocal<>();

    public static SessionImp getSesson(){
        if(sessionService.get() == null){
            throw new RuntimeException("Sesson is not instantiate yet !!!!!!");
        }
        return sessionService.get();
    }
    
    
    public static void setSesson(SessionImp sesson) {
    	sessionService.set(sesson);
    }
    public static Boolean isDriverRunning(){
        return sessionService.get() == null ? true : false;
    }

    public static void removeThread(){
    	sessionService.remove();
    }
    
    
}
