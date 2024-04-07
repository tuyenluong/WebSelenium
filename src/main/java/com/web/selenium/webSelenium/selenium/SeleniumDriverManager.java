package com.web.selenium.webSelenium.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.enums.Browsers;

public class SeleniumDriverManager {
	
	public static void startWebDriver() {
		WebDriver driver = Boolean.parseBoolean(GlobalConfigBuilder.getInstace().getConfig().get("isLocalExecution"))
				? initLocalWebDriver() : initRemoteWebDriver() ;
        SessionManager.putDriver(driver);
    }
//	
//	private static String lanuchLocalGrid(){
//		final String s = System.getProperty("user.dir") + "/src/test/resources/drivers/";
//		WebDriverManager.chromedriver().cachePath(s).avoidTmpFolder().setup();
//        WebDriverManager.edgedriver().cachePath(s).avoidTmpFolder().setup();
//        WebDriverManager.firefoxdriver().cachePath(s).avoidTmpFolder().setup();
//		try {
//			Main.main(new String[] { "standalone", "--port", "4444", "--override-max-sessions", "true", "--max-sessions", "10", "--session-timeout", "700" });
//	        Thread.sleep(2000L);
//		}catch(InterruptedException a) {
//			a.printStackTrace();
//		}
//		return "http://localhost:4444";
//    }
	
	private static WebDriver initRemoteWebDriver(){
		WebDriver driver = null;
		String remote = GlobalConfigBuilder.getInstace().getConfig().get("hubURL");
        try{
        	String browserName = GlobalConfigBuilder.getInstace().getConfig().get("browserName");
            driver =new SeleniumDriver(new URL(remote), new SeleniumConfig().getCapabilities(browserName));
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
