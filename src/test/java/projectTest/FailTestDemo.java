package projectTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethods;
import utilities.ListenerAnalyzer;

@Listeners(ListenerAnalyzer.class)
public class FailTestDemo extends CommonMethods {
	
	@BeforeMethod
	public void loginFunctionality() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		selection(cpo.leftSideMenuBar, "leaveMenu");
		asserts(lpo.leavePageText, "Leave_exp");
	}
	
	@Test
	public void assignLeave() {		
		selection(lpo.leaveMenuBar, "assignLeave");
		asserts(lpo.assignLeaveText,"assignLeave");		
		click(lpo.searchName);			
		lpo.searchName.sendKeys(lpo.getAdminFirstName(lpo.adminName));		
		lpo.selectSearchDropdown(lpo.searchNameList,lpo.getAdminFirstName(lpo.adminName));		
		lpo.selectOptionDropdown(lpo.leaveType, lpo.dropdownList, "leaveType");		
		sendTextByConfigText(lpo.fromDate, "dateWrongFormat");		
		click(lpo.submitButton);	
		asserts(lpo.popupBox);
	}	
}	