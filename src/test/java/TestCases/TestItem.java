package TestCases;

import java.io.IOException;

import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import Classes.DriverMethods;
import Contact.CustomerTab;
import Contact.GeneralTabContact;
import Contact.SupplierTab;
import Item.GeneralTabItem;
import Item.ItemPriceTab;
import Item.UnitTab;
import Pages.LogIn;

public class TestItem {

	DriverMethods method;
	WebDriver driver;
	String[] priceListArr = { "S", "S" };
	String[] unitArr = { "PCS", "11" };
	String[] currArr = { "01", "01" };
	String[] priceArr = { "15", "20" };

	@BeforeTest
	public void before() {
		System.out.println("Test..");
		method = new DriverMethods("Chrome");
		method.openLink("http://qa.bisan.com:4440/login.html");
		this.driver = method.getDriver();
	}

	@Test
	public void testA() throws InterruptedException, IOException {
		LogIn loginTest = new LogIn(method);
		loginTest.logIn();
		method.click((By.name("fileMenu")), 10);
		method.click((By.name("item")), 10);
		method.click((By.xpath(".//*[@role ='menu'][2]//*[@name='item']")), 10);
		method.click((By.name("new")), 10);
		GeneralTabItem general = new GeneralTabItem(method);
		general.fillGeneralTab("AUTOMAT20", "AUTOMATION Item", "ضياء", "000001", "1", "1", "1", "01", "0000025",
				"000000001");

		UnitTab unit = new UnitTab(method);
		unit.fillTab("Quantity", "PCS", "PCS", "PCS");

		ItemPriceTab price = new ItemPriceTab(method);
		price.fillTab(this.priceListArr, this.unitArr, this.currArr, this.priceArr);

		method.click(By.name("save"), 10);
		method.logOut();
		Thread.sleep(1000);

	}

	@AfterTest
	public void afterTest() throws IOException, InterruptedException {
		method.screenShot("Error");
		driver.quit();
	}

}
