package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class RecruitmentPageObjects {

	public RecruitmentPageObjects() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	CommonMethods cm = new CommonMethods();

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")
	public WebElement recruitmentLeftMenu;
	@FindBy(xpath = "//h6[contains(@class,'header-breadcrumb')]")
	public WebElement headerText;
	@FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	public WebElement addCandidateButton;
	@FindBy(xpath = "//*[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	public WebElement addCandidateHeaderForm;
	@FindBy(name = "firstName")
	public WebElement firstNameInputBox;
	@FindBy(name = "lastName")
	public WebElement lastNameInputBox;
	@FindBy(xpath = "//*[@class='oxd-select-text-input']")
	public WebElement vacancy;
	@FindBy(xpath = "//*[@class='oxd-select-dropdown --positon-bottom']")
	public List<WebElement> vacancySelection;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
	public WebElement emailInputBox;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")
	public WebElement numberInputBox;
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement saveAddForm;
	@FindBy(xpath = "//*[@class='oxd-topbar-body-nav-tab-item']")
	public WebElement candidateButton;
	@FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--danger']")
	public WebElement rejectButton;
	@FindBy(xpath = "//*[@class='oxd-icon bi-eye-fill']")
	public WebElement actionButton;
	@FindBy(xpath = "//*[@class='")
	public WebElement saveReject;
	@FindBy(xpath = "//*[@class='oxd-icon bi-trash']")
	public WebElement deleteButton;
	@FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	public WebElement comfirmDelete;

	public void sev(List<WebElement> ele, String eleTxt) {
		for (WebElement element : ele) {
			if (element.getText().trim().equalsIgnoreCase(BaseClass.getAppText(eleTxt).trim()))
				;
			cm.highLightElementMethod(element);
			element.click();
			break;
		}
	}

	public void candidateDetails() {

		cm.sendTextByConfigText(firstNameInputBox, "firstname");
		cm.sendTextByConfigText(lastNameInputBox, "lastname");
		cm.click(vacancy);
		sev(vacancySelection, "vacancy");
		cm.sendTextByConfigText(emailInputBox, "email");
		cm.sendTextByConfigText(numberInputBox, "number");

	}
}
