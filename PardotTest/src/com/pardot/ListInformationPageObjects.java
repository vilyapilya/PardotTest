package com.pardot;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListInformationPageObjects 
{
	WebDriver driver;
	
	By listInfoChooseFolderButton = By.xpath("//button[@class='btn choose-asset']");
	By listInfoName = By.id("name");
	By saveNewFolder = By.xpath("//div[@class='btn btn-success']");
	By createListButton = By.id("save_information");
	By errorForName = By.id("error_for_name");
	By listInfoCancelButton = By.xpath("//*[@id='dynamicList-form']/div[3]/a");
	
	
	public ListInformationPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void listInfoEnterName(String name)
	{
		WebElement el = driver.findElement(listInfoName);
		el.clear();
		el.sendKeys(name);
	}
	public void clickChooseFolderBurron()
	{
		driver.findElement(listInfoChooseFolderButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	
	public void clickCreateListButton()
	{
		driver.findElement(createListButton).click();
	}
	
	public String getErrorForNotUniqName()
	{
		return driver.findElement(errorForName).getText();
	}
	
	public void clicklisInfoCancelButton()
	{
		driver.findElement(listInfoCancelButton).click();
	}

}
