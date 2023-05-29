package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testingpage {
	

	/*
	 * this class contains elements and their respective business libraries of testing page 
	 */

//declaration
	
	@FindBy(xpath="//header[@class=\"main-header\"]")
	private WebElement header;
	
	@FindBy(id="Python")
	private WebElement pythonimage;
	
	@FindBy(id = "cartArea")
	private WebElement cartarea;
	
	@FindBy(xpath ="//ul[@class='list-socialicons']/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookicon;
	
	
//initialization
	
	public Testingpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//utilization
	public String getpageheader() {
		/*
		 * this method is used to returns page header
		 */
		return header.getText();
	}
	
	public WebElement getPythonImage() {
		/*
		 * this method returns python image 
		 */
		return pythonimage;
	}
	
	public WebElement getCartArea() {
		/*
		 * this method returns cart area element
		 */
		return cartarea;
	}
	
	public WebElement getFacebookIcon() {
		/*
		 * this method return facebook icon
		 */
		return facebookicon;
	}
	
	public void clickfacebook() {
		/*
		 * this method is used to click on facebook icon 
		 */
		facebookicon.click();
	}
	
	
}
