package utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertions extends PageInitializer {
	
	public void asserts(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}
	
	public void asserts(WebElement actual, String expected) {
		Assert.assertEquals(actual.getText(), BaseClass.getAppText(expected));
	}
}
