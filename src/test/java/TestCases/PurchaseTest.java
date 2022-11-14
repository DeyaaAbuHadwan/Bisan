package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Classes.DriverMethods;
import Contact.CustomerTab;
import Contact.GeneralTabContact;
import Contact.SupplierTab;
import Pages.LogIn;
import PurhaseInvoice.MainPurchaseInfo;
import PurhaseInvoice.OrderItemPurchase;

public class PurchaseTest {

	DriverMethods method;
	WebDriver driver;

	String[] itemArr = { "AUTOMAT20", "AUTOMAT20" };
	String[] unitArr = { "PCS", "11" };
	String[] quantityArr = { "10", "10" };
	String[] priceArr = { "15", "20" };

	@BeforeTest
	public void before() {
		System.out.println("Test..");
		method = new DriverMethods("Chrome");
		method.openLink("https://a50.bisan.com/login.html?tip=false");
		this.driver = method.getDriver();
	}

	@Test
	public void testA() throws InterruptedException, IOException {
		LogIn loginTest = new LogIn(method);
		loginTest.logIn();
		method.click(By.name("purchases"), 10);
		method.click(By.name("purchaseInvoice"), 10);
		method.click(By.name("new"), 10);
		MainPurchaseInfo purchInfo = new MainPurchaseInfo(method);
		purchInfo.fill_Info("CONTAC7", "0001", "004", "00", "000");
		OrderItemPurchase itemTable = new OrderItemPurchase(method);
		itemTable.fillTab(itemArr, unitArr, priceArr, quantityArr);
		method.screenShot("Purchase Invoice");
		method.clickEvents(method.findElement(By.xpath("(.//*[@name='print' and @role='button'])[2]"), 10));
		method.clickEvents(method.findElement(By.xpath(".//*[@name='Post No Print' and @role='button']"), 10));
		try {
			method.clickEvents(method.findElement(By.xpath(".//*[@name='Yes' and @role='button']"), 10));
		} catch (TimeoutException ex) {
			System.out.println("Cannot find Yes");
		}
		method.closeCurrentTab();
		method.logOut();
		Thread.sleep(1000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
