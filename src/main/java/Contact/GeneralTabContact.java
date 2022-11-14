package Contact;

import java.io.IOException;

import org.openqa.selenium.By;

import Classes.DriverMethods;

public class GeneralTabContact {
	String nameEn = "nameEN";
	String nameAr = "nameAR";
	String taxType = "cusTaxType";
	String language = "language";
	DriverMethods testMethod;
	String code = ".//*[@name='code' and @role='textbox'] ";

	public GeneralTabContact(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void fillGeneralTab(String code,
			String nameEnVal, String nameArVal, String taxTypeVal, String languageVal)
			throws IOException, InterruptedException {
		testMethod.setTextByXpath(By.xpath(this.code), 10, code);
		testMethod.setText(this.nameEn, 10, nameEnVal);
		testMethod.setText(this.nameAr, 10, nameArVal);
		testMethod.select(this.taxType, taxTypeVal);
		testMethod.select(this.language, languageVal);
		testMethod.screenShot("General Tab");
	}
}
