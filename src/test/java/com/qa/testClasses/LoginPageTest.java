package com.qa.testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homePage;

	// Creating LoginPageTest class constructor and calling the super class constructor using super() keyword.
public LoginPageTest()
{
	super();
}

@BeforeMethod
public void setup()
{
	initializaton();
	loginpage=new LoginPage();
	
}

@Test(priority=1)
public void loginPageTitleTest()
{
	String title=loginpage.getLoginPageTitle();	
	Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
}

@Test(priority=2)
public void crmLogoImageTest()
{
	boolean b=loginpage.getValidateCRMLogo();
	Assert.assertTrue(b);
}

@Test(priority=3)
public void loginTest()
{
	homePage=loginpage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
	
}


@AfterMethod
public void tearDown()
{
	driver.quit();
}

}
