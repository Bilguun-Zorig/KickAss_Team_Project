package utilities;

import java.util.List;
import java.util.Locale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class CommonMethods extends Assertions{
	
	public static Faker fake = new Faker();
	public static FakeValuesService faker = new FakeValuesService(new Locale("en-GB"), new RandomService());
	
	// This method will select a single webelement from a list of webelements 
	//Remember the given String must match with webelement
	public void selection (List<WebElement> elements, String select) {
		for(WebElement element : elements) {
			if(element.getText().trim().equalsIgnoreCase(getAppText(select).trim())) {
				element.click();
				break;
			}
		}
	}
	//This method will click on a single webelement
	public void click(WebElement element) {
		wait(element).click();
	}
	//This method is Explicit wait
	public WebElement wait(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitElementDisplayed(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// This method will send data from configLogin.properties to the webElement
	public void sendTextByConfig(WebElement element, String keyName) {
		element.sendKeys(BaseClass.getLogin(keyName));
	}
	// This method will send login values (username and password) to the each text-box 
	// Also it makes 2 lines of code 1 line
	public void sendLoginValues(WebElement username, String user,WebElement password, String pass) {
		sendTextByConfig(username, user);
		sendTextByConfig(password, pass);
	}
	//thread.sleep
	public void threadSleep(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//this method will scroll up web page
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}
	//this method will scroll down web page
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");;
	}
	
	
	
}
