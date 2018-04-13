package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWebDriver {
	private WebDriver driver;
	private static CustomWebDriver ourInstance = new CustomWebDriver();

	public static CustomWebDriver getInstance() {
		return ourInstance;
	}

	private CustomWebDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
