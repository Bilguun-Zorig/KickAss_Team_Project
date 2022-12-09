package pageObjects;


import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import utilities.Assertions;
import utilities.BaseClass;
import utilities.CommonMethods;

public class LeavePageObjects {
	
	CommonMethods cm = new CommonMethods();
	Assertions as = new Assertions();
	
	public LeavePageObjects() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "(//nav[@role='navigation'])[2]/ul/li")
	public List<WebElement> leaveMenuBar;
	
	@FindBy(xpath = "(//ul[@class='oxd-dropdown-menu']/li)[1]")
	public WebElement usageReport;
	
	@FindBy(xpath = "//h6[text()='Leave']")
	public WebElement leavePageText;
	
	@FindBy(xpath = "//div[@class='oxd-table-filter-header-title']")
	public WebElement usageReportText;
	
	@FindBy(xpath = "(//span[contains(@class,'radio-input')])[1]")
	public WebElement leaveTypeCheck;	
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")  
	public WebElement typeBox;		
	
	@FindBy(xpath = "//*[contains(@class,'oxd-select-dropdown --positon-bottom')]/div")
	public List<WebElement> dropdownList;	
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	public WebElement periodBox;
	
	@FindBy(xpath = "//*[contains(@class,'oxd-switch-input')]")
	public WebElement pastEmployeeSwitchButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement generateButton;
	
	@FindBy(xpath = "//span[contains(@class,'oxd-text--count')]")
	public WebElement recordFoundText;
	
	@FindBy(xpath = "//i[contains(@class,'bi-arrows-fullscreen')]")
	public WebElement fullScreen;
	
	@FindBy(xpath = "//i[contains(@class,'bi-fullscreen-exit')]")
	public WebElement exitScreen;	
	
//----------------------------------------------------------------------------	
	@FindBy(xpath = "//h6[contains(@class,'orangehrm-main-title')]")
	public WebElement assignLeaveText;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	public WebElement adminName;
	
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	public WebElement searchName;
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div")
	public List<WebElement> searchNameList;
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	public WebElement leaveType;
	
	@FindBy(xpath = "(//div[@class='oxd-date-input']/input)[1]")
	public WebElement fromDate;
	
	@FindBy(xpath = "(//div[@class='oxd-date-input']/input)[2]")
	public WebElement toDate;
	
	@FindBy(xpath = "(//span[contains(@class,'input-field-error-message')])[2]")
	public WebElement dateErrorText;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active oxd-input--error'])[1]")
	public WebElement dateErrorBox;
	
	@FindBy(xpath = "(//div[contains(@class,'oxd-select-text--active')])[2]")
	public WebElement durationEle;
	
	@FindBy(xpath = "//div[@class='oxd-layout']")
	public WebElement clickAnywhere;
	
	@FindBy(xpath = "//div[@class='oxd-input-group']/div[2]/p")
	public WebElement dayBalance;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='orangehrm-modal-footer']/button[2]")
	public WebElement popUpBoxOkButton;	
	
	@FindBy(xpath = "//div[@id='oxd-toaster_1']")
	public WebElement popupBox;
	
	
	
	
	
	
	
//**to select option from dropdown menu 
	public void selectOptionDropdown(WebElement dropdownBox, List<WebElement> dropdownList,String option){
		dropdownBox.click();
		cm.highLightElementMethod(dropdownBox);
		cm.threadSleep(3);
		cm.selection(dropdownList, option);
	}

//**to select option from search result	
	public void selectSearchDropdown(List<WebElement> dropdownList, String name){				
		cm.threadSleep(3);
		for (WebElement ea : dropdownList) {
			System.out.println(ea.getText());
			if(ea.getText().toLowerCase().contains(name.toLowerCase())) {
				cm.highLightElementMethod(ea);
				ea.click();
				break;
			}			
		}		
	}

//**to remove the first word(often dynamic) from the text	
	public String trimText(WebElement element) {
		return element.getText().substring(element.getText().indexOf(" ")).trim();
	}

//Note: We need just firstName for search box, in case of hidden Admin middle name.	
	public String getAdminFirstName(WebElement element) {
		return element.getText().substring(0, element.getText().indexOf(" "));
	}
	
//**to fill From-To Dates (for LeavePage use **ONLY**)
	public void fillFromToDates(String fromDateStr, String toDateStr, String durationStr) {
		fromDate.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		cm.sendTextByConfigText(fromDate, fromDateStr);
		toDate.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		cm.sendTextByConfigText(toDate, toDateStr);
		dayBalance.click();		
		cm.wait(durationEle);
		selectOptionDropdown(durationEle, dropdownList, durationStr);
	}	

//**compare two Strings
	public void AssertsTwoStrings(String actual, String expected) {
		Assert.assertEquals(actual,BaseClass.getAppText(expected));
	}

//**to check if popUp box displayed	(for LeavePage use **ONLY**)
	public void AssertDayBalance(WebElement element) {		
		if(element.getText().contains("0.00") || element.getText().contains("not sufficient")) {		
			cm.highLightElementMethod(element);
			cm.wait(popUpBoxOkButton);
			as.asserts(popUpBoxOkButton); //displayed
			cm.click(popUpBoxOkButton);
			cm.wait(popupBox);
			cm.highLightElementMethod(popupBox);	
			as.asserts(popupBox);
			//AssertPopupText(popupBox,"dynamicPopupTexts");
		}else {
			cm.wait(popupBox);
			cm.highLightElementMethod(popupBox);	
			as.asserts(popupBox);			
		}
	}	

//**dynamic popUptext with multiple lines of String in one element	
	public void AssertPopupText(WebElement actual,String expected) {
		cm.wait(actual);
		cm.highLightElementMethod(actual);	
		String[] lines = actual.getText().split("\n");
		System.out.println("line of text: "+lines.length);
		for(int i=0; i<lines.length;i++) {
			System.out.println(lines[i]);
		}
		String keyMsg = null;
		if(lines.length>1) {
			keyMsg = lines[1];
		}else {
			keyMsg = lines[0];
		}		
		AssertsTwoStrings(keyMsg, expected);
	}

	

}











