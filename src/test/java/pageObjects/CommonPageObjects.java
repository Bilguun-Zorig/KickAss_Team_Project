package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class CommonPageObjects {
	
	public CommonPageObjects() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	@FindBy (xpath = "//*[@class='oxd-userdropdown']")
	public WebElement userDropdownMenu;
	
	@FindBy (xpath = "//*[@class='oxd-dropdown-menu']/li/a")
	public List<WebElement> userDropdownMenuItems;
}
