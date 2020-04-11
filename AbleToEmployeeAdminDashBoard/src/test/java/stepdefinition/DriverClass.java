package stepdefinition;

import org.openqa.selenium.WebDriver;

public abstract class DriverClass {
	static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}
}
