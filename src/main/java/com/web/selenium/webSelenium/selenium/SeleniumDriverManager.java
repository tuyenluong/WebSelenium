package com.web.selenium.webSelenium.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.grid.Main;

import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.EnhancedDriverImp;
import com.web.selenium.webSelenium.driver.EnhancedDriverService;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.enums.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumDriverManager {
	
	public static void startWebDriver() {
//		EnhancedDriverImp driver = null;
//		if(Boolean.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("isLocalExecution"))) {
//			driver = initLocalWebDriver();
//		}else {
//			driver = initRemoteWebDriver(GlobalConfigBuilder.getInstace().getConfig().get("hubURL"));
//		}
		
		String hub = null;
		if(Boolean.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("isLocalExecution"))) {
			hub = "http://localhost:4444";
		}else {
			hub = GlobalConfigBuilder.getInstace().getConfig().get("hubURL") ;
		}
		SessionManager.getSesson().setEnhancedDriver(initRemoteWebDriver(hub));
    }
	
	public static void launchGridLocal() {
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
	}
	
	private static EnhancedDriverImp initRemoteWebDriver(String hub){
		EnhancedDriverImp driver = null;
        try{
        	String browserName = GlobalConfigBuilder.getInstace().getConfig().get("browserName");
            driver = new EnhancedDriverService(new URL(hub), new SeleniumConfig().getCapabilities(browserName));
            System.out.println(SeleniumDriverManager.class + " Browser name is: " + browserName);
        }catch (MalformedURLException e){
        	System.out.println("dsadas");
        }
        return driver;
    }
	
	private static WebDriver initLocalWebDriver() {
		SeleniumConfig seleniumConfig = new SeleniumConfig();
		Browsers browser = Browsers.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("browserName"));
		return switch (browser) {
			case chrome -> new ChromeDriver(seleniumConfig.getChromeOptions());
			case firefox -> new FirefoxDriver(seleniumConfig.getFirefoxOptions());
			case edge -> new EdgeDriver(seleniumConfig.getEdgeOptions());
			default -> new ChromeDriver(seleniumConfig.getChromeOptions());
		};
	}
}
