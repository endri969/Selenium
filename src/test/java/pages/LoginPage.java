package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how = How.ID,using = "li_myaccount")
	public WebElement dropdownMyAccount;
	@FindBy(how = How.XPATH,using = "//*[@id=\"li_myaccount\"]/ul/li[1]/a")
	public WebElement linkSingIn;


	public void clickMyAccount(){
		Assert.assertTrue("Element is not displayed",dropdownMyAccount.isDisplayed());
		if(dropdownMyAccount.isDisplayed()){
			dropdownMyAccount.click();
		}
	}
	public void clickSingIn() throws InterruptedException {

		Thread.sleep(2000);
		linkSingIn.click();
	}


}
