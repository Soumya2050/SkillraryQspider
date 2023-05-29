package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class SkillraryDemoApp {
	
	//Declaration
	@FindBy(xpath = "//div[@class='navbar-header']")
	private WebElement pageHeader;
	
	@FindBy(id = "course")
	private WebElement courseTab;
	
	@FindBy(xpath = "//span/a[text()='Selenium Training']")
	private WebElement SeleniumTraining;
	
	@FindBy(name = "addresstype")
	private WebElement catagoryDropdown;
	
	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement contactUs;
	
	//intialization
	
	public SkillraryDemoApp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	/**
	 * This method return page Header text
	 * @return
	 */
	public String PageHeader() {
		return pageHeader.getText();
	}
	/**
	 * This method is used to mouse hover to course tab
	 * @param web
	 */
	public void MouseHoverToCourse(WebDriverUtility web) {
		web.mouseHover(courseTab);
	}
	/**
	 * This metho is used to click selenium tarining 
	 */
	public void clickSeleniumTraining() {
		SeleniumTraining.click();
	}
	/**
	 * This method is used to chose the catagory from dropdown
	 * @param web
	 * @param index
	 */
	public void SelectCatagory(WebDriverUtility web,int index) {
		web.dropdown(catagoryDropdown, index);
	}
	/**
	 * This method will return contactus link
	 * @return
	 */
	public WebElement getContactUs() {
		return contactUs;
	}
	/**
	 * This methid is used to click contactus link
	 */
	public void clickContactUs() {
		contactUs.click();
	}
}
