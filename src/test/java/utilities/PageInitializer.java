package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

public class PageInitializer extends BaseClass{
	
	public static WebDriverWait wait;
	
	public static void initializer() {
		wait = new WebDriverWait(BaseClass.getDriver(), Constants.Explicit_Wait_Time);
	}
}
