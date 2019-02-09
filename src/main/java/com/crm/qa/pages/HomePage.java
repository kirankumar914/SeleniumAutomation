package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'kumar kiran')] ")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	//Initialize the above web elements by creating a constructor 
	
	public HomePage()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnConatctsLink()
	{
		contactsLink.click();
		return new ContactsPage();	
	}
	
	public DealsPage clickOnDelasLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();	
	}
	
	public boolean verifyUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}
