package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProspectIdPageObj 
{
	WebDriver driver;
	
	By listsTab = By.xpath("//ul[@class='nav']/li[2]");
	By listsTabSelectList = By.xpath("//div[@id='selXAQ_chzn']");
	By listsMemebershipForm = By.xpath("//div[@class='chzn-container chzn-container-single']");
	By listNIDropDown = By.xpath("//ul[@class='chzn-results']");
	By listMemebershipDroDownSeacrh = By.xpath("//div[@class='chzn-search']");
	By addListButton = By.xpath("//input[@value='Save lists']");
	By prospectLisSavedSuccMessage = By.xpath("//div/i[@class='icon-info-sign']");
	
	public ProspectIdPageObj(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnListsTab()
	{		
		driver.findElement(listsTab).click();
	}
	
	public void selectListFromMemebershipDropDown(String listName)
	{   System.out.println(listName);
		driver.findElement(listsMemebershipForm).click();;
		WebElement el = driver.findElement(By.xpath("//ul[@class='chzn-results']/li[contains(text(),'"+listName+"')]"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", el);
		el.click();	
	}
	
	public void clickAddListButton() 
	{
		driver.findElement(addListButton).click();		
	}
	
	public WebElement getMessageAfterAddingList()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(prospectLisSavedSuccMessage));
		return driver.findElement(prospectLisSavedSuccMessage);
	}	
}
