package com.jarvis.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import com.jarvis.errors.InvalidBrowserError;
import com.jarvis.exceptions.InvalidSelectorException;

public class Keyword {

	private static RemoteWebDriver driver = null;

	/*
	 * This methods returns the driver instance. Make sure, before calling this
	 * method one should call {@code openBrowser(String browserName)} so that it can
	 * initialise driver instance
	 * 
	 * @return driver instance
	 */
	public static RemoteWebDriver getDriver() {
		return driver;
	}

	/*
	 * This method will launch specified browser
	 * 
	 * @param browserName to launch
	 */
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Opening Chrome browser");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Opening Firefox browser");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			System.out.println("Opening Safari browser");
		} else {
			System.out.println("Invalid browser name");
			throw new InvalidBrowserError(browserName);
		}
	}

	public void openUrl(String url) {
		driver.get(url);
		System.out.println("Launching url");
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitAllWindows() {
		driver.quit();
	}

	public void ClickOn(WebElement element) {
		element.click();
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElements(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public void clickOn(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		getWebElement(locatorType, locatorValue).click();
	}

	public void enterText(String locatorType, String locatorValue, CharSequence... text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public void enterText1(String locator, CharSequence... text) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		enterText(locatorType, locatorValue, text);
	}

	public void hitKey(int keyCode) {
		try {
			Robot robo = new Robot();
			robo.keyPress(keyCode);
			robo.keyRelease(keyCode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public List<String> getTexts(String locatorType, String locatorValue) {

		List<String> texts = new ArrayList<String>();

		List<WebElement> elements = new ArrayList<WebElement>();
		elements = getWebElements(locatorType, locatorValue);

		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;

	}

	public List<String> getTexts(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		return getTexts(locatorType, locatorValue);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public List<String> getTexts(List<WebElement> items) {
		List<String> texts = new ArrayList<String>();
		for (WebElement item : items) {
			texts.add(item.getText());
		}
		return texts;
	}
	
	public String getparentWindowHandle() {
		return driver.getWindowHandle();
	}
	
	public Set<String> getAllWindowHandle() {
		return driver.getWindowHandles();
	}
	
	public void switchToParentWindow(String windowHandle) {
		Keyword.getDriver().switchTo().window(windowHandle);
	}
	
	public void switchToChildWindow() {
		// It will return the parent window name as a String
		String parentWindow = getparentWindowHandle();
		Set<String> allWindows = getAllWindowHandle();
		// Now iterate using Iterator
		Iterator<String> I1 = allWindows.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
		
	}
	
	public void performMouseHover(WebElement webElement) {
		Actions action = new Actions(driver);
		action.moveToElement(webElement).perform();
	}
	
	public static void validatePageUrl(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	
	public static void pageRefresh() {
		driver.navigate().refresh();
	}

}
