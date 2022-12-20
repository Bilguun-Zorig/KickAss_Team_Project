package projectTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.BaseClass;
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
		dp.searchName.sendKeys(dp.getAdminFirstName(dp.employeeName));		
		dp.selectSearchDropdown(dp.employeeNameList,dp.getAdminFirstName(dp.employeeName));	
		click(dp.searchButton);
	}
	@Test(enabled=true)
	public void jobTitleTest() {
		click(dp.jobTitle);
		dp.selectJob(3);
		click(dp.searchButton);
	}
	@Test(enabled=true)
	public void locationTest() {
		click(dp.locationFiled);
		dp.selectLocation(3);
		click(dp.searchButton);
	}
	@AfterMethod
	public void loggingOut() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}	
}