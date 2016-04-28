package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListPageObjects 
{
	WebDriver driver;
		
	By addList = By.id("listxistx_link_create");
	By listsFilter = By.xpath("//input[@id='listx_table_filter']");
	 
	public ListPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickAddList()
	{
		driver.findElement(addList).click();
	}
	
	public void enterValueintoFilter(String value)
	{
		WebElement el = driver.findElement(listsFilter);
		el.click();
		el.sendKeys(value);
	}
	
	public void clickListNameFromCreatedList(String name)
	{	
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
	
}

