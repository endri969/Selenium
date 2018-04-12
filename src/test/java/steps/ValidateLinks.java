package steps;

import base.BaseUtil;
import base.UtilSelenium;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidateLinks {
	private BaseUtil base;

	public ValidateLinks(BaseUtil base){
		this.base = base;
	}
	@When("^I validate all links$") public void iValidateAllLinks() throws Throwable {
		base.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		base.driver.navigate().to(UtilSelenium.AUTOMATION_PRACTICE);
		List<WebElement> links = base.driver.findElements(By.tagName("a"));
		System.out.println("Total links are: "+links.size());
		for(WebElement element : links){
			String url = element.getAttribute("href");
			UtilSelenium.verifyLinkActivate(url);
		}
	}
}
