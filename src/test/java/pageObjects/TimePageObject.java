package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class TimePageObject {
	
	public TimePageObject() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	CommonMethods cm = new CommonMethods();
	
	public String value; 
	public String timeDescription= "This is description.";
	
	
	public String customerName = CommonMethods.fake.name().firstName(); // will create random name each time test runs.
//	public String descriptionBox = CommonMethods.fake.pokemon().name();
	
	@FindBy(xpath = "//*[@aria-label='Topbar Menu']/ul/li")
	private List<WebElement> timeTopBarMenu;
	
	@FindBy(xpath = "//a[@role='menuitem' and text()='Customers']")
	public WebElement customersBox;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	public WebElement addCustomer;
	
	@FindBy (css ="div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
	public WebElement addNameTextBox;
	
	@FindBy (xpath= "//textarea[@placeholder='Type description here'] ")
	public WebElement addDescriptionBox;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement saveButton;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	public WebElement successfullySaved;
	
	@FindBy(xpath= "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	public WebElement timeText;
	
	@FindBy(xpath="//div[@class='orangehrm-container']")
	public WebElement newCustomerTable;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	public WebElement errorMsg;
	
	public List<WebElement> getTopBarMenu() {
		return timeTopBarMenu;
	}
	
	
	public void sendCustomerName() { 
		cm.highLightElementMethod(addNameTextBox);
		addNameTextBox.sendKeys(customerName);
		
	}
	



}
