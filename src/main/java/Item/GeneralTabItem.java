package Item;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Classes.DriverMethods;

public class GeneralTabItem {
	String nameEn = "nameEN";
	String nameAr = "nameAR";
	String group = ".//*[@name='group' and @role='textbox'] ";
	String itemCategory = ".//*[@name='itemCategory' and @role='textbox'] ";
	String brand = ".//*[@name='brand' and @role='textbox'] ";
	String classification = ".//*[@name='classification' and @role='textbox'] ";
	String warranty = ".//*[@name='warranty' and @role='textbox'] ";
	String vendor = ".//*[@name='vendor' and @role='textbox'] ";
	String itemFamily = ".//*[@name='itemFamily' and @role='textbox'] ";
	String code = ".//*[@name='code' and @role='textbox'] ";
	DriverMethods testMethod;

	public GeneralTabItem(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void fillGeneralTab(String code, String nameEnVal, String nameArVal, String group, String itemCategory,
			String brand, String classification, String warranty, String vendor, String itemFamily)
			throws IOException, InterruptedException {
		testMethod.setTextByXpath(By.xpath(this.code), 10, code);
		testMethod.setText(this.nameEn, 10, nameEnVal);
		testMethod.setText(this.nameAr, 10, nameArVal);
		testMethod.setTextByXpath(By.xpath(this.group), 10, group);
		testMethod.setTextByXpath(By.xpath(this.itemCategory), 10, itemCategory);
		testMethod.setTextByXpath(By.xpath(this.vendor), 10, vendor);
		testMethod.setTextByXpath(By.xpath(this.brand), 10, brand);
		testMethod.setTextByXpath(By.xpath(this.classification), 10, classification);
		testMethod.setTextByXpath(By.xpath(this.warranty), 10, warranty);
		testMethod.setTextByXpath(By.xpath(this.itemFamily), 10, itemFamily);
		testMethod.screenShot("General Tab");

		
	}

}
