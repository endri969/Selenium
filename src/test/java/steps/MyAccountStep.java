package steps;


import base.BaseUtil;
import base.UtilSelenium;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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
		base.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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
		Thread.sleep(1000);
		goBack();
	}

	/**
	 * Method to go back page
	 */
	public void goBack(){
		/**
		 * @param goBack
		 */
		JavascriptExecutor js = (JavascriptExecutor) base.driver;
		js.executeScript("window.history.go(-1)");
	}

	/**
	 * Navigating to my wishlist
	 * @throws Throwable
	 */
	@Then("^I navigate to my wishlist$") public void iNavigateToMyWishlist() throws Throwable {
		/**
		 * WebElement for wishlist
		 * @param whishList
		 */
		WebElement whishList =base.driver.findElement(By.xpath("//span[contains(text(),'My w')]"));
		Thread.sleep(1000);
		whishList.click();
		Thread.sleep(1000);
		goBack();
	}

	/**
	 * Navigating to my credit slips
	 * @throws Throwable
	 */
	@Then("^I navigate to my credit slips$") public void iNavigateToMyCreditSlips() throws Throwable {
		/**
		 * WebElement for credit
		 * @param credit
		 */
		WebElement credit =base.driver.findElement(By.xpath("//span[contains(text(),'credit')]"));
		Thread.sleep(1000);
		credit.click();
		Thread.sleep(1000);
		goBack();
	}

	/**
	 * Navigating to my address
	 * @throws Throwable
	 */
	@Then("^I navigate to my address$") public void iNavigateToMyAddress() throws Throwable {
		/**
		 * WebElement for address
		 * @param address
		 */
		WebElement address =base.driver.findElement(By.xpath("//span[contains(text(),'address')]"));
		Thread.sleep(1000);
		address.click();
		Thread.sleep(1000);
		goBack();
	}

	/**
	 * Navigating to my personal information
	 * @throws Throwable
	 */
	@Then("^I navigate to my personal information$") public void iNavigateToMyPersonalInformation() throws Throwable {
		/**
		 * WebElement for address
		 * @param personalInformation
		 */
		WebElement personalInformation =base.driver.findElement(By.xpath("//span[contains(text(),'personal')]"));
		Thread.sleep(1000);
		personalInformation.click();
		Thread.sleep(1000);
		goBack();
	}

	/**
	 * Searching for an item
	 * @param item
	 * @throws Throwable
	 */
	@Then("^I search for \"([^\"]*)\"$") public void iSearchFor(String item) throws Throwable {
		/**
		 * WebElement for search
		 * @param search
		 */
		WebElement search =base.driver.findElement(By.id("search_query_top"));
		UtilSelenium.moveToElementAndSend(search,item,base.driver);
		base.driver.findElement(By.xpath("//button[contains( text(),'')]")).click();
	}

	/**
	 * Sorting price from high to low
	 * @throws Throwable
	 */
	@Then("^I sort by the price from lowest to highest$") public void iSortByThePriceFromLowestToHighest()
			throws Throwable {
		/**
		 * WebElement for dropdown to set the price
		 * @param price
		 */
		Thread.sleep(1000);
		Select price = new Select(base.driver.findElement(By.id("selectProductSort")));
		price.selectByValue("price:asc");

	}

	/**
	 * Adding item to the cart
	 * @throws Throwable
	 */
	@Then("^I add to cart the first item$") public void iAddToCartTheFirstItem() throws Throwable {

		WebElement firstProduct = base.driver.findElement(By.xpath("//a[@data-id-product='1']"));
		firstProduct.click();
	}

	@And("^I proceed to checkout and pay by bank$") public void iProceedToCheckoutAndPayByBank() throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.driver,10);
		WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
		checkOut.click();
		Thread.sleep(1000);
		List<WebElement> proceedToCheckOut =base.driver.findElements(By.xpath("//a[@title='Proceed to checkout']"));
		UtilSelenium.moveToElementAndClick(proceedToCheckOut.get(1),base.driver);
		proceedToCheckOut.get(1).click();

		Thread.sleep(1000);
		WebElement addressCheckout = base.driver.findElement(By.name("processAddress"));
		addressCheckout.click();

		WebElement agreeCheckBox = base.driver.findElement(By.name("cgv"));
		agreeCheckBox.click();
		Thread.sleep(1000);
		WebElement shippingCheckout = base.driver.findElement(By.name("processCarrier"));
		shippingCheckout.click();

		Thread.sleep(1000);
		WebElement payByBank = base.driver.findElement(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a"));
		payByBank.click();

		Thread.sleep(1000);
		WebElement confirmOrder = base.driver.findElement(By.cssSelector("#cart_navigation > button"));
		confirmOrder.click();

		Thread.sleep(1000);
		WebElement backToOrders = base.driver.findElement(By.cssSelector("#center_column > p > a"));
		backToOrders.click();
	}

	@Then("^I add to cart item nr \"([^\"]*)\"$") public void iAddToCartItemNr(String number) throws Throwable {
		Thread.sleep(1000);
		WebElement item = base.driver.findElement(By.cssSelector("#center_column > ul > li:nth-child("+number+") > div > div.left-block > div"));
		Actions actions = new Actions(base.driver);
		actions.moveToElement(item);
		actions.build().perform();
		WebElement add = base.driver.findElement(By.xpath("//a[@data-id-product='"+number+"']"));
		actions.moveToElement(add);
		actions.click().build().perform();

	}
}
