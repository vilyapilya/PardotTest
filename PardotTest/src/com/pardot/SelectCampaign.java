package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectCampaign 
{
	WebDriver driver;
	
	By campaign = By.xpath("//h4[contains(text(), ' Kat Eagles')]");
	By chooseSelectedButton = By.xpath("//button[contains(text(), 'Choose Selected')]");
		
	SelectCampaign(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickCampaignName()
	{
		driver.findElement(campaign).click();
	}
	
	public void clickChooseSelectedButton()
	{
		driver.findElement(chooseSelectedButton).click();
	}
}
