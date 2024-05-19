package com.web.page.pageUi;


import com.web.selenium.webSelenium.api.element.EnhancedElement;
import com.web.selenium.webSelenium.enums.Locator;


public class HomePageElements{
	
	public static EnhancedElement BtnLogo = EnhancedElement.init("//*[@id='logo-icon']", Locator.xpath);
	public static EnhancedElement btn_financialData = EnhancedElement.init("(//*[@id='/en/stock/financial-data/income-statement-pill'])[1]", Locator.xpath);
	public static EnhancedElement tab_incomeStatement = EnhancedElement.init("(//*[@id='/en/stock/financial-data/income-statement-pill'])[2]", Locator.xpath);
	public static EnhancedElement tab_balanceSheet = EnhancedElement.init("//*[@id='/en/stock/financial-data/balance-sheet-pill']", Locator.xpath);
	public static EnhancedElement tab_cashFlow = EnhancedElement.init("//*[@id='/en/stock/financial-data/cash-flow-statement-pill']", Locator.xpath);
	public static EnhancedElement list_ofBanks = EnhancedElement.init("//tr[@class='sc-fzpkqZ QaPvo']/td/a", Locator.xpath);
	public static EnhancedElement list_sheetTable = EnhancedElement.init("//tr[contains(@class,'sc-fzpkqZ')]", Locator.xpath);
}
