package com.qa.testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil tutil;
	ContactsPage contactsPage;
	String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initializaton();
		loginpage=new LoginPage();
		tutil=new TestUtil();
		homepage=loginpage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
		tutil.switchToFrame();
		contactsPage=homepage.clickOnConatctsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabelTest());
	}	
	
	@Test(priority=2)
	public void selectContactsCheckBoxTest()
	{
		contactsPage.selectContactsCheckBoxByName("pinky navya");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsCheckBoxTest()
	{
		contactsPage.selectContactsCheckBoxByName("pinky navya");
		contactsPage.selectContactsCheckBoxByName("kiran repaka");
		
	}
	
	@Test(priority=4)
	public void validateCreateNewContact()
	{
		homepage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=5, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homepage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
