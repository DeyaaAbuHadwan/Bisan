package TestCases;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Classes.AppiumMethod;
import Classes.DriverMethods;
import Contact.CustomerTab;
import Contact.GeneralTabContact;
import Contact.SupplierTab;
import Pages.LogIn;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TabletTest {

	AppiumMethod method;
	WebDriver driver;

	@BeforeTest
	public void before() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
//			dc.setCapability("deviceName", "Galaxy Tab A");
//			dc.setCapability("platformVersion", "11");
			dc.setCapability("platformName", "Android");
			dc.setCapability("appPackage", "org.nativescript.btablet");
			dc.setCapability("appActivity", "com.tns.NativeScriptActivity");
			dc.setCapability("udid", "192.168.168.103:5555");
			System.out.println("Set Capability Done :)");
			method = new AppiumMethod(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc));
			System.out.println("- Driver was set with: TGAI6DWW8XYX99RO Done.");
			method.getAppiumDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		} catch (Exception e) {
//			if (e.getCause().toString().equals("java.net.ConnectException: Connection refused: connect")) {
//				System.out.println(">Error: " + e.getCause() + ".\nPLEASE CHECK FROM APPIUM SERVER.");
//				throw new IllegalArgumentException("- Error: PLEASE CHECK FROM APPIUM SERVER.");
//			} else
			e.printStackTrace();
		}
	}

	@Test
	public void testA() throws InterruptedException, IOException {
		method.sendKey("account", "demoqalive");
		method.sendKey("username", "deyaa");
		method.sendKey("password", "100100b");
		method.click("loginBtn");
		Thread.sleep(15000);
		method.click("areas");
		method.click("cat_1");
		method.scrollAndClick("contact_0000001.");
		method.click("salesInvoice");
		method.click("add");
		method.click("group_000001");
		method.click("open_search");
		method.scrollToAndGet("itemName_PCS_000000030");
		method.sendKey("quantity_PCS_000000030", "5");
		method.search("searchbar", "Deyaa");
		method.sendKey("quantity_PCS_000DEYAA1", "5");
		method.click("add");
		method.screenShot("Appium ");
		method.click("save");
		method.click("tabletCancelPrinting");
		method.goToMainMenu();
		method.waitUntilLoadPage("mainPage", 20);
		method.logOut();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
