package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadersMarketingPageObj 
{
	WebDriver driver;
	WebElement el;
	
	
	By marketingTab = By.id("mark-tog");
	By segmentation = By.xpath("//a[contains(text(),'Segmentation')]");
	By list = By.xpath("//a[contains(text(),'Lists')]");
	By emails = By.xpath("//a[contains(text(), 'Emails')]");
	By newListEmail = By.xpath("//a[contains(text(), 'New List Email')]");
	
	public HeadersMarketingPageObj(WebDriver driver)
	{
		this.driver = driver;
	}
	public void hoverMouseMarketing()
	{   Actions act = new Actions(driver);
		el = driver.findElement(marketingTab);
		act.moveToElement(el).build().perform();		
	}
	public void selectSegmentation()
	{   WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(segmentation));
		Actions act = new Actions(driver);
		el = driver.findElement(segmentation);
		act.moveToElement(el).build().perform();
		
	}
	public void selectLists()
	{
		 WebDriverWait wait = new WebDriverWait(driver, 5);
		 wait.until(ExpectedConditions.presenceOfElementLocated(list));
		 driver.findElement(list).click();
	}
	public void selectEmail()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(emails));
		Actions act = new Actions(driver);
		el = driver.findElement(emails);
		act.moveToElement(el).build().perform();
	}
	public void selectNewListEmail()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(newListEmail));
		driver.findElement(newListEmail).click();
	}
	
	
}
