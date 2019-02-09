package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	Actions action;
	
	@FindBy(name="username")
	WebElement username; 
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginSubmitBtn;
	
	@FindBy(xpath="//section[@id='services']//div[@class='row']//div[1]//a[1]")
	WebElement signUpLink;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//method to initialize the above elements or objects
	//use either LoginPage.class or this both are same
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	//get the title of the login page
	
	public String getLoginPageTitle()
	{
         return driver.getTitle();
	}
	
	// Validate the presence of logo
	
	public boolean getValidateCRMLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage getLogin(String userName, String pwd)
	{
		username.sendKeys(userName);
		password.sendKeys(pwd);	
		
     	WebDriverWait wait=new WebDriverWait(driver, 3);
		boolean visiable=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(visiable)
		{
			loginSubmitBtn.click();
		}
		return new HomePage();
	}
	 
	
	

	
}
