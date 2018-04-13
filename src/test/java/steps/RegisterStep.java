package steps;

import base.BaseUtil;
import base.UtilSelenium;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The following program register a user to the http://automationpractice.com page
 *
 * @author U185726 Endri Zylali
 * @version 1.0
 * @since 2018-04-11
 *
 *
 */
public class RegisterStep {
	private BaseUtil base;

	/**
	 * Constructor for register page
	 * BaseUtil is dependency injected by the Selenium api
	 * @param base
	 */
	public RegisterStep(BaseUtil base) {
		this.base = base;
	}

	/**
	 * Navigating to the http://automationpractice.com page
	 * @throws Throwable
	 */
	@Given("^I navigate to the automation practice$") public void iNavigateToTheAutomationpractice() throws Throwable {
		base.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		base.driver.manage().window().maximize();
		base.driver.get(UtilSelenium.AUTOMATION_PRACTICE);
	}

	@Then("^I navigate to register for the first time$") public void iNavigateAndRegisterForTheFirstTime()
			throws Throwable {
		/**
		 * WebElement for Singin link
		 * @param singIn
		 */
		WebElement singIn = base.driver.findElement(By.xpath(" //a[contains(text(),'Si')]"));
		singIn.click();
	}

	/**
	 * Entering the email
	 * @param email
	 * @throws Throwable
	 */
	@And("^I enter email as \"([^\"]*)\"$") public void iEnterEmailAs(String email) throws Throwable {
		WebElement emailEl = base.driver.findElement(By.id("email_create"));
		WebElement btnCreateAccount = base.driver.findElement(By.id("SubmitCreate"));
		UtilSelenium.moveToElementAndSend(emailEl, email, base.driver);
		btnCreateAccount.click();
	}

	/**
	 * Entering the necessary information to the register form
	 * @param dataTable
	 * @throws Throwable
	 */
	@Then("^I enter the necessary information to create an account$") public void iEnterTheNecessaryInformationToCreateAnAccount(
			DataTable dataTable) throws Throwable {
		/**
		 * Converting the dataTable to a list of list of type String
		 * @param data
		 */
		List<List<String>> data = dataTable.raw();
		Thread.sleep(3000);
		/**
		 * Selecting the radio button for Mr. or Mrs.
		 * @param title
		 */
		if (data.get(1).get(1).equals("Mr.")) {
			WebElement title = base.driver.findElement(By.id("id_gender1"));
			title.click();
		} else if (data.get(1).get(1).equals("Mrs.")) {
			WebElement title = base.driver.findElement(By.id("id_gender2"));
			title.click();
		} else {
			Assert.assertTrue("Title is not correct", false);
		}
		/**
		 * Entering the first name
		 * @parma firstName
		 */
		WebElement firstName = base.driver.findElement(By.id("customer_firstname"));
		Assert.assertTrue("Element is not displayed", firstName.isDisplayed());
		UtilSelenium.moveToElementAndSend(firstName, data.get(2).get(1), base.driver);
		/**
		 * Entering the last name
		 * @param lastname
		 */
		WebElement lastname = base.driver.findElement(By.id("customer_lastname"));
		Assert.assertTrue("Element is not displayed", lastname.isDisplayed());
		UtilSelenium.moveToElementAndSend(lastname, data.get(3).get(1), base.driver);
		/**
		 * Entering the password
		 * @param password
		 */
		WebElement password = base.driver.findElement(By.id("passwd"));
		Assert.assertTrue("Element is not displayed", password.isDisplayed());
		UtilSelenium.moveToElementAndSend(password, data.get(4).get(1), base.driver);
		/**
		 * Parsing the birth date and selecting the dropdowns
		 * @param date
		 * @param day
		 * @param month
		 * @param years
		 */
		String date[] = data.get(5).get(1).split("-");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int years = Integer.parseInt(date[2]);

		//Assert.assertTrue("Element is not displayed", base.driver.findElement(By.id("days")).isDisplayed());
		Select select = new Select(base.driver.findElement(By.id("days")));
		select.selectByValue(day + "");

		//Assert.assertTrue("Element is not displayed", base.driver.findElement(By.id("months")).isDisplayed());
		new Select(base.driver.findElement(By.id("months"))).selectByValue(month + "");

		//Assert.assertTrue("Element is not displayed", base.driver.findElement(By.id("years")).isDisplayed());
		new Select(base.driver.findElement(By.id("years"))).selectByValue(years + "");
		/**
		 * Selecting the newsletter checkbox
		 * @param newsletter
		 */
		//Assert.assertTrue("Element is not displayed",base.driver.findElement(By.id("newsletter")).isDisplayed());
		base.driver.findElement(By.id("newsletter")).click();
		/**
		 * Entering the company
		 * @param company
		 */
		WebElement company = base.driver.findElement(By.id("company"));
		Assert.assertTrue("Element is not displayed",company.isDisplayed());
		UtilSelenium.moveToElementAndSend(company, data.get(6).get(1), base.driver);
		/**
		 * Entering the address
		 * @param address
		 */
		WebElement address = base.driver.findElement(By.id("address1"));
		Assert.assertTrue("Element is not displayed",address.isDisplayed());
		UtilSelenium.moveToElementAndSend(address, data.get(7).get(1), base.driver);
		/**
		 * Entering the city
		 * @param city
		 */
		WebElement city = base.driver.findElement(By.id("city"));
		Assert.assertTrue("Element is not displayed",city.isDisplayed());
		UtilSelenium.moveToElementAndSend(city, data.get(8).get(1), base.driver);
		/**
		 * Selecting the state
		 * @param state
		 */
		//Assert.assertTrue("Element is not displayed",base.driver.findElement(By.id("id_state")).isDisplayed());
		new Select(base.driver.findElement(By.id("id_state"))).selectByVisibleText(data.get(9).get(1));
		/**
		 * Entering the zip code
		 * @param zip
		 */
		WebElement zip = base.driver.findElement(By.id("postcode"));
		Assert.assertTrue("Element is not displayed",zip.isDisplayed());
		UtilSelenium.moveToElementAndSend(zip, data.get(10).get(1), base.driver);
		/**
		 * Entering additional information
		 * @param additionalInformation
		 */
		WebElement additionalInformation = base.driver.findElement(By.id("other"));
		Assert.assertTrue("Element is not displayed",additionalInformation.isDisplayed());
		UtilSelenium.moveToElementAndSend(additionalInformation, data.get(11).get(1), base.driver);
		/**
		 * Entering the phone number
		 * @param phone
		 */
		WebElement phone = base.driver.findElement(By.id("phone_mobile"));
		Assert.assertTrue("Element is not displayed",phone.isDisplayed());
		UtilSelenium.moveToElementAndSend(phone, data.get(12).get(1), base.driver);
		/**
		 * Entering the alias
		 * @param alias
		 */
		WebElement alias = base.driver.findElement(By.id("alias"));
		UtilSelenium.moveToElementAndSend(alias, data.get(7).get(1), base.driver);
		/**
		 * Submitting the form
		 * @parma submitAccount
		 */
		//base.driver.findElement(By.id("submitAccount")).click();
	}

	/**
	 * Validating the registration
	 * @throws Throwable
	 */
	@And("^The register should be successful$") public void theRegisterShouldBeSuccessful() throws Throwable {
		/**
		 * Locating a paragraph which is shown after registration
		 * @param paragraph
		 */
		WebElement paragraph = base.driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
		Assert.assertTrue("The registration is not successful", paragraph.isDisplayed());
		// driver.execute_script("window.history.go(-1)")
	}
}
