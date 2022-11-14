package SalesInvoice;

import org.openqa.selenium.By;

import Classes.DriverMethods;

public class MainSaleInfo {

	String contact = ".//*[@name='contact' and @role='textbox']";
	String currency = ".//*[@name='currency' and @role='textbox']";
	String salesman = ".//*[@name='salesman' and @role='textbox']";
	String warehouse = ".//*[@name='warehouse' and @role='textbox']";
	String truck = ".//*[@name='truck' and @role='textbox']";
	String branch = ".//*[@name='branch' and @role='textbox']";
	String department = ".//*[@name='department' and @role='textbox']";
	DriverMethods testMethod;

	public MainSaleInfo(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void fill_Info(String contactVal, String currVal, String warehouseVal, String salesmanVal, String truckVal,
			String branchVal, String departVal) throws InterruptedException {
		testMethod.waitForCurrentWindow("newTitleinvoice1", 1000);
		testMethod.setTextByXpath(By.xpath(this.contact), 10, contactVal);
		testMethod.setTextByXpath(By.xpath(this.currency), 10, currVal);
		testMethod.setTextByXpath(By.xpath(this.salesman), 10, salesmanVal);
		testMethod.setTextByXpath(By.xpath(this.warehouse), 10, warehouseVal);
		testMethod.setTextByXpath(By.xpath(this.truck), 10, truckVal);
		testMethod.setTextByXpath(By.xpath(this.branch), 10, branchVal);
		testMethod.setTextByXpath(By.xpath(this.department), 10, departVal);
	}

}
