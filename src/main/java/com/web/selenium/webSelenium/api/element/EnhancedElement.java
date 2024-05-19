package com.web.selenium.webSelenium.api.element;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.selenium.webSelenium.driver.SessionManager;
import com.web.selenium.webSelenium.elements.AbstractElement;
import com.web.selenium.webSelenium.elements.ElementManager;
import com.web.selenium.webSelenium.elements.EnhancedElementImp;
import com.web.selenium.webSelenium.enums.Locator;

public class EnhancedElement extends AbstractElement implements EnhancedElementImp {
	
	private EnhancedElement(String key, Locator locator) {
		super(key, locator);
	}
	
	public static EnhancedElement init(String key, Locator locator){
        return new EnhancedElement(key, locator);
    }
	
	public void scrollToElement(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) SessionManager.getSesson().getEnhancedDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: \"instant\", block: \"center\", inline: \"nearest\" });", this.findElement());
    }
	public boolean waitForElementVisibility(long seconds){
		return new WebDriverWait(SessionManager.getSesson().getEnhancedDriver(), Duration.ofSeconds(seconds))
				.until(ExpectedConditions.visibilityOf(this)).isDisplayed();
	}
	public boolean waitForElementToBePresent(long seconds){
		WebElement element1 = new WebDriverWait(SessionManager.getSesson().getEnhancedDriver(), Duration.ofSeconds(seconds))
				.until(ExpectedConditions.visibilityOf(this));
		WebElement element2 = new WebDriverWait(SessionManager.getSesson().getEnhancedDriver(), Duration.ofSeconds(seconds))
				.until(ExpectedConditions.visibilityOf(this));
		return element1.isDisplayed() && element2.isEnabled();
	}
	@Override
	public void click() {
		ElementManager.elementInit(this.getKey(),this.getLocator()).get().click();
	}
	@Override
	public void submit() {
		ElementManager.elementInit(this.getKey(),this.getLocator()).get().submit();
	}
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		ElementManager.elementInit(this.getKey(),this.getLocator()).get().sendKeys(keysToSend);
	}
	@Override
	public void clear() {
		ElementManager.elementInit(this.getKey(),this.getLocator()).get().clear();
	}
	@Override
	public String getTagName() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getTagName();
	}
	@Override
	public String getAttribute(String name) {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getAttribute(name);
	}
	@Override
	public boolean isSelected() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().isSelected();
	}
	@Override
	public boolean isEnabled() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().isEnabled();
	}
	@Override
	public String getText() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getText();
	}
	@Override
	public List<WebElement> findElements() {
		return ElementManager.elementListInit(this.getKey(),this.getLocator()).get();
	}
	@Override
	public WebElement findElement() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get();
	}
	@Override
	public boolean isDisplayed() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().isDisplayed();
	}
	@Override
	public Point getLocation() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getLocation();
	}
	@Override
	public Dimension getSize() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getSize();
	}
	@Override
	public Rectangle getRect() {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getRect();
	}
	@Override
	public String getCssValue(String propertyName) {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getCssValue(propertyName);
	}
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return ElementManager.elementInit(this.getKey(),this.getLocator()).get().getScreenshotAs(target);
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}
}
