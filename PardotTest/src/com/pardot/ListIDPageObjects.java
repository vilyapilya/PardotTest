package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ListIDPageObjects 
{ 
	WebDriver driver;
	
	//Attempt to locate lists through url ids
	//static String listID; 
	
	By listNameDisplayed = By.xpath(".//*[@id='content']/h1");
	By editButton = By.xpath("//a[@title='Access key e']");
	By prospectsViewDropDown = By.xpath("//select[@id='listxProspect_view_field']");
	By dateRange = By.xpath("//select[@id='dateType_listxpect']");
	By prospectsForm = By.xpath("//form[@id='listxProspect_view']");
	By prospectsFilter = By.id("listxProspect_table_filter");
	By totalProspects = By.xpath("//div[@class='pardot-well']/h4");
	 
 
	public ListIDPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getListName()
	{
		return driver.findElement(listNameDisplayed).getText();
	}
	
	public void clickEditButton()
	{
		driver.findElement(editButton).click();
	}
	
	public void selectAllProspectsinView()
	{
		WebElement el=driver.findElement(prospectsForm).findElement(prospectsViewDropDown);	
		Select select = new Select(el);
		select.selectByVisibleText("All Prospects");
	}
	
	public void selectDateRangeLast()
	{	
		WebElement el=driver.findElement(dateRange);
		Select select = new Select(el);
		select.selectByVisibleText("Last Activity");
	}
	
	public String findTotalProspecs()
	{
		System.out.println(driver.findElement(totalProspects).getText());
		return driver.findElement(totalProspects).getText();
	}
	
	public void enterPrspNameintoFilter(String name)
	{
		driver.findElement(prospectsFilter).sendKeys(name);
	}
	
	/* Attempt to locate the element using url id
	public String getURLid()
	{	
		String[] ar = driver.getCurrentUrl().split("/");
		int size = ar.length;
		listID = ar[size-1];
		return ar[size-1];
		
	}
	*/
}
