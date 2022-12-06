package projectTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethods;
import utilities.ListenerAnalyzer;

@Listeners(ListenerAnalyzer.class)
public class PIM_Page_Test_By_Bill extends CommonMethods {
	
	@BeforeMethod
	public void loginFunctionality() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		asserts(ppo.getPimPageText(), "db");
		selection(cpo.leftSideMenuBar, "pim");
		asserts(ppo.getPimPageText(), "pim");
	}
	@Test (enabled = true)
	public void addNewEmployee() {
		selection(ppo.getTopBarMenu(), "ae");
		asserts(ppo.getAddEmployeeTitle(), "ae");
		ppo.sendFirstLastName();
		selection(ppo.getCancelSaveButton(), "save");
		waitElementDisplayed(ppo.getPersonalDetails());
		asserts(ppo.getPersonalDetails());
		ppo.fillPersonalDetails();
		selection(ppo.getTopBarMenu(), "eL");
		asserts(ppo.getEmployeeIDList(), ppo.value);
	}
	@Test (enabled = true)
	public void searchForEmployee() {
		asserts(ppo.getEmployeeInfoText());
		selectEInfo(ppo.getEmployeeInfoList(), "es", ppo.getNationalitiesList(), "status");
		selectEInfo(ppo.getEmployeeInfoList(), "jobTitle", ppo.getNationalitiesList(), "jT");
		selection(ppo.getCancelSaveButton(), "search");
		asserts(ppo.getJobTitleList(), "jT");
	}
	@Test 
	public void createANewReportTable() {
		selection(ppo.getTopBarMenu(), "rs");
		asserts(ppo.getEmployeeReportText(), "er");
		selection(ppo.getCancelSaveButton(), "add");
		sendTextByConfigText(ppo.getReportNameInputField(), "reportName");
		selectEInfo(ppo.getEmployeeInfoList(), "sc", ppo.getNationalitiesList(), "en");
		selectEInfo(ppo.getEmployeeInfoList(), "include", ppo.getNationalitiesList(), "cape");
		selectEInfo(ppo.getEmployeeInfoList(), "sdfg", ppo.getNationalitiesList(), "ec");
		click(ppo.getPlusButton());
		ppo.selection(ppo.getListOfItems(), "removed", ppo.getRemoveItemButton());
		selection(ppo.getCancelSaveButton(), "save");
		waitElementDisplayed(ppo.getReportName());
		asserts(ppo.getReportName());
	}
	@AfterMethod (enabled = true)
	public void logoutFunctionality() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
