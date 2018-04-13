package steps;


import base.BaseUtil;
import base.UtilSelenium;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * The following program navigates to the user account of http://automationpractice.com page
 *
 * @author U185726 Endri Zylali
 * @version 1.0
 * @since 2018-04-13
 *
 *
 */
public class MyAccountStep {
	private BaseUtil base;

	/**
	 * Constructor for MyAccountStep class
	 * @param base
	 */
	public MyAccountStep(BaseUtil base){
		this.base = base;
	}
	/**
	 * Navigating to automationpractice page
	 * @throws Throwable
	 */
	@Given("^I navigate to the automationpractice page$") public void iNavigateToTheAutomationpracticePage()
			throws Throwable {
		base.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		base.driver.manage().window().maximize();
		base.driver.navigate().to(UtilSelenium.AUTOMATION_PRACTICE);
	}

	/**
	 * Singing in to the page
	 * @throws Throwable
	 */
	@Then("^I click the sing in link$") public void iClickTheSingInLink() throws Throwable {
		/**
		 * WebElement for Singin link
		 * @param singIn
		 */
		WebElement singIn = base.driver.findElement(By.xpath(" //a[contains(text(),'Si')]"));
		singIn.click();
	}
	/**
	 * Entering the email and the password
	 * @param email
	 * @param password
	 * @throws Throwable
	 */
	@And("^I enter email as \"([^\"]*)\" and the password as \"([^\"]*)\"$") public void iEnterEmailAsAndThePasswordAs(
			String email, String password) throws Throwable {
		/**
		 * WebElement for email input text
		 * @param emailEl
		 */
		WebElement emailEl = base.driver.findElement(By.id("email"));
		Assert.assertTrue("Element email is not displayed",emailEl.isDisplayed());
		UtilSelenium.moveToElementAndSend(emailEl,email,base.driver);
		/**
		 * WebElement for password input text
		 * @param passwordEl
		 */
		WebElement passwordEl = base.driver.findElement(By.id("passwd"));
		Assert.assertTrue("Element password is not displayed",passwordEl.isDisplayed());
		UtilSelenium.moveToElementAndSend(passwordEl,password,base.driver);
		/**
		 * WebElement for singin button
		 * @param singIn
		 */
		WebElement singIn = base.driver.findElement(By.id("SubmitLogin"));
		Assert.assertTrue("Element singIn button is not displayed",singIn.isDisplayed());
		singIn.click();
	}

	/**
	 * Validating the singing in
	 * @throws Throwable
	 */
	@Then("^the user account should be displayed if the login is successful$") public void theUserAccountShouldBeDisplayedIfTheLoginIsSuccessful()
			throws Throwable {
		/**
		 * Locating a paragraph which is shown after singing in
		 * @param paragraph
		 */
		WebElement paragraph = base.driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
		Assert.assertTrue("The registration is not successful", paragraph.isDisplayed());
	}

	/**
	 * Navigating to the order history
	 * @throws Throwable
	 */
	@Then("^I navigate to the order history and details$") public void iNavigateToTheOrderHistoryAndDetails()
			throws Throwable {
		/**
		 * WebElement for order history
		 * @param orderHistory
		 */
		WebElement orderHistory =base.driver.findElement(By.xpath("//span[contains(text(),'Order')]"));
		Thread.sleep(1000);
		orderHistory.click();
		goBack();
	}

	/**
	 * Method to go back page
	 */
	public void goBack(){
		/**
		 * @param goBack
		 */
		WebElement goBack = base.driver.findElement(By.id("Back"));
		goBack.click();
	}

	/**
	 * Navigating to my wishlist
	 * @throws Throwable
	 */
	@Then("^I navigate to my wishlist$") public void iNavigateToMyWishlist() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	/**
	 * Navigating to my credit slips
	 * @throws Throwable
	 */
	@Then("^I navigate to my credit slips$") public void iNavigateToMyCreditSlips() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	/**
	 * Navigating to my address
	 * @throws Throwable
	 */
	@Then("^I navigate to my address$") public void iNavigateToMyAddress() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	/**
	 * Navigating to my personal information
	 * @throws Throwable
	 */
	@Then("^I navigate to my personal information$") public void iNavigateToMyPersonalInformation() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}


}
