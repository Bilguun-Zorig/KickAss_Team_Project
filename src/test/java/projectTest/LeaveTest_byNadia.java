package projectTest;

import org.bouncycastle.crypto.macs.CMac;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethods;
import utilities.ListenerAnalyzer;

@Listeners(ListenerAnalyzer.class)
public class LeaveTest_byNadia extends CommonMethods {
	
	@BeforeMethod
	public void loginFunctionality() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		selection(cpo.leftSideMenuBar, "leaveMenu");
		asserts(lpo.leavePageText, "Leave_exp");
	}
	
	@Test(enabled = true, priority = 1)
	public void viewLeaveReport() {		
		selection(lpo.leaveMenuBar, "reportOption");		
		click(lpo.usageReport);
		asserts(lpo.usageReportText, "usageReport_exp");
		click(lpo.leaveTypeCheck);		
		lpo.selectOptionDropdown(lpo.typeBox, lpo.dropdownList, "type");
		lpo.selectOptionDropdown(lpo.periodBox, lpo.dropdownList, "period");
		lpo.pastEmployeeSwitchButton.click();
		lpo.generateButton.click();
		lpo.AssertsTwoStrings(lpo.trimText(lpo.recordFoundText), "recordFound_exp");
		lpo.fullScreen.click();
		asserts(lpo.exitScreen);
		lpo.exitScreen.click();
	}
	
	@Test(enabled = true, priority = 2)
	public void assignLeave() {		
		selection(lpo.leaveMenuBar, "assignLeave");
		asserts(lpo.assignLeaveText,"assignLeave");		
		click(lpo.searchName);			
		lpo.searchName.sendKeys(lpo.getAdminFirstName(lpo.adminName));		
		lpo.selectSearchDropdown(lpo.searchNameList,lpo.getAdminFirstName(lpo.adminName));		
		lpo.selectOptionDropdown(lpo.leaveType, lpo.dropdownList, "leaveType");			
		lpo.fillFromToDates("leaveDate", "leaveDate","duration");		
		click(lpo.submitButton);
		lpo.AssertDayBalance(lpo.dayBalance);		
	}	
	
	@Test(enabled = true, priority = 3)
	public void rejectAssignLeave() {
		selection(lpo.leaveMenuBar, "myLeave");
		asserts(lpo.myLeaveText,"myLeaveText_exp");	
		scrollDown();
		lpo.rejectAssignLeave(lpo.tableList);			
	}
	
	@AfterMethod(enabled = true)
	public void logoutFunctionality() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}































