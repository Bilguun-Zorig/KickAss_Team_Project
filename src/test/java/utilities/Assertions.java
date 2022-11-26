package utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertions extends PageInitializer {
	
	public void asserts(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}
}
