package com.web.selenium.webSelenium.session;

import com.web.selenium.webSelenium.annotation.common.InitObject;
import com.web.selenium.webSelenium.api.session.SessionController;
import com.web.selenium.webSelenium.exception.SessionException;
import lombok.Setter;


@InitObject
@Setter
public class SessionManager {

    private ThreadLocal<SessionController> sessionService = new ThreadLocal<>();

    public SessionController getSession(){
        if(sessionService.get() == null){
            throw new SessionException("Session is not instantiate yet !!!!!!");
        }
        return sessionService.get();
    }
    public String init(){
        return "initlizization";
    }

    public Boolean isDriverRunning(){
        return sessionService.get() == null;
    }

    public void removeThread(){
        sessionService.remove();
    }
}
