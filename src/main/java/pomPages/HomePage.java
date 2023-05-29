package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	@FindBy(xpath = "//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath = "//a[text()=' GEARS ']")
	private WebElement gearsTab;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillrarydemoapp;
	
	@FindBy(xpath = "//input[@placeholder='Search for Courses']")
	private WebElement searchTf;
	
	@FindBy(xpath = "//input[@value='go']")
	private WebElement searchbutton;
	
	//intialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	/**
	 * This method return skillrary logo
	 * @return
	 */
	public WebElement getlogo() {
		return logo;
	}
	/**
	 * This method is used to click gear tab
	 */
	public void clickgearTab() {
		gearsTab.click();
	}
	/**
	 * This method is used to click skillrarydemoapp
	 */
	public void clickSkillraryApp() {
		skillrarydemoapp.click();
	}
	/**
	 * This method is used enter the data in search tf and click on search
	 * @param data
	 */
	public void SearchFor(String data) {
		searchTf.sendKeys(data);
		searchbutton.click();
	}
}
