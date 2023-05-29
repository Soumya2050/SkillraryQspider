package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class SeleniumTrainingPage {
	//Declaration
	@FindBy(xpath = "//div[@class='navbar-header']")
	private WebElement PageHeader;
	
	@FindBy(id = "quantity")
	private WebElement quantity;
	
	@FindBy(xpath = "//button[@id='add']")
	private WebElement plusButton;
	
	@FindBy(xpath = "//button[.=' Add to Cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//div[@id='callout']/span")
	private WebElement itemAddedMessage;
	
	//intialization
	
	public SeleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getPageHeader() {
		return PageHeader.getText();
	}
	/*this method used to fetch the quantity of product
	 */
	public String getquantity() {
		return quantity.getAttribute("value");
	}
	
	public void doubleclickAdd(WebDriverUtility web) {
		web.doubleClick(plusButton);
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}
	
	public String getitemAddMsg() {
		return itemAddedMessage.getText();
	}
}
