package projectTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.CommonMethods;

public class Recruitment_Page_Test_Tey extends CommonMethods {

	@BeforeMethod
	public void loginRecruitmentPage() {
		sendLoginValues(hpo.usernameTextbox, "username", hpo.passwordTextbox, "password");
		click(hpo.loginButton);
		asserts(rpo.headerText, "db");
		selection(cpo.leftSideMenuBar, "recruitment");
		asserts(rpo.headerText, "recruitment");
	}
	@Test(enabled = true, priority = 1)
	public void addCandidate() {
		asserts(rpo.addCandidateButton);// check add button then click
		click(rpo.addCandidateButton);
		asserts(rpo.addCandidateHeaderForm);// check add candidate form
		rpo.candidateDetails(); // add information
		click(rpo.saveAddForm);
		asserts(rpo.candidateButton);// check candidate button then click
		click(rpo.candidateButton);
	}
	@Test(enabled = true, priority = 2)
	public void rejectCandidate() {
		asserts(rpo.actionButton);
		click(rpo.actionButton);
		asserts(rpo.rejectButton);
		click(rpo.rejectButton);
		asserts(rpo.saveAddForm);
		click(rpo.saveAddForm);
		asserts(rpo.candidateButton);
		click(rpo.candidateButton);
	}
	@Test(enabled = true, priority = 3)
	public void deleteCandidate() {
		asserts(rpo.deleteButton);
		click(rpo.deleteButton);
		
		rpo.confirmDeleteAlert();
		String parentWindowHandler = BaseClass.getDriver().getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
		asserts(rpo.deleteButton);
		click(rpo.deleteButton);
		Set<String> handles = BaseClass.getDriver().getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		subWindowHandler = iterator.next();
		BaseClass.getDriver().switchTo().window(subWindowHandler); // switch to popup window
		click(rpo.comfirmDelete);
		BaseClass.getDriver().switchTo().window(parentWindowHandler); // switch back to parent window
	}
	@AfterMethod(enabled = true)
	public void logout() {
		click(cpo.userDropdownMenu);
		selection(cpo.userDropdownMenuItems, "logout");
	}
}
