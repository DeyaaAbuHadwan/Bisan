package Classes;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import io.qameta.allure.Allure;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

public class AppiumMethod {
//	private AndroidDriver driver;
//
//	public AppiumMethod(AndroidDriver driver) {
//		this.driver = driver;
//	}
//
//	@SuppressWarnings("rawtypes")
//	public AndroidDriver getAppiumDriver() {
//		return driver;
//	}
//
//	public boolean checkIfServerIsRunnning() {
//		boolean isServerRunning = false;
//		ServerSocket serverSocket;
//		try {
//			serverSocket = new ServerSocket(4723);
//			serverSocket.close();
//			System.exit(0);
//			throw new IllegalArgumentException("Please check from Appium server.");
//		} catch (Exception e) {
//
//			isServerRunning = true;
//		} finally {
//			serverSocket = null;
//		}
//		return isServerRunning;
//	}
//
//	public void scrollAndClick(String desccontent_desc) {
//		try {
//			WebElement el = (getAppiumDriver()).findElementByAndroidUIAutomator(
//					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\""
//							+ desccontent_desc + "\"))");
//			el.click();
//		} catch (Exception e) {
//
//			if (checkIfServerIsRunnning())
//				closeCase();
//			throw new IllegalArgumentException("- Error: Cannot find Element: " + desccontent_desc);
//		}
//	}
//
//	public void scrollToAndGet(String desccontent_desc) {
//		try {
//			getAppiumDriver().findElementByAndroidUIAutomator(
//					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\""
//							+ desccontent_desc + "\"))");
//			clickScroll = true;
//		} catch (Exception e) {
//
//			throw new IllegalArgumentException("- Error: Cannot find Element: " + desccontent_desc);
//		}
//	}
//
//	public void scrollOneItem() {
//		org.openqa.selenium.Dimension dim = getAppiumDriver().manage().window().getSize();
//		int start = (int) (dim.getHeight() * 0.5);
//		int end = (int) (dim.getHeight() * 0.3);
//		int half = (int) (dim.getWidth() * 0.5);
//		new TouchAction((MobileDriver) getAppiumDriver()).press(half, start).waitAction(2).moveTo(half, end).release()
//				.perform();
//	}
//
//	public void validateTextError(String text) {
//		WebElement element = getAppiumDriver().findElementById("org.nativescript.btablet:id/tv_dialog_content_desc");
//		if (!text.equals(element.getText())) {
//			System.out.println("- The Expected Text :\n" + text + "\n>But the real value is: \n" + element.getText()
//					+ "\n_________________________________________________________________________________");
//			throw new IllegalArgumentException(
//					"> The Expected Value:\n" + text + "\n> The real value is: \n" + element.getText());
//		}
//	}
//
//	public void clickOnByText(String text) {
//		WebElement element = getAppiumDriver().findElementByXPath("//android.widget.Button[@text='" + text + "']");
//		element.click();
//	}
//
//	public void select(String option) {
//		getAppiumDriver().findElement(By.xpath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Spinner[1]"))
//				.click();
////		dropdown.selectByVisibleText(option);
//		MobileElement listitem = (MobileElement) getAppiumDriver()
//				.findElement(MobileBy.AndroidUIAutomator("new UiSelector().index(2);"));
//
//		listitem.click(); // click on spinner
//	}
//
//	public WebElement findElement(String name) {
//		WebElement element = null;
//		try {
//			element = getAppiumDriver().findElementByXPath("//*[contains(@content-desc,'" + name + "')]");
//		} catch (Exception e) {
//
//			throw new IllegalArgumentException("couldn't find element: " + name);
//		}
//		return element;
//	}
//
//	public void sendKey(String name, String text) {
//		try {
////			WebElement element= getAppiumDriver().findElementByXPath("//*[contains(@content-desc,'" + name + "')]");
//			WebElement element = getAppiumDriver().findElementByXPath("//*[contains(@content-desc,'" + name + "')]");
//			element.sendKeys(text);
//		} catch (Exception e) {
//
//			throw new IllegalArgumentException("    ****** Error: Cannot find Element: " + name + " ******");
//		}
//	}
//
//	boolean clickScroll = false;
//
//	public void click(String name) {
//		if (isElementPresent(By.xpath("//*[contains(@content-desc,'" + name + "')]")))
//			getAppiumDriver().findElementByXPath("//*[contains(@content-desc,'" + name + "')]").click();
//		else if (clickScroll) {
//			scrollOneItem();
//			if (isElementPresent(By.xpath("//*[contains(@content-desc,'" + name + "')]")))
//				getAppiumDriver().findElementByXPath("//*[contains(@content-desc,'" + name + "')]").click();
//			else
//				throw new IllegalArgumentException("couldn't find element: " + name);
//		} else {
//			throw new IllegalArgumentException("couldn't find element: " + name);
//		}
//
//	}
//
//	private boolean isElementPresent(By by) {
//		try {
//			getAppiumDriver().findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//
//			return false;
//		}
//
//	}
//
//	public void validateField(String element, String value) {
//		boolean isValid = findElement(element).getText().equals(value);
//		if (!isValid)
//			throw new IllegalArgumentException("The expected value is (" + value + "), the correct value ("
//					+ findElement(element).getText() + ")");
//
//	}
//
//	public void goToMainMenu() {
//		((StartsActivity) getAppiumDriver()).startActivity("org.nativescript.btablet", "com.tns.NativeScriptActivity");
//	}
//
//	public void logOut() {
//		click("More options");
//		List<WebElement> elements = getAppiumDriver().findElementsByClassName("android.widget.TextView");
//		elements.get(elements.size() - 1).click();
//	}
//
//	public void clickAndSelect(String menu, String value) {
//		try {
//			WebElement textView = null;
//			click(menu);
//			WebElement element = getAppiumDriver()
//					.findElementByXPath("//android.widget.TextView[@text='" + value + "']");
//			element.click();
//		} catch (Exception e) {
//
//			throw new IllegalArgumentException("couldn't find element: " + value);
//		}
//	}
//
//	public void selectFromList(String value) {
//		try {
//			WebElement element = getAppiumDriver()
//					.findElementByXPath("//android.widget.TextView[@text='" + value + "']");
//			element.click();
//		} catch (Exception e) {
//
//			throw new IllegalArgumentException("couldn't find element: " + value);
//		}
//	}
//
//	public void waitDriver(int time) {
//		getAppiumDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
//	}
//
//	public void waitUntilLoadPage(String page, int time) {
//		try {
//			waitDriver(time);
//			findElement(page);
//			waitDriver(10);
//		} catch (Exception e) {
//
//			throw new IllegalArgumentException("couldn't find element: " + page);
//		}
//	}
//
//	public void closeCase() {
//		getAppiumDriver().close();
//	}
//
//	/**
//	 * This method does a swipe right
//	 */
//
//	public void swipeLeft(String name, int iteration) {
//		WebElement element = findElement(name);
//		int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
//		int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
//		int endX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.8);
//		int endY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.8);
//		if (iteration <= 0)
//			throw new IllegalArgumentException("Please Enter number greater then 1.");
//
//		for (int i = 0; i < iteration; i++)
//			new TouchAction((MobileDriver) getAppiumDriver()).press(startX, startY).waitAction(1000).moveTo(endX, endY)
//					.release().perform();
//
//	}
//
//	public void swipeRight(String name, int iteration) {
//		WebElement element = findElement(name);
//		int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
//		int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
//		int endX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.8);
//		if (iteration <= 0)
//			throw new IllegalArgumentException("Please Enter number greater then 1.");
//		for (int i = 0; i < iteration; i++)
//			new TouchAction((MobileDriver) getAppiumDriver()).press(endX, startY).waitAction(1000)
//					.moveTo(startX, startY).release().perform();
//	}
//
//	public void search(String name, String text) {
//		sendKey(name, text);
//		click(name);
//		getAppiumDriver().executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Go"));
//	}
//
//	public void screenShot(String name) throws IOException, InterruptedException {
//		// Screenshot
//		Thread.sleep(1000);
//		TakesScreenshot scrShot = ((TakesScreenshot) driver);
//		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//		File DestFile = new File(name + ".png");
//		FileUtils.copyFile(SrcFile, DestFile);
//		Allure.addAttachment("ScreenShot", FileUtils.openInputStream(SrcFile));
//	}
//
}
