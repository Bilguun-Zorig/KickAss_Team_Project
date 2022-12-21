package projectTest;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethods;
import utilities.ListenerAnalyzer;


@Listeners(ListenerAnalyzer.class)


public class MyInfo_Page_Alin extends CommonMethods{
	
	@BeforeMethod
	public void loginHomepage() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		asserts(mipo.hompageHead,"db");
		selection(cpo.leftSideMenuBar,"mi");
		asserts(mipo.hompageHead,"pim");
		selection(mipo.myInfoSideBar,"emc");
		asserts(mipo.emergencyContactHead,"aemc");
	}
	@Test (priority = 1,enabled = true)
	public void assignEmergencyContacts() {
		click(mipo.addContact);
		asserts(mipo.addEmergencyHead,"semc");
		mipo.addEmergencyContact();
		mipo.saveButton.click();
		asserts(mipo.emergencyContactHead,"aemc");
	}
	@Test (priority = 2,enabled = true)
 	public void editEmergencyContact() {
		click(mipo.editIcon);
		asserts(mipo.editEmergencyContactHead,"edmc");
		mipo.editSelection();
		mipo.saveButton.click();
		asserts(mipo.emergencyContactHead,"aemc");
	}
	
	@Test (priority = 3,enabled = true)
	public void deleteContacts() {
		click(mipo.deleteIcon);
		click(mipo.deletebutton);
		asserts(mipo.emergencyContactHead,"aemc");
	}
	
	@AfterMethod
	public void loggingOut() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
