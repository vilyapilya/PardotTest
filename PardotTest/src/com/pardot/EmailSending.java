package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class EmailSending 
{
	WebDriver driver;
	
	By sending = By.id("flow_sending");
	By sendTo = By.xpath("//span[contains(text(), 'Select a list to add...')]");
	By listSearch = By.xpath("//div[@class='chzn-search']/input[@type='text']");
	By sender = By.name("a_sender[]");
	By senderName = By.xpath("//select[@name='a_sender[]']");
	By generalNameField = By.name("a_general_name");
	By generalEmailField = By.name("a_general_email");
	By subjectLine = By.id("subject_a");
	By sendNow = By.xpath("//a[contains(text(), 'Send Now')]");

	public EmailSending(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement findEmailName(String name)
	{
		return driver.findElement(By.xpath("//div[contains(text(), '"+name+"')]"));
	}
	
	public void goToSending()
	{
		driver.findElement(sending).click();
	}
	
	public void selectList(String listName)
	{
		driver.findElement(sendTo).click();
		WebElement el = driver.findElement(listSearch);
		el.click();
		el.sendKeys("listName");
		driver.findElement(By.xpath("//li[contains(text(), 'listName')]")).click();	
	}
	
	public void selectSender(String randomEmail)
	{
		WebElement el = driver.findElement(sender);
		Select sel = new Select(el);
		sel.selectByVisibleText("General User");
		driver.findElement(generalNameField).sendKeys("genralUser");
		driver.findElement(generalEmailField).sendKeys(randomEmail);			
	}
	
	public void enterSubject(String str)
	{
		driver.findElement(subjectLine).sendKeys(str);
	}
	
	public void clickSendNow()
	{
		driver.findElement(sendNow).click();
	}
}
