package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePageObjects {
	public HomePageObjects() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	@FindBy (xpath = "//*[@name='username']")
	public WebElement usernameTextbox;
	
	@FindBy (xpath = "//*[@name='password']")
	public WebElement passwordTextbox;
	
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement loginButton;
}
