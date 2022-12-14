package projectTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
		sendTextByConfigText(kppo.keyInputBox, "kpitx");
		sendTextByConfigText(kppo.jobTitleBox, "a");
		click(kppo.jobDropdown);
		click(kppo.saveButton);
		asserts(kppo.listOfKpi, "kpitx");
		asserts(kppo.listOfKpi, kppo.lastKpi());
	}
	@Test(enabled=true)
	public void test02EditKPI() {
		kppo.clickEditButton(kppo.listOfKpi, "kpitx");
		asserts(kppo.subHeader, "ek");
		sendTextByConfigText(kppo.keyInputBox, "ekpitx");
		click(kppo.saveButton);
		asserts(kppo.listOfKpi, "ekpitx");
		asserts(kppo.listOfKpi, kppo.lastKpi());
	}
	@Test(enabled=true)
	public void test03DeleteKPI() {
		kppo.selectKPI(kppo.listOfKpi, "ekpitx");
		scrollUp();
		click(kppo.deleteButton);
		click(kppo.yesDeleteButton);
		kppo.assertsNotEqual(kppo.listOfKpi, "ekpitx");
		asserts(kppo.listOfKpi, kppo.lastKpi());
	}
	@AfterMethod
	public void loggingOut() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}