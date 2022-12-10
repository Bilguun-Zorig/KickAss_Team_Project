package projectTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonMethods;
import utilities.ListenerAnalyzer;

@Listeners(ListenerAnalyzer.class)
public class TimeTest_Mildred extends CommonMethods {

	@BeforeMethod(enabled = true)
	public void loginFunctionality() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
	}
	@Test(enabled = true)
	public void addNewCustomerwithNameandDescription() {
		selection(cpo.leftSideMenuBar, "time");
		selection(tpo.getTopBarMenu(), "pi");
		wait(tpo.customersBox);
		click(tpo.customersBox);
		wait(tpo.addCustomer);
		click(tpo.addCustomer);
		tpo.sendCustomerName(); // will call method to send random customer name.
		wait(tpo.addDescriptionBox);
		tpo.addDescriptionBox.sendKeys(tpo.timeDescription);
		click(tpo.saveButton);
		threadSleep(5);
	}
	@Test(enabled = true)
	public void addNewCustomerWithNameOnly() {
		selection(cpo.leftSideMenuBar, "time");
		selection(tpo.getTopBarMenu(), "pi");
		wait(tpo.customersBox);
		click(tpo.customersBox);
		wait(tpo.addCustomer);
		click(tpo.addCustomer);
		tpo.sendCustomerName(); // will call method to send random customer name.
		wait(tpo.saveButton);
		click(tpo.saveButton);
		System.out.println("end addNew2");
	}
	@Test(enabled = true)
	public void addNewCustomerNoNameDescription() {
		selection(cpo.leftSideMenuBar, "time");
		selection(tpo.getTopBarMenu(), "pi");
		wait(tpo.customersBox);
		click(tpo.customersBox);
		wait(tpo.addCustomer);
		click(tpo.addCustomer);
		wait(tpo.saveButton);
		click(tpo.saveButton);
	}
	@AfterMethod
	public void logoutFunctionality() {
		waitElementDisplayed(cpo.userDropdownMenu);
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
