package com.web.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.web.selenium.webSelenium.data.DataMapper;
import com.web.page.pageObject.HomePageObject;
import com.web.page.pageUi.HomePageElements;
import com.web.selenium.webSelenium.api.data.DataManager;
import com.web.selenium.webSelenium.api.driver.DriverManager;
import com.web.selenium.webSelenium.api.element.EnhancedElement;
import com.web.selenium.webSelenium.config.GlobalConfigBuilder;
import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.driver.SessionService;
import com.web.selenium.webSelenium.enums.Locator;

public class testDemo {
	
	@BeforeSuite
	private void beforeSuite() {
		// Init Session
		SessionManager.setSesson(new SessionService());
		SessionManager.getSesson().setGlobalConfig(GlobalConfigBuilder.getInstace().getConfig());
		// Launch local grid with localhost:4444
		DriverManager.launchGridLocal();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		DriverManager.startDriver();
		
		// Setup data
		String testData = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\web\\data\\test.json";
		DataMapper data = new DataMapper(testData,"fr");
		SessionManager.getSesson().getEnhancedDriver().setDataMapper(data);
	}
	
	@Test
	public void testDemoDataInDynamicStructure() throws InterruptedException {
		//Use Dynamic data to query
		String url = DataManager.queryData("$.fr.url");
		//Test
		DriverManager.getEnhancedDriver().navigate().to(url);
		HomePageElements.BtnLogo.waitForElementToBePresent(10);
		boolean status = HomePageElements.BtnLogo.isEnabled();
		new Assertion().assertEquals(status, true);
	}
	
	@Test
	public void testDemoDataInFixStructure() throws InterruptedException {
		//Used data in fix structure
		String url = DataManager.mapData("url");
		//Test
		DriverManager.getEnhancedDriver().navigate().to(url);
		HomePageElements.BtnLogo.waitForElementToBePresent(10);
		boolean status = HomePageElements.BtnLogo.isEnabled();
		new Assertion().assertEquals(status, true);
	}
	
	@Test
	public void testDemoFeatureinit() throws InterruptedException {
		DriverManager.getEnhancedDriver().get("https://www.boursakuwait.com.kw/en/participants/participants/listed-companies");
		EnhancedElement btn_financialData = EnhancedElement.init("(//*[@id='/en/stock/financial-data/income-statement-pill'])[1]", Locator.xpath);
		EnhancedElement tab_incomeStatement = EnhancedElement.init("(//*[@id='/en/stock/financial-data/income-statement-pill'])[2]", Locator.xpath);
		EnhancedElement tab_balanceSheet = EnhancedElement.init("//*[@id='/en/stock/financial-data/balance-sheet-pill']", Locator.xpath);
		EnhancedElement tab_cashFlow = EnhancedElement.init("//*[@id='/en/stock/financial-data/cash-flow-statement-pill']", Locator.xpath);
		EnhancedElement list_ofBanks = EnhancedElement.init("//tr[@class='sc-fzpkqZ QaPvo']/td/a", Locator.xpath);
		EnhancedElement list_sheetTable = EnhancedElement.init("//tr[contains(@class,'sc-fzpkqZ')]", Locator.xpath);
		System.out.println("The EnhancedElement class will hold the key and the locator and only init the WebElement when the user call the element action");
		System.out.println(btn_financialData.getKey());
		System.out.println(btn_financialData.getLocator());
		System.out.println(tab_cashFlow.getKey());
		System.out.println(tab_cashFlow.getLocator());
		System.out.println(list_sheetTable.getKey());
		System.out.println(list_sheetTable.getLocator());
		System.out.println(tab_balanceSheet.getKey());
		System.out.println(tab_balanceSheet.getLocator());
		System.out.println(list_ofBanks.getKey());
		System.out.println(list_ofBanks.getLocator());
		System.out.println(tab_incomeStatement.getKey());
		System.out.println(tab_incomeStatement.getLocator());
	}
	
	@Test
	public void testDemoFPageObject() throws InterruptedException {
		HomePageObject.getInstance().openBanksURL().getBanksSheetTable();
	}
	
	
	@AfterMethod
	public void afterMethod(){
		SessionManager.getSesson().getEnhancedDriver().quit();
	}
	
	@AfterSuite
	public void afterSuite(){
		SessionManager.removeThread();
	}
}
