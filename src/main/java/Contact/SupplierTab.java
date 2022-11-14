package Contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Classes.DriverMethods;

public class SupplierTab {
	String isSupplier = "isSupplier";
	String customerTabName = "supplier";
	String priceList = "supPriceList";
	String account = "supAccount";
	DriverMethods testMethod;

	public SupplierTab(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void customerTab(String priceListVal, String cusAccountVal) throws IOException, InterruptedException {
		testMethod.click(By.name(customerTabName), 10);
		testMethod.check(isSupplier);
		testMethod.setText(this.priceList, 10, priceListVal);
		testMethod.setText(this.account, 0, cusAccountVal);
		testMethod.screenShot("Customer Tab");

	}

}
