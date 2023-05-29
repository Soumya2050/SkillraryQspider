package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.Contactuspage;
import pomPages.HomePage;
import pomPages.SeleniumTrainingPage;
import pomPages.SkillraryDemoApp;
import pomPages.Testingpage;

public class BaseClass {
	
	protected PropertiesFileUtilityClass property;
	protected ExcelFileUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SeleniumTrainingPage selenium;
	protected SkillraryDemoApp demoapp;
	protected Testingpage test;
	protected Contactuspage contactus;
//	@BeforeSuite
//	@BeforeTest
	
	@BeforeClass
	public void classCofig() {
		property = new PropertiesFileUtilityClass();
		excel = new ExcelFileUtility();
		jutil = new JavaUtility();
		web = new WebDriverUtility();
		
		property.PropertyConfig(IconstantPath.Properties_Path);
		excel.ExcelIntialization(IconstantPath.Excel_Path);
	}
	@BeforeMethod
	public void methodConfig() {
		driver = web.OpenApplication(property.FetchProperty("browser"));
		web.maximizeBrowser();
		web.navigateToApp(property.FetchProperty("url"));
		web.waitUntilElementIsFound(Long.parseLong(property.FetchProperty("time")));
		
		home=new HomePage(driver);
		selenium = new SeleniumTrainingPage(driver);
		demoapp = new SkillraryDemoApp(driver);
		test = new Testingpage(driver);
		contactus = new Contactuspage(driver);
	
				
	}
	@AfterMethod
	public void methodTearDown() {
		web.quiteBrowser();
	}
	@AfterClass
	public void classTearDown() {
		excel.closeWorkbook();
	}
//	@AfterTest
//	@AfterSuite
	
}
