package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProspectsListPageObjects
{
	WebDriver driver;
	
	By addList = By.id("pr_link_create");
	
	public ProspectsListPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickAddProspectButton()
	{
		driver.findElement(addList).click();
	}
		
}
