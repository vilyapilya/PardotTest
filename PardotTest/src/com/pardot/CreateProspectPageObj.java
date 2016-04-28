package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateProspectPageObj 
{
	WebDriver driver;
	
	By createPrspEmail = By.xpath("//input[@id = 'email']");
	By campaignID = By.id("campaign_id");
	By profileID = By.id("profile_id");
	By scoreField = By.id("score");
	By createProspectButton = By.xpath("//input[@value='Create prospect']");
	By messageNewSuccessfulPrsp = By.id("center-stage");
	
	public CreateProspectPageObj(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void EnterEmail(String email)
	{
		driver.findElement(createPrspEmail).sendKeys(email);
	}
	
	public void selectCampaign(String campaign)
	{
		Select select = new Select(driver.findElement(campaignID));
		select.selectByVisibleText(campaign);		
	}
	
	public void selectProfile(String profile)
	{
		Select select = new Select(driver.findElement(profileID));
		select.selectByVisibleText(profile);		
	}
	
	public void enterScoreValue(String value)
	{
		WebElement el = driver.findElement(scoreField);
		el.clear();
		el.sendKeys(value);
	}
	
	public void clickCreateProspectButton()
	{
		WebElement el = driver.findElement(createProspectButton);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		el.click();	
	}
	
	public WebElement findMessageSuccessfulNewPrsp()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(messageNewSuccessfulPrsp));
		return driver.findElement(messageNewSuccessfulPrsp);
	}
}
