package projectTest;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethods;

public class Leave_by_Nadia extends CommonMethods {
	
	@BeforeMethod
	public void loginFunctionality() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		selection(cpo.leftSideMenuBar, "leaveMenu");
	}
	
	@Test(enabled = true)
	public void viewLeaveReport() {
		asserts(lpo.leavePageText, "Leave_ext");
		selection(lpo.leaveMenuBar, "reportOption");		
		click(lpo.usageReport);
		asserts(lpo.usageReportText, "usageReport_ext");
		click(lpo.leaveTypeCheck);		
		click(lpo.typeBox);		
		lpo.selectOptionDropdown(getAppText("type"));
		click(lpo.periodBox);
		lpo.selectOptionDropdown(getAppText("period"));
		lpo.pastEmployeeSwitchButton.click();
		lpo.generateButton.click();
		lpo.asserts(lpo.trimText(lpo.recordFoundText), "recordFound_ext");
		lpo.fullScreen.click();
		asserts(lpo.exitScreen);
		lpo.exitScreen.click();
	}
	
	@Test(enabled = false)
	public void assignLeave() {
		
	}
	
	@Test(enabled = false)
	public void searchLeaveByName() {
		
	}
	
	@AfterMethod
	public void logoutFunctionality() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
