package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class DirectoryPage {

	public DirectoryPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	CommonMethods cm = new CommonMethods();

	@FindBy(xpath = "//*[contains(@class,'oxd-text oxd-text--h6')]")
	public WebElement pageHeader;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	public WebElement employeeName;

	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	public WebElement searchName;

	@FindBy(xpath = "//div[@class='oxd-form-actions']/button[2]")
	public WebElement searchButton;

	
	@FindBy(xpath = "//*[@class='oxd-grid-3']/div[2]/div/div[2]/div/div/div[1]")
	public WebElement jobTitle;

	@FindBy(xpath = "//*[@class='oxd-grid-3']/div[3]/div/div[2]/div/div/div[1]")
	public WebElement locationFiled;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div")
	public List<WebElement> employeeNameList;

	public void selectSearchDropdown(List<WebElement> dropdownList, String name) {
		cm.threadSleep(3);
		for (WebElement ea : dropdownList) {
			System.out.println(ea.getText());
			if (ea.getText().toLowerCase().contains(name.toLowerCase())) {
				cm.highLightElementMethod(ea);
				ea.click();
				break;
			}
		}
	}

	public String getAdminFirstName(WebElement element) {
		return element.getText().substring(0, element.getText().indexOf(" "));
	}

	public void selectJob(int index) {
		for (int i = 1; i <= index; i++) {
			jobTitle.sendKeys(Keys.ARROW_DOWN);
		}
		jobTitle.sendKeys(Keys.ENTER);
	}

	public void selectLocation(int index) {
		for (int i = 1; i <= index; i++) {
			locationFiled.sendKeys(Keys.ARROW_DOWN);
		}
		locationFiled.sendKeys(Keys.ENTER);
	}

}