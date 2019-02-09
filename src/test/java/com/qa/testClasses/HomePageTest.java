package com.qa.testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil tutil;
	ContactsPage contactsPage;

	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initializaton();
		loginpage=new LoginPage();
		tutil=new TestUtil();
		contactsPage=new ContactsPage();
		homepage=loginpage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homePageTitle);
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		tutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		tutil.switchToFrame();
		contactsPage=homepage.clickOnConatctsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
