package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LeavePageObjects;

public class PageInitializer extends BaseClass{
	
	public static WebDriverWait wait;
	public static HomePageObjects hpo;
	public static CommonPageObjects cpo;
	public static LeavePageObjects lpo;
	
	public static void initializer() {
		cpo = new CommonPageObjects();
		hpo = new HomePageObjects();
		lpo = new LeavePageObjects();
		wait = new WebDriverWait(BaseClass.getDriver(), Constants.Explicit_Wait_Time);
	
	}
}
