package com.web.selenium.webSelenium.elements;

import java.util.List;

import com.web.selenium.webSelenium.annotation.inject.InjectDriver;
import com.web.selenium.webSelenium.api.driver.EnhancedDriver;
import com.web.selenium.webSelenium.api.element.EnhancedElement;
import org.openqa.selenium.*;

import com.web.selenium.webSelenium.enums.Locator;

public class EnhancedElementImp extends AbstractElement implements EnhancedElement {

	@InjectDriver
	private EnhancedDriver enhancedDriver;

	
	private EnhancedElementImp(String key, Locator locator) {
		super(key, locator);
	}

	private WebElement initWebElement(){
		return new FindElement().initializeWebElement(this.getKey(),this.getLocator());
	}

	private List<WebElement> initListOfWebElement(){
		return new FindElement().initializeWebElementList(this.getKey(),this.getLocator());
	}

	@Override
	public void scrollToElement(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) enhancedDriver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: \"instant\", block: \"center\", inline: \"nearest\" });", initWebElement());
    }
	/**
	 * block: start, center, end
	 * @param block
	 */
	@Override
	public void scrollToElement(String block){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) enhancedDriver;
		jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: \"instant\", block: \""+block+"\", inline: \"nearest\" });", initWebElement());
	}
	/**
	 * behavior: smooth, instant, auto,
	 * block: start, center, end
	 * @param behavior
	 * @param block
	 */
	@Override
	public void scrollToElement(String behavior, String block){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) enhancedDriver;
		jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: \""+behavior+"\", block: \""+block+"\", inline: \"nearest\" });", initWebElement());
	}
	@Override
	public boolean waitForElementVisibility(Long seconds){
		return initWebElement().isDisplayed();
	}
	@Override
	public boolean waitForElementToBePresent(Long seconds){
		WebElement element1 = initWebElement();
		WebElement element2 = initWebElement();
		return element1.isDisplayed() && element2.isEnabled();
	}
	@Override
	public void click() {
		initWebElement().click();
	}
	@Override
	public void submit() {
		initWebElement().submit();
	}
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		initWebElement().sendKeys(keysToSend);
	}
	@Override
	public void clear() {
		initWebElement().clear();
	}
	@Override
	public String getTagName() {
		return initWebElement().getTagName();
	}
	@Override
	public String getAttribute(String name) {
		return initWebElement().getAttribute(name);
	}
	@Override
	public boolean isSelected() {
		return initWebElement().isSelected();
	}
	@Override
	public boolean isEnabled() {
		return initWebElement().isEnabled();
	}
	@Override
	public String getText() {
		return initWebElement().getText();
	}
	@Override
	public boolean isDisplayed() {
		return initWebElement().isDisplayed();
	}
	@Override
	public Point getLocation() {
		return initWebElement().getLocation();
	}
	@Override
	public Dimension getSize() {
		return initWebElement().getSize();
	}
	@Override
	public Rectangle getRect() {
		return initWebElement().getRect();
	}
	@Override
	public String getCssValue(String propertyName) {
		return initWebElement().getCssValue(propertyName);
	}
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return initWebElement().getScreenshotAs(target);
	}
	@Override
	public List<WebElement> findElements(By by) {
		return initListOfWebElement();
	}
	@Override
	public WebElement findElement(By by) {
		return initWebElement();
	}
}
