package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']//parent::td")
	WebElement saveButton;
	
	@FindBy(name="title")
	WebElement titleDropDown;
	
	public ContactsPage()
	{ 
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabelTest()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsCheckBoxByName(String contactsName)
	{
		driver.findElement(By.xpath("//a[text()='"+contactsName+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String fName,String lName,String copmanyName)
	{
		Select select =new Select(titleDropDown);
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(copmanyName);
		saveButton.click();
		
	}

}
