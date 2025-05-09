package com.web.selenium.webSelenium.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import com.web.selenium.webSelenium.annotation.common.InitObject;
import com.web.selenium.webSelenium.annotation.common.InjectObject;
import com.web.selenium.webSelenium.annotation.common.Scope;
import com.web.selenium.webSelenium.api.config.GlobalConfig;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;
import com.web.selenium.webSelenium.api.enums.ObjectScope;
import com.web.selenium.webSelenium.driver.EnhancedDriverImp;
import com.web.selenium.webSelenium.exception.GridLaunchException;
import com.web.selenium.webSelenium.session.SessionManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.grid.Main;

import com.web.selenium.webSelenium.enums.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

@InitObject
@Scope(type = ObjectScope.APPLICATION)
public class SeleniumDriverManager {

	@InjectObject
	private GlobalConfig globalConfig;

	@InjectObject
	private SessionManager sessionManager;
	
	public void startWebDriver() {
//		EnhancedDriverImp driver = null;
//		if(Boolean.valueOf(globalConfig.get("isLocalExecution"))) {
//			driver = initLocalWebDriver();
//		}else {
//			driver = initRemoteWebDriver(globalConfig.get("hubURL"));
//		}
		
		String hub = null;
		if(Boolean.valueOf(globalConfig.get("isLocalExecution"))) {
			hub = "http://localhost:4444";
		}else {
			hub = globalConfig.get("hubURL") ;
		}
		sessionManager.getSession().setEnhancedDriver(initRemoteWebDriver(hub));
    }
	
	public void launchGridLocal() {
		final String s = System.getProperty("user.dir") + "/src/test/resources/drivers/";
		WebDriverManager.chromedriver().cachePath(s).avoidTmpFolder().setup();
        WebDriverManager.edgedriver().cachePath(s).avoidTmpFolder().setup();
        WebDriverManager.firefoxdriver().cachePath(s).avoidTmpFolder().setup();
		try {
			Main.main(new String[] { "standalone", "--port", "4444", "--override-max-sessions", "true", "--max-sessions", "10", "--session-timeout", "700" });
	        Thread.sleep(2000L);
		}catch(InterruptedException a) {
			throw new GridLaunchException(a.getMessage());
		}
	}
	
	private EnhancedDriver initRemoteWebDriver(String hub){
		EnhancedDriver driver = null;
        try{
        	String browserName = globalConfig.get("browserName");
            driver = new EnhancedDriverImp(new URL(hub), new SeleniumConfig().getCapabilities(browserName));
            System.out.println(SeleniumDriverManager.class + " Browser name is: " + browserName);
        }catch (MalformedURLException e){
        	System.out.println("dsadas");
        }
        return driver;
    }
	
	private WebDriver initLocalWebDriver() {
		SeleniumConfig seleniumConfig = new SeleniumConfig();
		Browsers browser = Browsers.valueOf(globalConfig.get("browserName"));
		return switch (browser) {
			case chrome -> new ChromeDriver(seleniumConfig.getChromeOptions());
			case firefox -> new FirefoxDriver(seleniumConfig.getFirefoxOptions());
			case edge -> new EdgeDriver(seleniumConfig.getEdgeOptions());
        };
	}
}
