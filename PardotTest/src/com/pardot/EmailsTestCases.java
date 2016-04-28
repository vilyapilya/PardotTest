package com.pardot;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmailsTestCases 
{
	WebDriver driver;
	LoginLogoutPageObj login;
	HeadersMarketingPageObj marketing;
	BasicEmailInfo emails;
	SelectFolder folder;
	SelectCampaign camp;
	EmailSending send;
	String OriglistName, email, newName;
	
	@Factory (dataProvider = "randomdata", dataProviderClass = DataGenerators.class)
	public EmailsTestCases(String OriglistName, String email, String newName)
	{
		this.OriglistName = OriglistName;
		this.email = email;
		this.newName = newName;
	}
	
	@BeforeClass
	public void statringpoint()
	{
		driver = new FirefoxDriver();
		login = new LoginLogoutPageObj(driver);
		emails = new BasicEmailInfo(driver);
		camp = new SelectCampaign(driver);
		send = new EmailSending(driver);
		marketing = new HeadersMarketingPageObj(driver);
		folder = new SelectFolder(driver);
		driver.get("https://pi.pardot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login.enterEmail( "pardot.applicant@pardot.com");
		login.enterPassword("Applicant2012");
		login.clickLoginButton();
		marketing.hoverMouseMarketing();
		marketing.selectEmail();
		marketing.selectNewListEmail();
	}
	@AfterClass
	public void finishingPoint()
	{
		login.signout();
		driver.quit();
	}
	
	@Test
	public void setEmail()
	{
		emails.enterEmailName("Testname");
		emails.clickShooseFolderButton();
		folder.selectFolder();
		folder.clickChooseSelectedButton();
		emails.clickChooseCampaign();
		camp.clickCampaignName();
		camp.clickChooseSelectedButton();
		emails.selectTextOnly();
		emails.uncheckTemplate();
		emails.clickSaveButton();
		send.findEmailName("Testname");
		Assert.assertTrue(send.findEmailName("Testname").isDisplayed());	
	}
	@Test(dependsOnMethods="setEmail")
	public void sendEmail()
	{
		send.goToSending();
		send.selectList(OriglistName);
		send.selectSender(email);
		send.enterSubject(OriglistName);
		send.clickSendNow();		
	}
}
