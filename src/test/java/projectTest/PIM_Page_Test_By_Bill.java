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
	}
	@Test
	public void addNewEmployee() {
		
	}
	
	@AfterMethod
	public void logoutFunctionality() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
