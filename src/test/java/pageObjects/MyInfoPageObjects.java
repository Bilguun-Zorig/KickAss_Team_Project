package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class MyInfoPageObjects {
	public MyInfoPageObjects() {
		PageFactory.initElements(BaseClass.getDriver(), this);	
	
	}
	public String fullName = CommonMethods.fake.name().fullName();
	public String relationship = CommonMethods.fake.relationships().any();
	public String homePhone = CommonMethods.fake.bothify("##########");
	public String cellPhone = CommonMethods.fake.bothify("##########");
	public String newCellPhone = CommonMethods.fake.bothify("##########");
	public String workPhone = CommonMethods.faker.bothify("##########");
	CommonMethods cm = new CommonMethods();

	@FindBy(xpath = "//*[@class ='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	public WebElement hompageHead;
	
	@FindBy(xpath = "//*[@class='orangehrm-tabs']/div")
	public List<WebElement> myInfoSideBar;
	
	@FindBy(xpath = "//*[@class='orangehrm-edit-employee-content']/div/div/h6")
	public WebElement emergencyContactHead ;
	
	@FindBy(xpath = "//*[@class='orangehrm-edit-employee-content']/div[1]/div/button")
	public WebElement addContact;
	
	@FindBy(xpath = "//*[@class ='orangehrm-horizontal-padding orangehrm-vertical-padding']/h6")
    public WebElement addEmergencyHead;
	
    @FindBy (xpath = "//*[contains(@class,'field-bottom-space')]/div[2]/input")
	public List<WebElement> inputFields;
    
    @FindBy(xpath = "//*[@class ='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;
    
    @FindBy(xpath = "//*[@class ='oxd-icon bi-pencil-fill']")
    public WebElement editIcon;
    
    @FindBy(xpath = "//*[@class ='orangehrm-horizontal-padding orangehrm-vertical-padding']/h6")
    public WebElement editEmergencyContactHead;
    
	@FindBy(xpath = "//*[@class = 'oxd-grid-item oxd-grid-item--gutters']")
    public List<WebElement>editFields;
	
	@FindBy(xpath = "//*[@class = 'oxd-icon bi-trash']")
	public WebElement deleteIcon;
	
	@FindBy(xpath ="//*[@class ='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	public WebElement deletebutton;
	
	@FindBy(xpath = "//*[@class ='oxd-table-card']/div/div[2]/div")
	public List<WebElement> recordedName;
	
	@FindBy(xpath = "//*[@class ='oxd-table-card']/div/div[5]/div")
	public List<WebElement> recordedMobile;
	
	
	
    public void addEmergencyContact () {
    	
		inputFields.get(0).sendKeys(fullName);
		inputFields.get(1).sendKeys(relationship);
		inputFields.get(2).sendKeys(homePhone);
		inputFields.get(3).sendKeys(cellPhone);
		inputFields.get(4).sendKeys(workPhone);
    }
    

    public void editSelection () {
		
				inputFields.get(3).click();
				cm.threadSleep(2);
				for (int i = 1; i <= 10;i++) { 
					inputFields.get(3).sendKeys(Keys.BACK_SPACE);
				}
				inputFields.get(3).sendKeys(newCellPhone);
				cm.threadSleep(3);
				
    
			}
    public boolean checkRecord(List <WebElement> elements, String value) {
    	boolean isRecordSave = false;
		for(WebElement element : elements) {
			System.out.println(element.getText());
			if(element.getText().equals(value)) {
				isRecordSave = true;
			}
		}
		return isRecordSave;
		
	}
			
}
    



