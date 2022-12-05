package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class KPIPerformancePageObjects {
	
	public KPIPerformancePageObjects() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy (xpath = "//*[contains(@class,'oxd-text oxd-text--h6')]")
	public WebElement pageHeader;
	@FindBy (xpath  = "//*[contains(@class, 'oxd-topbar-body-nav-tab')]")
	public List<WebElement> topMenu;
	@FindBy (xpath = "//*[@class='oxd-topbar-body-nav-tab-link']")
	public List<WebElement> dropdownMenu;
	@FindBy (xpath = "//*[@class='oxd-icon bi-plus oxd-button-icon']")
	public WebElement addButton;
	@FindBy (xpath = "//*[@class='oxd-text oxd-text--p orangehrm-main-title']")
	public WebElement subHeader;
	@FindBy (xpath = "//*[@class='oxd-form']/div[1]/div/div[1]/div/div[2]/input")
	public WebElement keyInputBox;
	@FindBy (xpath = "//*[@class='oxd-form']/div[2]/div/div[1]/div/div[2]/input")
	public WebElement minRateBox;
	@FindBy (xpath = "//*[@class='oxd-form']/div[3]/div/div[1]/div/div[2]/input")
	public WebElement maxRateBox;
	@FindBy (xpath = "//*[@class='oxd-form']/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
	public WebElement jobTitleBox;
	@FindBy (xpath = "//*[contains(@class,'oxd-button oxd-button--medium oxd-button--secondary')]")
	public WebElement saveButton;
	@FindBy (xpath = "//*[@class='oxd-form']/div[1]/div/div[2]/div/div[2]/div/div[2]")
	public WebElement jobDropdown;
	
	public void clickDownKey() {
		jobTitleBox.sendKeys(Keys.ARROW_DOWN);
	}

	public void clickEnterKey() {
		jobTitleBox.sendKeys(Keys.ENTER);
	}
	

}
