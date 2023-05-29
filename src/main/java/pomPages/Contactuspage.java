package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactuspage {

	/*
	 * this class contains elements locators and respective business libraries of contact us page
	 */

//declaration
	@FindBy(xpath = "//img[contains(@src,\"contactus\")]")
	private WebElement contactuslogo;
	
	@FindBy(name = "name")
	private WebElement fullnametextfield;

	@FindBy(name = "sender")
	private WebElement emailtextfield;
	
	@FindBy(name = "subject")
	private WebElement subjecttextfield;
	
	@FindBy(name = "message")
	private WebElement messagebox;
	
	@FindBy(xpath  = "//button[text()=\"Send us mail\"]")
	private WebElement sendusemailbutton;
	
//initialization
	public Contactuspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//utilization
	public WebElement getcontactuslogo() {
		/*
		 * this method returns logo
		 */
		return contactuslogo;
	}
	
	public void senddetails(String name, String email, String subject, String message) {
		
	/*
	 * this method is used to send the conatct details
	 */
		fullnametextfield.sendKeys(name);
		emailtextfield.sendKeys(email);
		subjecttextfield.sendKeys(subject);
		messagebox.sendKeys(message);
		sendusemailbutton.click();
	}
}

