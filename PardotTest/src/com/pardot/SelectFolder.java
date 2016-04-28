package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectFolder 
{
	WebDriver driver;

	//the folder name is hardcoded as it's not folders test case
	By theNewFolder = By.xpath("//span[@title='Adwords']");
	By saveNewFolder = By.xpath("//div[@class='btn btn-success']");
	By addFolderButton = By.xpath("//div[contains(text(), 'Add Folder')]");
	By newFolderName = By.xpath("//input[@placeholder='New folder name']");
	By chooseSelectedButton = By.id("select-asset");
	
	public SelectFolder(WebDriver driver)
	{
		this.driver = driver;
	}
	public void addFolder(String foldername)
	{
		driver.findElement(addFolderButton).click();
		driver.findElement(newFolderName).sendKeys(foldername);
		driver.findElement(saveNewFolder).click();	
	}
	public void selectFolder()
	{	
		driver.findElement(theNewFolder).click();;	
	}
	public void clickChooseSelectedButton()
	{
		driver.findElement(chooseSelectedButton).click();	
	}
}
