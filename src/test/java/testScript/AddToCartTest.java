package testScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class AddToCartTest  extends BaseClass{
	
	@Test
	public void addToCart() {
		SoftAssert soft=new SoftAssert();
		home.clickgearTab();
		home.clickSkillraryApp();
		web.switchToChildWindow();
		
		soft.assertTrue(demoapp.PageHeader().contains("ECommerce"));
		demoapp.MouseHoverToCourse(web);
		demoapp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
		
		int intialquantity=Integer.parseInt(selenium.getquantity());
		selenium.doubleclickAdd(web);
		int finalquantity =Integer.parseInt(selenium.getquantity());
		
		soft.assertEquals(finalquantity, intialquantity+1);
		selenium.clickAddToCart();
		web.HandleAlert("ok");
		soft.assertEquals(selenium.getitemAddMsg(),"Item added to cart");
		
		soft.assertAll();
	}

}
