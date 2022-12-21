
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
	@FindBy (xpath = "//*[@class='oxd-form']/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
	public WebElement jobTitleBox;
	@FindBy (xpath = "//*[contains(@class,'oxd-button oxd-button--medium oxd-button--secondary')]")
	public WebElement saveButton;
	@FindBy (xpath = "//*[@class='oxd-form']/div[1]/div/div[2]/div/div[2]/div/div[2]")
	public WebElement jobDropdown;
	@FindBy (xpath = "//*[@class='orangehrm-paper-container']/div[3]/div/div[2]/div/div/div[2]/div")
	public List<WebElement> listOfKpi;
	@FindBy (xpath = "//*[@class='orangehrm-paper-container']/div[2]/div/div/button")
	public WebElement deleteButton;
	@FindBy (xpath = "//*[contains(@class,'oxd-sheet')]/div[3]/button[2]")
	public WebElement yesDeleteButton;
	
	public void clickEditButton(List<WebElement> listOfKpi, String pkiname) {
		int counter = 1;
		for(WebElement kpi : listOfKpi) {
			if(kpi.getText().trim().equalsIgnoreCase(BaseClass.getAppText(pkiname).trim())) {
				BaseClass.getDriver().findElement(By.xpath("//*[@class='orangehrm-paper-container']"
						+ "/div[3]/div/div[2]/div["+counter+"]/div/div[7]/div/button[1]/i")).click();
				keyInputBox.click();
				for(int i=1; i<50; i++) {
					keyInputBox.sendKeys(Keys.BACK_SPACE);
				}
				break;
			}
			counter ++;
		}
	}
	
	public void selectKPI(List<WebElement> listOfKpi, String pkiname) {
		int counter = 1;
		for(WebElement kpi : listOfKpi) {
			if(kpi.getText().trim().equalsIgnoreCase(BaseClass.getAppText(pkiname).trim())) {
				BaseClass.getDriver().findElement(By.xpath("//*[@class='oxd-table-body']"
						+ "/div["+counter+"]/div/div/div/div/label/span/i")).click();
				break;
			}
			counter ++;
		}
	}
	
	public String lastKpi() {
		String last = "";
		for(WebElement kpi : listOfKpi) {
			last = kpi.getText();
		}
		return last;
	}

}
