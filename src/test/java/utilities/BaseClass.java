package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static WebDriver driver;
	private static Properties configSetUp;
	private static Properties configAppText;
	private static Properties configLogin;
	
	@BeforeClass
	public static WebDriver getDriver() {
		if (driver == null) {
			switch (BaseClass.getSetUp("browser")) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "chrome-headless":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "firefox-headless":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
				break;
			case "edge":
				if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
					throw new WebDriverException("Your OS does not support edge");
				}
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}
			driver.get(BaseClass.getSetUp("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.Implicit_Wait_Time, TimeUnit.SECONDS);
			PageInitializer.initializer();
		}
		return driver;
	}
	
	@AfterClass (enabled = true)
	public static void tearDown() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	static {
		try {
			String setUpPath = Constants.Configuration_SetUp;
			FileInputStream setUpInput = new FileInputStream(setUpPath);
			configSetUp = new Properties();
			configSetUp.load(setUpInput);
			setUpInput.close();
			
			String appTextPath = Constants.Configuration_AppText;
			FileInputStream appTextInput = new FileInputStream(appTextPath);
			configAppText = new Properties();
			configAppText.load(appTextInput);
			appTextInput.close();
			
			String loginPath = Constants.Configuration_Login;
			FileInputStream loginInput = new FileInputStream(loginPath);
			configLogin = new Properties();
			configLogin.load(loginInput);
			loginInput.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getSetUp(String keyName) {
		return configSetUp.getProperty(keyName);
	}
	public static String getAppText(String keyName) {
		return configAppText.getProperty(keyName);
	}
	public static String getLogin(String keyName) {
		return configLogin.getProperty(keyName);
	}
}
