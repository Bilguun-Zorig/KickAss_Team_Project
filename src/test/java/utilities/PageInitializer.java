package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;

public class PageInitializer extends BaseClass{
	
	public static WebDriverWait wait;
	public static HomePageObjects hpo;
	public static CommonPageObjects cpo;
	
	public static void initializer() {
		cpo = new CommonPageObjects();
		hpo = new HomePageObjects();
		wait = new WebDriverWait(BaseClass.getDriver(), Constants.Explicit_Wait_Time);
	}
}
