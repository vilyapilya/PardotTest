package com.pardot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicEmailInfo 
{
	WebDriver driver;
	
	By name = By.id("name");
	By chooseFolder = By.xpath("//span[contains(text(), '/Uncategorized/Emails')]");
	By chooseCampaign = By.xpath("//span[contains(text(), 'Choose a Campaign')]");
	By saveButton = By.id("save_information");
	By textOnlyRadio = By.id("email_type_text_only");
	By formTamplateCheckB = By.id("from_template");
	
	public BasicEmailInfo(WebDriver driver)
	{
		this.driver = driver;
	}
	public void enterEmailName(String ename)
	{
		driver.findElement(name).sendKeys(ename);
	}
	public void clickShooseFolderButton()
	{
		driver.findElement(chooseFolder).click();
	}
	public void clickChooseCampaign()
	{
		driver.findElement(chooseCampaign).click();
	}
	
	public void clickSaveButton()
	{
		driver.findElement(saveButton).click();
	}
	
	public void selectTextOnly()
	{
		driver.findElement(textOnlyRadio).click();
	}
	public void uncheckTemplate()
	{
		WebElement el = driver.findElement(formTamplateCheckB);
		if (el.isSelected() == true)
		{
			el.click();
		}
	} 
}
