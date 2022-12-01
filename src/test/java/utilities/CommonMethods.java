package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonMethods extends Assertions{
	
	// This method will select a single webelement from a list of webelements 
	//Remember the given String must match with webelement
	public void selection (List<WebElement> elements, String select) {
		for(WebElement element : elements) {
			if(element.getText().equalsIgnoreCase(getAppText(select))) {
				element.click();
				break;
			}
		}
	}
	//This method will click on a single webelement
	public static void click(WebElement element) {
		wait(element).click();
	}
	//This method is Explicit wait
	public static WebElement wait(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
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
}
