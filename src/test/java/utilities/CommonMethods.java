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
	
	public static boolean isDemoMode = true;
	public static Faker fake = new Faker();
	public static FakeValuesService faker = new FakeValuesService(new Locale("en-GB"), new RandomService());
	
	// This method will select a single webelement from a list of webelements 
	//Remember the given String must match with webelement
	public void selection (List<WebElement> elements, String select) {
		for(WebElement element : elements) {
			if(element.getText().trim().equalsIgnoreCase(getAppText(select).trim())) {
				highLightElementMethod(element);
				element.click();
				break;
			}
		}
	}
	//This method will click on a single webelement
	public void click(WebElement element) {
		highLightElementMethod(element);
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
		highLightElementMethod(element);
		element.sendKeys(BaseClass.getLogin(keyName));
	}
	// This method will send data from configAppText.properties to the webElement
	public void sendTextByConfigText(WebElement element, String keyName) {
		highLightElementMethod(element);
		element.sendKeys(BaseClass.getAppText(keyName));
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
	public static void wait(double second) {
		try {
			Thread.sleep((int) (second * 1000));
		} catch (Exception e) {

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
	//this methods has nested loop
	// - outside each for loop will iterate through each drop-down menu on the same page and then pick/click on a text-box that 
	// matches the given text (Title of the text-box)
	// - inside loop will select a element from the drop-down menu
	public void selectEInfo(List<WebElement> infoList, String infoType, List<WebElement> selections, String status) {
		for(WebElement info : infoList) {
			if(info.getText().contains(BaseClass.getAppText(infoType))) {
				highLightElementMethod(info);
				info.click();
				scrollUp();
				threadSleep(3);
				selection(selections, status);
				break;
			}
		}
	}
	
	 // this is indicator for element blinks
	public void highLightElementMethod(WebElement element) {
		try {
			if (isDemoMode) {
				for (int i = 0; i <= 2; i++) {

					// Create object of a JavascriptExecutor interface
					JavascriptExecutor js = (JavascriptExecutor) getDriver();
					// use executeScript() method and pass the arguments
					// Here i pass values based on css style. Yellow background color with solid red
					// color border.
					js.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							element);

					wait(0.2);

					// Create object of a JavascriptExecutor interface
					js = (JavascriptExecutor) getDriver();
					// use executeScript() method and pass the arguments
					// Here i pass values based on css style. Yellow background color with solid red
					// color border.
					js.executeScript(
							"arguments[0].setAttribute('style', 'background: red; border: 2px solid yellow;');",
							element);

					wait(0.2);

					// Create object of a JavascriptExecutor interface
					js = (JavascriptExecutor) getDriver();
					// use executeScript() method and pass the arguments
					// Here i pass values based on css style. Yellow background color with solid red
					// color border.
					js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');",
							element);
				}
			}
		} catch (Exception e) {

		}

	}
	
}
