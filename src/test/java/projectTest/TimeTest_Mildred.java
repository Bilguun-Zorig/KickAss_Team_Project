package projectTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethods;


public class TimeTest_Mildred extends CommonMethods {

	@BeforeMethod(enabled = true)
	public void loginFunctionality() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		selection(cpo.leftSideMenuBar, "time");
		selection(tpo.getTopBarMenu(), "pi");
		wait(tpo.customersBox);
		click(tpo.customersBox);
		wait(tpo.addCustomer);
		click(tpo.addCustomer);
			
	}
	@Test(enabled = true, priority =1)
	public void addNewCustomerwithNameandDescription() {
		tpo.sendCustomerName(); // will call method to send random customer name.
		wait(tpo.addDescriptionBox);
		tpo.addDescriptionBox.sendKeys(tpo.timeDescription);
		click(tpo.saveButton);
		wait(tpo.newCustomerTable);
		asserts(tpo.newCustomerTable);
	}
	@Test(enabled = true, priority=2)
	public void addNewCustomerWithNameOnly() {
		tpo.sendCustomerName(); // will call method to send random customer name.
		wait(tpo.saveButton);
		click(tpo.saveButton);
		asserts(tpo.newCustomerTable);
	}
	@Test(enabled = true, priority=3)
	public void addNewCustomerNoNameDescription() {
        wait(tpo.saveButton);
		click(tpo.saveButton);
		asserts(tpo.errorMsg,"errorMsg");
	}
	@AfterMethod
	public void logoutFunctionality() {
		waitElementDisplayed(cpo.userDropdownMenu);
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
