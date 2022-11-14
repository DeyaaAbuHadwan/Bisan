package Item;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Classes.DriverMethods;

public class UnitTab {
	String unitType = "unitType";
	String itemUnitTab = "itemUnit";
	String smallestUnit = ".//*[@name='smallestUnit' and @role='textbox'] ";
	String defaultUnit = ".//*[@name='defaultUnit' and @role='textbox'] ";
	String reportUnit = ".//*[@name='reportUnit' and @role='textbox'] ";
	String table = "unitList";
	DriverMethods testMethod;

	public UnitTab(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void fillTab(String unitType, String smallestUnit, String defaultUnit, String reportUnit)
			throws IOException, InterruptedException {
		testMethod.click(By.name(this.itemUnitTab), 10);
		testMethod.select(this.unitType, unitType);
		testMethod.setTextByXpath(By.xpath(this.smallestUnit), 10, smallestUnit);
		testMethod.setCell(table, "1", "2", "PCS");
		testMethod.setCell(table, "2", "2", "11");

		System.out.println("Done");
		testMethod.checkCell(table, "1", "tablet", true);
		testMethod.checkCell(table, "2", "tablet", true);
		testMethod.screenShot("unit Tab");

	}

}
