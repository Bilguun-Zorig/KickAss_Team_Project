package projectTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethods;

public class LeaveTest_byNadia extends CommonMethods {
	
	@BeforeMethod
	public void loginFunctionality() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		selection(cpo.leftSideMenuBar, "leaveMenu");
	}
	
	@Test(enabled = false)
	public void viewLeaveReport() {
		asserts(lpo.leavePageText, "Leave_exp");
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
	
	@Test(enabled = true)
	public void assignLeave() {
		asserts(lpo.leavePageText, "Leave_exp");
		selection(lpo.leaveMenuBar, "assignLeave");
		asserts(lpo.assignLeaveText,"assignLeave");
		
		click(lpo.searchName);			
		lpo.searchName.sendKeys(lpo.getAdminFirstName(lpo.adminName));		
		lpo.selectSearchDropdown(lpo.searchNameList,lpo.getAdminFirstName(lpo.adminName));		
		
		lpo.selectOptionDropdown(lpo.leaveType, lpo.dropdownList, "leaveType");
		
		sendTextByConfigText(lpo.fromDate, "dateWrongFormat");
		wait(lpo.toDate);
		click(lpo.toDate);
		asserts(lpo.dateErrorText,"dateErrorText_exp");
		
		lpo.fillFromToDates("leaveDate", "leaveDate","duration");
		
		click(lpo.submitButton);
		lpo.AssertDayBalance(lpo.dayBalance);
	}
	
	
	@Test(enabled = false)
	public void cancelMyLeaveAndWriteComment() {
		
		
	}
	
	@AfterMethod(enabled = false)
	public void logoutFunctionality() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
