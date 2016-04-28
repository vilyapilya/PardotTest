package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLogoutPageObj 
{
	WebDriver driver;
	By emailField = By.id("email_address");
	By passwordField = By.id("password");
	By loginButton = By.name("commit");
	By userName = By.xpath("//a[@id='acct-tog']/span");
	By signOut = By.xpath("//a[contains(text(),'Sign Out')]");
	
	public LoginLogoutPageObj(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(emailField).sendKeys(email);
		
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public void signout()
	{
		driver.findElement(userName).click();
		driver.findElement(signOut).click();
	}
}
