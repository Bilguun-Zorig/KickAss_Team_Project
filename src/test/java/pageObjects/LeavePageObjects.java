package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.BaseClass;

public class LeavePageObjects {
	
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
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")  //flex --'active' <=> 'focus'
	public WebElement typeBox;		
	
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
	
	
	
//**to select option from dropdown menu	
	public void selectOptionDropdown(String option) {
		BaseClass.getDriver().findElement(By.xpath("//div[.='" + option + "']")).click();		
	}

//**to remove the first word(often dynamic) from the text	
	public String trimText(WebElement element) {
		return element.getText().substring(element.getText().indexOf(" ")).trim();
	}

//**compare two Strings
	public void asserts(String actual, String expected) {
		Assert.assertEquals(actual,BaseClass.getAppText(expected));
	}

}











