package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.KPIPerformancePageObjects;
import pageObjects.LeavePageObjects;
import pageObjects.PIMPageObjects;
import pageObjects.RecruitmentPageObjects;

public class PageInitializer extends BaseClass{
	
	public static WebDriverWait wait;
	public static HomePageObjects hpo;
	public static CommonPageObjects cpo;
	public static PIMPageObjects ppo;
	public static KPIPerformancePageObjects kppo;
	public static RecruitmentPageObjects rpo;
	public static LeavePageObjects lpo;

	public static void initializer() {
		wait = new WebDriverWait(BaseClass.getDriver(), Constants.Explicit_Wait_Time);
		hpo = new HomePageObjects();
		cpo = new CommonPageObjects();
		ppo = new PIMPageObjects();
		kppo = new KPIPerformancePageObjects();
		rpo = new RecruitmentPageObjects();
		lpo = new LeavePageObjects();
	}
}
