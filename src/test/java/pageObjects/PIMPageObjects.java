package pageObjects;

import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class PIMPageObjects {

	public PIMPageObjects() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	CommonMethods cm = new CommonMethods();
	public String value;
	private String firstName = CommonMethods.fake.name().firstName();
	private String lastName = CommonMethods.fake.name().lastName();
	private String driverLicenseVA = CommonMethods.faker.bothify("???-####");
	private String ssn = CommonMethods.faker.bothify("###-##-####");

	@FindBy(xpath = "//*[@aria-label='Topbar Menu']/ul/li")
	private List<WebElement> topBarMenu;
	@FindBy(xpath = "//*[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement addEmployeeTitle;
	@FindBy(name = "firstName")
	private WebElement firstNameInputField;
	@FindBy(name = "lastName")
	private WebElement lastNameInputField;
	@FindBy(xpath = "//button[contains(@class,'medium oxd')]")
	private List<WebElement> cancelSaveButton;
	@FindBy(xpath = "//*[@class='orangehrm-edit-employee']/div[2]/div[1]/h6")
	private WebElement personalDetails;
	@FindBy(xpath = "//*[@id='app']//div[2]/div[1]/form/div[2]/div[2]//div[2]/input")
	private WebElement driverLicenseTextBox;
	@FindBy(xpath = "//*[@id='app']//form/div[2]//div/div[1]/i")
	private WebElement calendarLicenseExpire;
	@FindBy(xpath = "//*[@class='oxd-calendar-selector-month-selected']")
	private WebElement monthsClickMenu; // might not work
	@FindBy(xpath = "//*[@class='oxd-calendar-dropdown']/li")
	private List<WebElement> calendarDropdown; // use it for months and years
	@FindBy(xpath = "//*[@class='oxd-calendar-selector-year-selected']")
	private WebElement yearsClickMenu;
	@FindBy(xpath = "//*[@class='oxd-calendar-dates-grid']/div/div")
	private List<WebElement> daysTable;
	@FindBy(xpath = "//*[@id='app']//div[3]//div[1]/div/div[2]/div/div/div[2]")
	private WebElement nationalityButton;
	@FindBy(xpath = "//*[contains(@class,'--positon-bottom')]/div")
	private List<WebElement> nationalitiesList;
	@FindBy(xpath = "//*[@class='oxd-input oxd-input--focus']")
	private WebElement ssnInputField;
	@FindBy(xpath = "//*[@id='app']//form/div[3]/div[1]/div[2]//div[2]/div/div")
	private WebElement maritalStatus;
	@FindBy(xpath = "//*[@id='app']//form/div[3]/div[2]//div/div/input")
	private WebElement dateOfBirth;
	@FindBy(xpath = "//*[@class='--gender-grouped-field']//label")
	private List<WebElement> genderSelection;
	@FindBy(xpath = "//*[@id='app']//form/div[4]/div[1]//div[2]/input")
	private WebElement militaryService;
	@FindBy(xpath = "//*[@id='app']//div[2]/div[2]/div/form//div[2]/div/div")
	private WebElement bloodType;
	@FindBy(xpath = "//*[@id='app']//div[2]/button")
	private WebElement savePDButton;
	@FindBy(xpath = "//*[@id='app']//div[5]/button")
	private WebElement saveCFButton;
	@FindBy(xpath = "//*[@class='oxd-table-body']//div[2]")
	private List<WebElement> employeeIDList;
	@FindBy(xpath = "//*[@id='app']//div[2]/div[1]/div[1]/div/div[2]/input")
	public WebElement employeeID;
	@FindBy(xpath = "//h6[contains(@class,'header-breadcrumb')]")
	private WebElement pimPageText;
	@FindBy(xpath = "//h5[contains(@class,'filter-title')]")
	private WebElement employeeInfoText;
	@FindBy(xpath = "//*[contains(@class,'bottom-space')]")
	private List<WebElement> employeeInfoList;
	@FindBy(xpath = "//*[@class='oxd-table-body']//div[5]")
	private List<WebElement> jobTitleList;
	@FindBy(xpath = "//*[contains(@class,'h5 oxd')]")
	private WebElement employeeReportText;
	@FindBy(xpath = "//*[@id='app']//div[3]//div[2]/button")
	private WebElement plusButton;
	@FindBy(xpath = "//*[contains(@placeholder,'Type here ...')]")
	private WebElement reportNameInputField;
	@FindBy(xpath = "//*[contains(@class,'chips-area')]/span")
	private List<WebElement> listOfItems;
	@FindBy(xpath = "//*[contains(@class,'chips-area')]/span[6]/i")
	private WebElement removeItemButton;
	@FindBy (xpath = "//h6[contains(@class,'main-title')]")
	private WebElement reportNameDisplayed;

	public List<WebElement> getTopBarMenu() {
		return topBarMenu;
	}
	public WebElement getAddEmployeeTitle() {
		return addEmployeeTitle;
	}
	public WebElement getFirstNameInputField() {
		return firstNameInputField;
	}
	public WebElement getLastNameInputField() {
		return lastNameInputField;
	}
	public List<WebElement> getCancelSaveButton() {
		return cancelSaveButton;
	}
	public WebElement getPersonalDetails() {
		return personalDetails;
	}
	public WebElement getDriverLicenseTextBox() {
		return driverLicenseTextBox;
	}
	public WebElement getCalendarLicenseExpire() {
		return calendarLicenseExpire;
	}
	public WebElement getMonthsClickMenu() {
		return monthsClickMenu;
	}
	public List<WebElement> getCalendarDropdown() {
		return calendarDropdown;
	}
	public WebElement getYearsClickMenu() {
		return yearsClickMenu;
	}
	public List<WebElement> getdaysTable() {
		return daysTable;
	}
	public WebElement getNationalityButton() {
		return nationalityButton;
	}
	public List<WebElement> getNationalitiesList() {
		return nationalitiesList;
	}
	public WebElement getSsnInputField() {
		return ssnInputField;
	}
	public WebElement getMaritalStatus() {
		return maritalStatus;
	}
	public WebElement getDateOfBirth() {
		return dateOfBirth;
	}
	public List<WebElement> getGenderSelection() {
		return genderSelection;
	}
	public WebElement getMilitaryService() {
		return militaryService;
	}
	public WebElement getSavePDButton() {
		return savePDButton;
	}
	public WebElement getBloodType() {
		return bloodType;
	}
	public WebElement getSaveCFButton() {
		return saveCFButton;
	}
	public List<WebElement> getEmployeeIDList() {
		return employeeIDList;
	}
	public WebElement getPimPageText() {
		return pimPageText;
	}
	public WebElement getEmployeeInfoText() {
		return employeeInfoText;
	}
	public List<WebElement> getEmployeeInfoList() {
		return employeeInfoList;
	}
	public List<WebElement> getJobTitleList() {
		return jobTitleList;
	}
	public WebElement getEmployeeReportText() {
		return employeeReportText;
	}
	public WebElement getPlusButton() {
		return plusButton;
	}
	public WebElement getReportNameInputField() {
		return reportNameInputField;
	}
	public List<WebElement> getListOfItems() {
		return listOfItems;
	}
	public WebElement getRemoveItemButton() {
		return removeItemButton;
	}
	public WebElement getReportName() {
		return reportNameDisplayed;
	}

	// Specific method for the page only

	// This method sends Full Name to the login boxes
	public void sendFirstLastName() {
		cm.highLightElementMethod(getFirstNameInputField());
		getFirstNameInputField().sendKeys(firstName);
		cm.highLightElementMethod(getLastNameInputField());
		getLastNameInputField().sendKeys(lastName);
	}
	// it will format date generated by java.faker
	public String formatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String dOB = sdf.format(CommonMethods.fake.date().birthday());
		return dOB;
	}
	// this method select DMY drop down calendar
	public void selectDateMonthYear(String month, String year, String day) {
		cm.scrollUp();
		getCalendarLicenseExpire().click();
		cm.threadSleep(3);
		getMonthsClickMenu().click();
		cm.selection(calendarDropdown, month);
		cm.threadSleep(3);
		getYearsClickMenu().click();
		cm.threadSleep(3);
		cm.selection(calendarDropdown, year);
		cm.selection(daysTable, day);
		cm.threadSleep(2);
	}
	// This method fills out a personal info form
	public void fillPersonalDetails() {
		value = employeeID.getAttribute("value");
		getDriverLicenseTextBox().sendKeys(driverLicenseVA);
		getSsnInputField().sendKeys(ssn);
		selectDateMonthYear("month", "year", "day");
		cm.scrollUp();
		cm.click(getNationalityButton());
		cm.selection(getNationalitiesList(), "nationality");
		cm.click(getMaritalStatus());
		cm.selection(getNationalitiesList(), "maritalStatus");
		cm.scrollDown();
		getDateOfBirth().sendKeys(formatDate());
		cm.selection(getGenderSelection(), "gender");
		getMilitaryService().sendKeys("No");
		getSavePDButton().click();
		cm.click(getBloodType());
		cm.selection(getNationalitiesList(), "bType");
		getSaveCFButton().click();
	}
	//This method will loop through list and select the matching element and remove it
	public void selection(List<WebElement> elements, String select, WebElement button) {
		for (WebElement element : elements) {
			if (element.getText().trim().equalsIgnoreCase(BaseClass.getAppText(select).trim())) {
				cm.click(button);
				break;
			}
		}
	}
}
