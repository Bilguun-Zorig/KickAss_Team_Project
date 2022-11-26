package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonMethods extends Assertions{
	
	public static void click(WebElement element) {
		wait(element).click();
	}
	public static WebElement wait(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
