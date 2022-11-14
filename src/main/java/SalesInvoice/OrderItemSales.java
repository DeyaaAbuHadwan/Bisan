package SalesInvoice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Classes.DriverMethods;

public class OrderItemSales {
	String orderDetailsTab = "CONTAINER_orderDetail";
	String table = "orderDetail";
	DriverMethods testMethod;

	public OrderItemSales(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void fillTab(String[] item, String[] unit, String[] price, String[] quantity) throws InterruptedException {
		testMethod.click(By.name(this.orderDetailsTab), 10);
		for (int i = 0; i < item.length; i++) {
			testMethod.setCell(table, (i + 1) + "", "2", item[i]);
			testMethod.setCell(table, (i + 1) + "", "4", unit[i]);
			testMethod.setCell(table, (i + 1) + "", "6", quantity[i]);
			testMethod.setCell(table, (i + 1) + "", "5", price[i]);
		}

	}

}
