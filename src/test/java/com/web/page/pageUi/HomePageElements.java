package com.web.page.pageUi;


import com.web.selenium.webSelenium.annotation.define.PageElement;
import com.web.selenium.webSelenium.annotation.define.WebElement;
import com.web.selenium.webSelenium.api.element.EnhancedElement;
import com.web.selenium.webSelenium.enums.Locator;
import lombok.Data;

@Data
@PageElement(pageName = "homePage")
public class HomePageElements{

	@WebElement(identifier = "//*[@id='logo-icon']",
			locator = Locator.xpath)
	private EnhancedElement BtnLogo;

	@WebElement(identifier = "(//*[@id='/en/stock/financial-data/income-statement-pill'])[1]",
			locator = Locator.xpath)
	private EnhancedElement btn_financialData;

	@WebElement(identifier = "(//*[@id='/en/stock/financial-data/income-statement-pill'])[2]",
			locator = Locator.xpath)
	private EnhancedElement tab_incomeStatement;

	@WebElement(identifier = "//*[@id='/en/stock/financial-data/balance-sheet-pill']",
			locator = Locator.xpath)
	private EnhancedElement tab_balanceSheet;

	@WebElement(identifier = "//*[@id='/en/stock/financial-data/cash-flow-statement-pill']",
			locator = Locator.xpath)
	private EnhancedElement tab_cashFlow;

	@WebElement(identifier = "//tr[@class='sc-fzpkqZ QaPvo']/td/a",
			locator = Locator.xpath)
	private EnhancedElement list_ofBanks;

	@WebElement(identifier = "//tr[contains(@class,'sc-fzpkqZ')]",
			locator = Locator.xpath)
	private EnhancedElement list_sheetTable;
}
