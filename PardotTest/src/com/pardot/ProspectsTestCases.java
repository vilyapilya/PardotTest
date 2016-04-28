package com.pardot;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProspectsTestCases
{
	WebDriver driver; 
	HeadresProspectsPageObj prospTag; 
	ProspectsListPageObjects prsp; 
	CreateProspectPageObj creatPrsp; 
	ListPageObjects listobj; 
	LoginLogoutPageObj login;
	String listName;
	String email;
	
	@Factory (dataProvider = "randomdata", dataProviderClass = DataGenerators.class)
	public ProspectsTestCases(String listName, String email, String newname)
	{
		this.listName = listName;
		this.email = email;
	}
	@BeforeClass
	public void startingPoint()
	{  
		driver = new FirefoxDriver();
		prospTag= new HeadresProspectsPageObj(driver);
		prsp = new ProspectsListPageObjects(driver);
		creatPrsp = new CreateProspectPageObj(driver);
		listobj = new ListPageObjects(driver);
		login = new LoginLogoutPageObj(driver);
		driver.get("https://pi.pardot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login.enterEmail( "pardot.applicant@pardot.com");
		login.enterPassword("Applicant2012");
		login.clickLoginButton();
		prospTag.hoverMouseProspects();
		prospTag.selectProspectsList();
	}
	@AfterClass
	public void finishingPoint()
		{
			login.signout();
			driver.quit();
		}
	@Test
	public void addProspect()
	{	
		prsp.clickAddProspectButton();
		creatPrsp.EnterEmail(email);
		creatPrsp.selectCampaign("Adil Yellow Jackets");
		creatPrsp.selectProfile("Adil Yellow Jackets 1");
		creatPrsp.enterScoreValue("90");
		creatPrsp.clickCreateProspectButton();
		Assert.assertTrue(creatPrsp.findMessageSuccessfulNewPrsp().isDisplayed());
	}
	@Test(dependsOnMethods = {"addProspect"})
	public void addListToPrsp()
	{
		System.out.println(listName);
		//since I use this class only in this method, I did not 
		//make the variable global and instantiate it in @Beforeclass
		ProspectIdPageObj prspInd = new ProspectIdPageObj(driver);
		prspInd.clickOnListsTab();
		System.out.println(listName);
		prspInd.selectListFromMemebershipDropDown(listName);
		prspInd.clickAddListButton();
		Assert.assertTrue(prspInd.getMessageAfterAddingList().isDisplayed());
	}
	
}
