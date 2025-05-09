package com.web.test;

import com.web.page.pageObject.HomePageObject;
import com.web.selenium.webSelenium.annotation.common.Scope;
import com.web.selenium.webSelenium.annotation.inject.InjectPageObject;
import com.web.selenium.webSelenium.api.enums.ObjectScope;
import org.testng.annotations.Test;

public class testDemo {

	@InjectPageObject
	@Scope(type = ObjectScope.METHOD)
	private HomePageObject homePageObject;

	@Test
	public void testDemoDataInFixStructure(){

		homePageObject.getTest();


		//Used data in fix structure
//		String url = DataManager.mapData("url");
		//Test
//		DriverManager.getEnhancedDriver().navigate().to(url);
//		HomePageElements.BtnLogo.waitForElementToBePresent(10);
//		boolean status = HomePageElements.BtnLogo.isEnabled();
//		new Assertion().assertEquals(status, true);
	}
	
//	@BeforeSuite
//	@InjectData(jsonPath = "")
//	private void beforeSuite() {
//		// Init Session
//		SessionManager.setSesson(new SessionService());
//		SessionManager.getSesson().setGlobalConfig(GlobalConfigBuilder.getInstace().getConfig());
//		// Launch local grid with localhost:4444
////		enhancedDriver.launchGridLocal();
//	}
//
//	@BeforeMethod
//	public void beforeMethod(){
////		DriverManager.startDriver();
//
//		// Setup data
//		String testData = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\web\\data\\test.json";
//		DataMapper data = new DataMapper(testData,"fr");
//		SessionManager.getSesson().getEnhancedDriver();
//	}
	
	@Test
	public void testDemoFeatureinit() throws InterruptedException {
//		DriverManager.getEnhancedDriver().get("https://www.boursakuwait.com.kw/en/participants/participants/listed-companies");
//		EnhancedElement btn_financialData = EnhancedElement.init("(//*[@id='/en/stock/financial-data/income-statement-pill'])[1]", Locator.xpath);
//		EnhancedElement tab_incomeStatement = EnhancedElement.init("(//*[@id='/en/stock/financial-data/income-statement-pill'])[2]", Locator.xpath);
//		EnhancedElement tab_balanceSheet = EnhancedElement.init("//*[@id='/en/stock/financial-data/balance-sheet-pill']", Locator.xpath);
//		EnhancedElement tab_cashFlow = EnhancedElement.init("//*[@id='/en/stock/financial-data/cash-flow-statement-pill']", Locator.xpath);
//		EnhancedElement list_ofBanks = EnhancedElement.init("//tr[@class='sc-fzpkqZ QaPvo']/td/a", Locator.xpath);
//		EnhancedElement list_sheetTable = EnhancedElement.init("//tr[contains(@class,'sc-fzpkqZ')]", Locator.xpath);
		System.out.println("The EnhancedElement class will hold the key and the locator and only init the WebElement when the user call the element action");
//		System.out.println(btn_financialData.getKey());
//		System.out.println(btn_financialData.getLocator());
//		System.out.println(tab_cashFlow.getKey());
//		System.out.println(tab_cashFlow.getLocator());
//		System.out.println(list_sheetTable.getKey());
//		System.out.println(list_sheetTable.getLocator());
//		System.out.println(tab_balanceSheet.getKey());
//		System.out.println(tab_balanceSheet.getLocator());
//		System.out.println(list_ofBanks.getKey());
//		System.out.println(list_ofBanks.getLocator());
//		System.out.println(tab_incomeStatement.getKey());
//		System.out.println(tab_incomeStatement.getLocator());
	}
	
	@Test
	public void testDemoFPageObject() throws InterruptedException {
//		HomePageObject.getInstance().openBanksURL().getBanksSheetTable();
	}
	
	
//	@AfterMethod
//	public void afterMethod(){
//		SessionManager.getSesson().getEnhancedDriver().quit();
//	}
//
//	@AfterSuite
//	public void afterSuite(){
//		SessionManager.removeThread();
//	}
}
