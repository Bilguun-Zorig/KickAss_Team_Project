package projectTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.ListenerAnalyzer;

@Listeners(ListenerAnalyzer.class)

public class KPI_Performance_Page_Pichate extends CommonMethods{
	
	@BeforeMethod
	public void loginToKpiPage() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		asserts(kppo.pageHeader, "db");
		selection(cpo.leftSideMenuBar, "pf");
		asserts(kppo.pageHeader, "pf");
		selection(kppo.topMenu, "cf");
		asserts(kppo.dropdownMenu, "kpi");
		selection(kppo.dropdownMenu, "kpi");
	}
		
	@Test(enabled=true)
	public void test01AddKPI() {
		click(kppo.addButton);
		asserts(kppo.subHeader, "ak");
		sendTextByConfigText(kppo.keyInputBox, "kiptx");
		sendTextByConfigText(kppo.jobTitleBox, "a");
		click(kppo.jobDropdown);
		click(kppo.saveButton);
		asserts(kppo.pageHeader, "pf");
		
	}
	
	
}