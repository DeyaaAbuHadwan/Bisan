package DriverClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverBrowsers {
	private WebDriver driver;

	public DriverBrowsers(String browser) {
		switch (browser) {
//		case "FireFox":
//			System.setProperty("webdriver.gecko.driver", "./src/test/resources/Browser drivers/geckodriver.exe");
//			driver = new FirefoxDriver();
//			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/Browser drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "./src/test/resources/Browser drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Please Enter once of the following Browser: Chrome, FireFox and Edge.");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
