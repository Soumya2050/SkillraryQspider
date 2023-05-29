package GenericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	private Actions a;
	private Select s;
	
	/**
	 * This method is used to lunch browser
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */
	public WebDriver OpenApplication(String browser) {
		switch(browser) {
		case "chrome":WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "firefox":WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		case "edge":WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		default:System.out.println("Invalid browser");
		}
		return driver;
	}
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	public void navigateToApp(String url) {
		driver.get(url);
	}
	public void waitUntilElementIsFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to wait until the element is visible 
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitwait(WebElement element,long time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		WebElement e=wait.until(ExpectedConditions.visibilityOf(element));
		return e;
	}
	/**
	 * This method is used to mousehover to an element
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		a=new Actions(driver);
		a.moveToElement(element).perform();;
	}
	/**
	 * This method is used to doubleclick of an element
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click to an element
	 * @param element
	 */
	public void rightClick(WebElement element) {
		a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop to an element
	 * @param src
	 * @param dest
	 */
	public void DragAndDrop(WebElement src,WebElement dest) {
		a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	/**
	 * This method is used to select an element from dropdown based on the index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element,int index) {
		s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select an element from dropdown based on the value
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element,String value) {
		s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select an element from dropdown based on the text
	 * @param text
	 * @param element
	 */
	public void dropdown(String text,WebElement element) {
		s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to switch the control to the frame using index
	 * @param index
	 */
	public void frames(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the control to the frame using name or id
	 * @param nameORid
	 */
	public void frames(String nameORid) {
		driver.switchTo().frame(nameORid);
	}
	/**
	 * This method is used to switch the control to the frame using WebElement
	 * @param frameElement
	 */
	public void frames(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to switch back from frame
	 */
	public void SwitchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to scrool the element
	 * @param element
	 */
	public void scroolTitleElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	/**
	 * This method is used to take the screenshot of the webpage
	 * @param javaUtil
	 */
	public void takeScreenShot(JavaUtility javaUtil) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/ss_"+javaUtil.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to handle the alert popup
	 * @param status
	 */
	public void HandleAlert(String status) {
		Alert a=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			a.accept();
		else
			a.dismiss();
	}
	/**
	 * This method return parent browser address
	 */
	public void switchToParentWindow() {
		driver.switchTo().window(driver.getWindowHandle());
	}
	/**
	 *This method return all the browser address 
	 */
	public void switchToChildWindow() {
		Set<String>set=driver.getWindowHandles();
		for (String wid : set) {
			driver.switchTo().window(wid);
		}
	}
	/**
	 * This method is used to close the current tab
	 */
	public void closeCurrentTab() {
		driver.close();
	}
	/**
	 * This method is used to close all tabs and quit the browser
	 */
	public void quiteBrowser() {
		driver.quit();
	}

}
