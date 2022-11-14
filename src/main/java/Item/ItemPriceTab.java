package Item;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;

import Classes.DriverMethods;

public class ItemPriceTab {

	String priceListTab = "CONTAINER_itemPrice";
	String table = "itemPrice";
	DriverMethods testMethod;

	public ItemPriceTab(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void fillTab(String[] priceList, String[] unit, String[] currency, String[] price) throws IOException, InterruptedException {
		testMethod.click(By.name(priceListTab), 10);
		testMethod.click(By.name(priceListTab), 10);
		for (int i = 0; i < price.length; i++) {
			testMethod.setCell(table, (i + 1) + "", "2", priceList[i]);
			testMethod.setCell(table, (i + 1) + "", "6", price[i]);
			testMethod.setCell(table, (i + 1) + "", "4", unit[i]);
		}
		testMethod.screenShot("item price Tab");

	}

}
