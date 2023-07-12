package testScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class AddPythonToMyCart extends BaseClass{
	@Test
	public void addPythonTomyCart() {
		SoftAssert soft=new SoftAssert();
		home.clickgearTab();
		home.clickSkillraryApp();
		web.switchToChildWindow();
		
		soft.assertTrue(selenium.getPageHeader().contains("ECommerce"));
		demoapp.SelectCatagory(web, 1);
		soft.assertEquals(test.getpageheader(),"Testing");
		
		web.scroolTitleElement(test.getPythonImage());
		web.DragAndDrop(test.getPythonImage(), test.getCartArea());
		
		web.scroolTitleElement(test.getFacebookIcon());
		test.clickfacebook();
		soft.assertAll();
	
	}

}
