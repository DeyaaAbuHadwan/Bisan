package Classes;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverClasses.*;
import io.qameta.allure.Allure;

public class DriverMethods {
	private WebDriver driver;
	final int smallTimeout = 4;

	public DriverMethods(String browser) {
		DriverBrowsers browDriver = new DriverBrowsers(browser);
		this.driver = browDriver.getDriver();

	}

	public WebElement findElement(By by, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public void click(By by, int time) {
		findElement(by, time).click();
	}

	public String getText(By by, int time) {
		return findElement(by, time).getText();
	}

	public void setText(String name, int time, String value) throws InterruptedException {
		findElement(By.name(name), time).sendKeys(value);
		Thread.sleep(200);
	}

	public void setTextByXpath(By by, int time, String value) throws InterruptedException {
		findElement(by, time).clear();
		findElement(by, time).sendKeys(value);
		findElement(by, time).sendKeys(Keys.ENTER);
		Thread.sleep(200);
	}

	public WebElement excuteJS(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (WebElement) js.executeScript(script);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void openLink(String link) {
		driver.get(link);
		driver.manage().window().maximize();
	}

	public List<WebElement> getElements(By by, int time) {
		findElement(by, time);
		return driver.findElements(by);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void screenShot(String name) throws IOException, InterruptedException {
		// Screenshot
		Thread.sleep(1000);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(name + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
		Allure.addAttachment("ScreenShot", FileUtils.openInputStream(SrcFile));
	}

	// Current Window Method
	// -->
	public final void validateCurrentWindow(String windowName) {
		String currentName = getCurrentWindowName();
		if (!currentName.equals(windowName))
			throw new IllegalArgumentException(
					"Current Window is '" + currentName + "', it should be '" + windowName + "'");
	}

	public final void waitForCurrentWindow(String windowName, int timeOut) {
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < timeOut) {
			try {
				validateCurrentWindow(windowName);
				return;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		System.out.println("Waiting for window '" + windowName + "' timed out! current Window is '"
				+ _getActiveWindow().getAttribute("name") + "'");
		throw new IllegalArgumentException("Waiting for window '" + windowName + "' timed out! current Window is '"
				+ _getActiveWindow().getAttribute("name") + "'");
	}

	public WebElement _getActiveWindow() {

		WebElement currentWindow = null;
		for (int i = 0; i < smallTimeout; i++) {
			currentWindow = (WebElement) ((JavascriptExecutor) driver).executeScript("return getActiveWindow()");
			if (currentWindow != null)
				return currentWindow;
			forceWait(200);
		}
		return null;
	}

	public String getCurrentWindowName() {
		WebElement currentWindow = _getActiveWindow();
		System.out.println(currentWindow);
		return (currentWindow == null || currentWindow.getAttribute("name") == null ? "null"
				: currentWindow.getAttribute("name"));

	}

	// <--- End Of window methods
	// ____________________________
	public void forceWait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void select(String menu, String value) {
		click((By.name(menu)), 10);
		click((By.xpath(".//ul//li[@name='" + value + "']")), 10);
	}

	public void check(String checkBox) {
		WebElement element = findElement(By.name(checkBox), 10);
		Actions action = new Actions(driver);
		action.click(element).perform();
	}

	public void dblClickEvents(WebElement element) {
		Actions action = new Actions(getDriver());
		action.doubleClick(element).perform();
	}

	public void setCell(String table, String row, String column, String value) throws InterruptedException {
		String elementTable = ".//*[@name='" + table + "' and @role ='grid']";
		String cell = elementTable + "//table[contains(@id,'gridview')][" + row + "]//tbody//tr[1]//td[" + column
				+ "]//div";
		WebElement element = findElement(By.xpath(cell), 10);
		String id = findElement(By.xpath(".//*[@name='" + table + "' and @role ='grid']"), 10).getAttribute("id");
		dblClickEvents(element);

		excuteJS("Ext.getCmp('" + id + "').getPlugin('cellplugin').activeEditor.setValue(\"" + value + "\");");
		Actions action = new Actions(getDriver());
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(200);
	}

	public WebElement _getCell(String table, String row, String column) {
		String elementTable = ".//*[@name='" + table + "' and @role ='grid']";
		String cell = elementTable + "//table[contains(@id,'gridview')][" + row + "]//tbody//tr[1]//td[" + column
				+ "]//div";
		return findElement(By.xpath(cell), 10);
	}

	public void checkCell(String table, String row, String column, boolean check) {
		String id = findElement(By.xpath(".//*[@name='unitList' and @role ='grid']"), 10).getAttribute("id");
		excuteJS("checkCell('" + id + "', '" + column + "', " + row + ", " + check + ")");
	}

	public void clickEvents(WebElement element) {
		Actions action = new Actions(getDriver());
		action.click(element).perform();

	}

	public void closeCurrentTab() {
		String JS = "const activeWindow= getActiveWindow().getAttribute('name'); document.getElementsByName(activeWindow+'-window-close')[0].click();";
		excuteJS(JS);
	}

	public boolean validateFieldValue(By field, String value) {
		String realValue = findElement(field, 10).getAttribute("value").trim();
		int index = realValue.indexOf('.');
		realValue = realValue.substring(0, index + 3);
		boolean match = Double.parseDouble(realValue) == Double.parseDouble(value);
		if (!match)
			throw new IllegalArgumentException("The expected value : \"" + Double.parseDouble(value)
					+ "\", But the real value is: \"" + Double.parseDouble(realValue) + "\"");
		return match;
	}

	public void logOut() {
		click(By.name("logout-button"), 10);
	}
}
