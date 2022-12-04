package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.PIMPageObjects;

public class PageInitializer extends BaseClass{
	
	public static WebDriverWait wait;
	public static HomePageObjects hpo;
	public static CommonPageObjects cpo;
	public static PIMPageObjects ppo;
	
	public static void initializer() {
		cpo = new CommonPageObjects();
		hpo = new HomePageObjects();
		ppo = new PIMPageObjects();
		wait = new WebDriverWait(BaseClass.getDriver(), Constants.Explicit_Wait_Time);
	}
}
