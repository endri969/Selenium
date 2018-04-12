package steps;

import base.BaseUtil;
import base.UtilSelenium;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.NavigateLinks;

import java.util.concurrent.TimeUnit;

public class NavigateLinksSteps extends BaseUtil {
	private BaseUtil base;

	public NavigateLinksSteps(BaseUtil base){
		this.base = base;
	}


	@Given("^Navigate to phptravels\\.net page$") public void navigateToPhptravelsNetPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		base.driver.navigate().to(UtilSelenium.PHPTRAVELS);
	}

	@Then("^I navigate to the Hotels page$") public void iNavigateToTheHotelsPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		navigateLinks.clickHotels();
	}

	@Then("^I navigate to the Flights page$") public void iNavigateToTheFlightsPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		navigateLinks.clickFligths();
	}

	@Then("^I navigate to the Tours page$") public void iNavigateToTheToursPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		navigateLinks.clickTours();
	}

	@Then("^I navigate to the Cars page$") public void iNavigateToTheCarsPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		navigateLinks.clickCars();
	}

	@Then("^I navigate to the Offers page$") public void iNavigateToTheOffersPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		navigateLinks.clickOffers();
	}

	@Then("^I navigate to the Visa page$") public void iNavigateToTheVisaPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		navigateLinks.clickVisa();
	}

	@Then("^I navigate to the Blog page$") public void iNavigateToTheBlogPage() throws Throwable {
		NavigateLinks navigateLinks = new NavigateLinks(base.driver);
		navigateLinks.clickBlog();
	}
}
