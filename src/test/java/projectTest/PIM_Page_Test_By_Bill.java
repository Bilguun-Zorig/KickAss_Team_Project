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
		selection(cpo.leftSideMenuBar, "pim");
	}
	@Test 
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
	public void searchForEmployee() {}
	@Test
	public void createANewReportTable() {}

	@AfterMethod (enabled = false)
	public void logoutFunctionality() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
