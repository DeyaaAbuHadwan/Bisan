package Contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Classes.DriverMethods;

public class CustomerTab {
	String isCustomer = "isCustomer";
	String customerTabName = "customer";
	String priceList = "cusPriceList";
	String account = "cusAccount";
	DriverMethods testMethod;

	public CustomerTab(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void customerTab(String priceListVal, String cusAccountVal) throws IOException, InterruptedException {
		testMethod.click(By.name(customerTabName), 10);
		testMethod.check(isCustomer);
		testMethod.setText(this.priceList, 10, priceListVal);
		testMethod.setText(this.account, 0, cusAccountVal);
		testMethod.screenShot("Customer Tab");
	}

}
