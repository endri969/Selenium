package base;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;

public class UtilSelenium {
	public static final String PHPTRAVELS = "https://www.phptravels.net";
	public static final String PHPTRAVELS_SINGIN = PHPTRAVELS+"/login";
	public static final String AUTOMATION_PRACTICE = "http://automationpractice.com/index.php";

	public static void moveToElementAndSend(WebElement element, String message,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(message);
		actions.build().perform();
	}
	public static void moveToElementAndClick(WebElement element,WebDriver driver){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();

	}
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}
	public static void verifyLinkActivate(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();

			if(httpURLConnection.getResponseCode() == 200){
				System.out.println(linkUrl+" - "+httpURLConnection.getResponseMessage());
			}
			if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println(linkUrl+" - "+httpURLConnection.getResponseMessage()+" - "+HttpURLConnection.HTTP_NOT_FOUND);
				Assert.assertTrue(linkUrl+" - "+httpURLConnection.getResponseMessage()+" - "+HttpURLConnection.HTTP_NOT_FOUND,false);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}
}
