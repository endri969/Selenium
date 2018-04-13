package steps;

import base.BaseUtil;
import base.UtilSelenium;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login extends BaseUtil {
	private BaseUtil base;
	public Login(BaseUtil base){
		this.base = base;
	}
	@Given("^I navigate to the phptravel page$") public void iNavigateToThePhptravelPage(){
		base.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		base.driver.manage().window().maximize();
		base.driver.navigate().to(UtilSelenium.PHPTRAVELS);
	}

	@Then("^I click the singin link$") public void iClickTheSinginLink() throws Throwable {
		WebElement myaccount = base.driver.findElement(By.cssSelector("body > div.tbar-top.hidden-sm.hidden-xs > div > div > div.col-md-6.col-sm-8.col-xs-5.go-left"));
		Assert.assertTrue("MyAccount is not visible",myaccount.isDisplayed());
		Actions actions = new Actions(base.driver);
		actions.moveToElement(myaccount).perform();
		actions.click().build().perform();
		//System.out.println(myaccount.getText());
		List<WebElement> links =  myaccount.findElements(By.tagName("li"));
		links.get(1).click();




//		myaccount.click();
//		Thread.sleep(2000);
//		WebElement linkSingin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"li_myaccount\"]/ul/li[1]/a")));
//		Assert.assertTrue("The link singin should be visible", linkSingin.isDisplayed());
//		if(linkSingin.isDisplayed()){
//			linkSingin.click();
//		}
/*
		LoginPage loginPage = new LoginPage(base.driver);
		loginPage.clickMyAccount();
		loginPage.clickSingIn();
*/


	}

	@And("^I enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$") public void iEnterEmailAsAndPasswordAs(String email, String password) throws Throwable {
		WebElement emailEl = base.driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input"));
		WebElement passwordEl = base.driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input"));
		WebElement btnLogin = base.driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/button"));
		UtilSelenium.moveToElementAndSend(emailEl,email,base.driver);
		UtilSelenium.moveToElementAndSend(passwordEl,password,base.driver);
		btnLogin.click();


	}

	@Then("^the user account should be displayed$") public void theUserAccountShouldBeDisplayed() throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#body-section > div > div.container.mt25.offset-0 > div > div.col-md-1.offset-0 > ul > li.active > a")));
		Assert.assertTrue("Login is not successful",element.isDisplayed());
	}
}
