package testScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class SendContactDetailsTest extends BaseClass{
	
	@Test
	public void sendContactDetailTest() {
		SoftAssert soft=new SoftAssert();
		home.clickgearTab();
		home.clickSkillraryApp();
		web.switchToChildWindow();
		
		soft.assertTrue(selenium.getPageHeader().contains("ECommerce"));
		web.scroolTitleElement(demoapp.getContactUs());
		demoapp.clickContactUs();
		soft.assertTrue(contactus.getcontactuslogo().isDisplayed());
		
		Map<String,String> map=excel.ReadData("Sheet2");
		contactus.senddetails(map.get("Fullname"),map.get("email"),map.get("subject"),map.get("message"));
		
		soft.assertAll();
		
	}
}
