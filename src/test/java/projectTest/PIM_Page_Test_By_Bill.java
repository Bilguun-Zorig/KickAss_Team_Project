package projectTest;

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
	@Test (enabled = false)
	public void addNewEmployee() {
		selection(ppo.getTopBarMenu(), "ae");
		asserts(ppo.getAddEmployeeTitle(), "ae");
		ppo.sendFirstLastName();
		selection(ppo.getCancelSaveButton(), "save");
		waitElementDisplayed(ppo.getPersonalDetails());
		asserts(ppo.getPersonalDetails());
		ppo.fillPersonalDetails();
		selection(ppo.getTopBarMenu(), "eL");
		asserts(ppo.getEmployeeList(), ppo.value);
	}
	@Test
	public void searchForEmployee() {
		asserts(ppo.getEmployeeInfoText());
		
	}
	@Test
	public void createANewReportTable() {}
	
	
	@AfterMethod (enabled = false)
	public void logoutFunctionality() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
