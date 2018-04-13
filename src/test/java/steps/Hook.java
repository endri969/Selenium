package steps;

import base.BaseUtil;
import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil {
	private BaseUtil base;

	public Hook(BaseUtil base){
		this.base = base;
	}

	@Before
	public void intializeTest(){
		System.out.println("Opening the browser");
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		base.driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\GeckoDriver\\geckodriver.exe");
//		base.driver = new FirefoxDriver();
	}
	@After
	public void tearDownTest(Scenario scenario){
		if(scenario.isFailed()){
			System.out.println(scenario.getName());
			System.out.println("Closing the browser");
			base.driver.quit();
		}
		else {
			//base.driver.quit();
		}
	}
}
