package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.KPIPerformancePageObjects;
import pageObjects.LeavePageObjects;
import pageObjects.PIMPageObjects;
import pageObjects.TimePageObject;

public class PageInitializer extends BaseClass{
	
	public static WebDriverWait wait;
	public static HomePageObjects hpo;
	public static CommonPageObjects cpo;
	public static PIMPageObjects ppo;
	public static KPIPerformancePageObjects kppo;
	public static LeavePageObjects lpo;
	public static TimePageObject tpo;
	
	public static void initializer() {
		wait = new WebDriverWait(BaseClass.getDriver(), Constants.Explicit_Wait_Time);
		hpo = new HomePageObjects();
		cpo = new CommonPageObjects();
		ppo = new PIMPageObjects();
		kppo = new KPIPerformancePageObjects();
		lpo = new LeavePageObjects();
		tpo= new TimePageObject();
	}
}
