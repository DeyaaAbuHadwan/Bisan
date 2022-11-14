package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import Classes.DriverMethods;
import Contact.CustomerTab;
import Contact.GeneralTabContact;
import Contact.SupplierTab;
import Pages.LogIn;

public class TestContact {

	DriverMethods method;
	WebDriver driver;

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
		CustomerTab customer = new CustomerTab(method);
		SupplierTab supplier = new SupplierTab(method);

		loginTest.logIn();
		GeneralTabContact generalCont = new GeneralTabContact(method);
		method.click((By.name("fileMenu")), 10);
		method.click((By.name("contact")), 10);
		method.click((By.xpath(".//*[@role ='menu'][2]//*[@name='contact']")), 10);
		method.click((By.name("new")), 10);
		method.waitForCurrentWindow("newTitlecontact1", 5000);
		generalCont.fillGeneralTab("CONTAC7", "auto Coontact", "ضياء", "P", "English");
		customer.customerTab("S", "1300");
		supplier.customerTab("P", "2300");
		method.click((By.name("save")), 10);
		method.logOut();
		Thread.sleep(1000);
	}

	@AfterTest
	public void afterTest() throws IOException, InterruptedException {
		method.screenShot("Error");
driver.quit();
	}
}
