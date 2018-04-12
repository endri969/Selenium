package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavigateLinks {
	WebDriver driver;

	public NavigateLinks(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how = How.XPATH,using = "//*[@id=\"offcanvas-menu\"]/ul/li[1]/a")
	public WebElement linkHotels;
	@FindBy(how = How.XPATH,using = "//*[@id=\"offcanvas-menu\"]/ul/li[2]/a")
	public WebElement linkFlights;
	@FindBy(how = How.XPATH,using = "//*[@id=\"offcanvas-menu\"]/ul/li[3]/a")
	public WebElement linkTours;
	@FindBy(how = How.XPATH,using = "//*[@id=\"offcanvas-menu\"]/ul/li[4]/a")
	public WebElement linkCars;
	@FindBy(how = How.XPATH,using = "//*[@id=\"offcanvas-menu\"]/ul/li[5]/a")
	public WebElement linkOffers;
	@FindBy(how = How.XPATH,using = "//*[@id=\"offcanvas-menu\"]/ul/li[6]/a")
	public WebElement linkVisa;
	@FindBy(how = How.XPATH,using = "//*[@id=\"offcanvas-menu\"]/ul/li[7]/a")
	public WebElement linkBlog;

	public void clickHotels(){
		linkHotels.click();
	}
	public void clickFligths(){
		linkFlights.click();
	}
	public void clickTours(){
		linkTours.click();
	}
	public void clickCars(){
		linkCars.click();
	}
	public void clickOffers(){
		linkOffers.click();
	}
	public void clickVisa(){
		linkVisa.click();
	}
	public void clickBlog(){
		linkBlog.click();
	}

}
