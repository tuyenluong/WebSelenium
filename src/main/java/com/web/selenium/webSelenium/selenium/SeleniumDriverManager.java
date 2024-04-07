package com.web.selenium.webSelenium.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.grid.Main;

import com.web.selenium.webSelenium.driver.ImproveWebDriver;
import com.web.selenium.webSelenium.driver.SessionManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriverManager {
	
	
	public static void startWebDriver() {
        String browserDisplayName = System.getenv("browserName");
        System.out.println(SeleniumDriverManager.class + " Browser name is: " + browserDisplayName);
        SessionManager.putDriver(initRemoteWebDriver(browserDisplayName));
    }
	
	private static String lanuchLocalGrid(){
		final String s = System.getProperty("user.dir") + "/src/test/resources/drivers/";
		WebDriverManager.chromedriver().cachePath(s).avoidTmpFolder().setup();
        WebDriverManager.edgedriver().cachePath(s).avoidTmpFolder().setup();
        WebDriverManager.firefoxdriver().cachePath(s).avoidTmpFolder().setup();
		try {
			Main.main(new String[] { "standalone", "--port", "4444", "--override-max-sessions", "true", "--max-sessions", "10", "--session-timeout", "700" });
	        Thread.sleep(2000L);
		}catch(InterruptedException a) {
			a.printStackTrace();
		}
		return "http://localhost:4444";
    }
	
	private static ImproveWebDriver initRemoteWebDriver(String browserName){
		ImproveWebDriver driver = null;
		String url = lanuchLocalGrid();
        try{
            driver =new SeleniumDriver(new URL(url), new SeleniumConfig().getCapabilities(browserName));
        }catch (MalformedURLException e){
        	System.out.println("dsadas");
        }
        return driver;
    }

}
