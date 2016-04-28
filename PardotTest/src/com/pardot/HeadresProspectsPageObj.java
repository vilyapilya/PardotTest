package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HeadresProspectsPageObj 
{	
	WebDriver driver;
	WebElement el;
	
	By prospectsTab = By.id("pro-tog");
	By prospectsList = By.xpath("//a[contains(text(), 'Prospect List')]");
	
	public HeadresProspectsPageObj(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void hoverMouseProspects()
	{ 
		Actions act = new Actions(driver);
		el = driver.findElement(prospectsTab);
		act.moveToElement(el).build().perform();		
	}
	public void selectProspectsList()
	{  
		driver.findElement(prospectsList).click();
	}
}
