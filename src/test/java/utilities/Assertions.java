package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertions extends PageInitializer {
	
	//This method will check if the webElement is displayed or not. 
	public void asserts(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}
	//This method will check if actual (WebElemen) is equal to expected or not
	public void asserts(WebElement actual, String expected) {
		Assert.assertEquals(actual.getText(), BaseClass.getAppText(expected));
	}
	//This method will check if the list contains the value or not
	public void asserts (List <WebElement> elements, String value) {
		for(WebElement element : elements) {
			if(element.getText().contains(value)) {
				Assert.assertTrue(true);
			}
		}
	}

}
