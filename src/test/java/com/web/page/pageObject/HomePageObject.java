package com.web.page.pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.web.page.pageUi.HomePageElements;
import com.web.selenium.webSelenium.api.action.PageManager;
import com.web.selenium.webSelenium.api.driver.DriverManager;
import com.web.selenium.webSelenium.api.element.EnhancedElement;
import com.web.selenium.webSelenium.enums.Locator;


public class HomePageObject extends PageManager{
	
	private static HomePageObject instance;
	
	public static HomePageObject getInstance(){
        if(instance == null){
            instance = new HomePageObject();
        }
        return instance;
    }
	public HomePageObject openBanksURL(){
		DriverManager.getEnhancedDriver().get("https://www.boursakuwait.com.kw/en/participants/participants/listed-companies");
        return this;
    }
	public HomePageObject getBanksSheetTable() {
		DriverManager.getEnhancedDriver().get("https://www.boursakuwait.com.kw/en/participants/participants/listed-companies");
		//Test
		DriverManager.getEnhancedDriver().navigate().refresh();
        int whileCount =50;
        while(!HomePageElements.list_ofBanks.findElement().isDisplayed() && whileCount-- > 0){
        	DriverManager.getEnhancedDriver().navigate().refresh();
        }
        HomePageElements.list_ofBanks.waitForElementToBePresent(30);
        List<WebElement> list = HomePageElements.list_ofBanks.findElements();
        int count =1;
        for(int i = 0; i< list.size();i++){
            WebElement element = HomePageElements.list_ofBanks.findElements().get(i);
            while(!element.isDisplayed() && whileCount-- > 0){
            	DriverManager.getEnhancedDriver().navigate().refresh();
            }
            element.click();
            waitForPageToLoad();
            clickFinancialData();
            waitForPageToLoad();
            printSheetTable();
            clickBalanceSheet();
            waitForPageToLoad();
            printSheetTable();
            clickCashFlow();
            waitForPageToLoad();
            printSheetTable();
            DriverManager.getEnhancedDriver().get("https://www.boursakuwait.com.kw/en/participants/participants/listed-companies");
            element = HomePageElements.list_ofBanks.findElements().get(i);
            while(!element.isDisplayed() && whileCount-- > 0){
            	DriverManager.getEnhancedDriver().navigate().refresh();
            }
            count++;
        }
        return this;
	}
	private void printSheetTable(){
		int count =0;
        while(!HomePageElements.list_sheetTable.findElement().isDisplayed() && count++ < 10){
        	DriverManager.getEnhancedDriver().navigate().refresh();
        }
        
        List<WebElement> list = HomePageElements.list_sheetTable.findElements();
        for(int i = 0; i < list.size(); i++){
            int inter = i+ 1;
            WebElement key = EnhancedElement.init("((//tr[contains(@class,'sc-fzpkqZ')])["+inter+"]/td)[1]", Locator.xpath).findElement();
            List<WebElement> columns = EnhancedElement.init("(//tr[contains(@class,'sc-fzpkqZ')])["+inter+"]/td", Locator.xpath).findElements();
            StringBuilder messageList = new StringBuilder();
            messageList.append(key.getText()).append(" |");
            for(int j = 2; j < columns.size(); j++){
            	EnhancedElement element = EnhancedElement.init("((//tr[contains(@class,'sc-fzpkqZ')])["+inter+"]/td)["+j+"]", Locator.xpath);
            	element.waitForElementVisibility(10);
                element.scrollToElement();
                messageList.append(element.getText()).append(" |");
            }
            System.out.println(messageList.toString());
        }
	}
	private void clickFinancialData(){
		DriverManager.getEnhancedDriver().navigate().refresh();
		HomePageElements.btn_financialData.waitForElementToBePresent(20);
        HomePageElements.btn_financialData.scrollToElement();
        HomePageElements.btn_financialData.findElement().click();
    }
	private void clickBalanceSheet(){
		DriverManager.getEnhancedDriver().navigate().refresh();
		HomePageElements.tab_balanceSheet.waitForElementToBePresent(20);
		HomePageElements.tab_balanceSheet.scrollToElement();
        HomePageElements.tab_balanceSheet.findElement().click();
	}
	private void clickCashFlow(){
		DriverManager.getEnhancedDriver().navigate().refresh();
		HomePageElements.tab_cashFlow.waitForElementToBePresent(20);
		HomePageElements.tab_cashFlow.scrollToElement();
		HomePageElements.tab_cashFlow.findElement().click();
	}
}
