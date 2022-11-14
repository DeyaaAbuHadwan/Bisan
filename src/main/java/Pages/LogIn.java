package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Classes.DriverMethods;

public class LogIn {
	String account = "webAccountField";
	String username = "webUsernameField";
	String pw = "webPasswordField";
	By btn = By.name("loginBtn");
	DriverMethods testMethod;

	public LogIn(DriverMethods testMethod) {
		this.testMethod = testMethod;
	}

	public void logIn() throws InterruptedException {
		testMethod.setText(account, 20, "");
		testMethod.setText(username, 10, "admin");
		testMethod.setText(pw, 10, "");
		testMethod.click(btn, 10);
//		testMethod.click(By.name("Yes"), 10);
		testMethod.waitForCurrentWindow("null1", 5000);
	}

	
}
