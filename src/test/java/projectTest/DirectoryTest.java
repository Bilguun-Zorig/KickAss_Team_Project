package projectTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethods;
import utilities.ListenerAnalyzer;

@Listeners(ListenerAnalyzer.class)

public class DirectoryTest extends CommonMethods{
	
	@BeforeMethod
	public void loginToDiPage() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		selection(cpo.leftSideMenuBar, "dr");
		asserts(dp.pageHeader, "dr");
	}
	@Test(enabled=true)
	public void addEmployeesNames() {
		click(dp.searchName);			
		dp.searchName.sendKeys(dp.getAdminFirstName(dp.employeeNameField));		
		dp.selectSearchDropdown(dp.employeeNameList,dp.getAdminFirstName(dp.employeeNameField));	
		click(dp.searchButton);
		click(dp.employeeNameHeader);
		asserts(dp.employeeNameHeader, "employeeName");
	}
	@Test(enabled=true)
	public void jobTitleTest() {
		click(dp.jobTitleField);
		dp.selectJob(3);
		click(dp.searchButton);
		click(dp.jobTitleHeader);
		asserts(dp.jobTitleHeader, "jobtitle");
	}
	@Test(enabled=true)
	public void locationTest() {
		click(dp.locationFiled);
		dp.selectLocation(3);
		click(dp.searchButton);
		click(dp.locationHeader);
		asserts(dp.locationHeader, "location");
	}
	@AfterMethod
	public void loggingOut() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}	
}