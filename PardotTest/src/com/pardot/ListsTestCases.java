package com.pardot;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ListsTestCases
{	
	WebDriver driver;
	HeadersMarketingPageObj marketing;
	ListPageObjects listobj; 
	LoginLogoutPageObj login;
	CreateProspectPageObj creatPrsp;
	ListIDPageObjects listID;
	ListInformationPageObjects listInfo;
	SelectFolder folder;
	String listName;
	String email;
	String newName;
	
	@Factory (dataProvider = "randomdata", dataProviderClass = DataGenerators.class)
	public ListsTestCases(String OriglistName, String email, String newName)
	{
		this.listName = OriglistName;
		this.email = email;
		this.newName = newName;
	} 
	
	@BeforeClass
	public void startingPoint()
	{
		driver = new FirefoxDriver();
		marketing = new HeadersMarketingPageObj(driver);	
		listID = new ListIDPageObjects(driver);
		listobj= new ListPageObjects(driver);
		login = new LoginLogoutPageObj(driver);
		folder = new SelectFolder(driver);
		listInfo = new ListInformationPageObjects(driver);
		driver.get("https://pi.pardot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login.enterEmail( "pardot.applicant@pardot.com");
		login.enterPassword("Applicant2012");
		login.clickLoginButton();
		
	}	
	@AfterClass
	public void finishingPoint()
	{
		login.signout();
		driver.quit();
	}
	@BeforeMethod
	public void goBackToListsPage()
	{
		marketing.hoverMouseMarketing();
		marketing.selectSegmentation();
		marketing.selectLists();
	}

	@Test
	public void createListSuccessfully()
	{   
		listobj.clickAddList();
		listInfo.listInfoEnterName(listName);
		listInfo.clickChooseFolderBurron();
		folder.selectFolder();
		folder.clickChooseSelectedButton();
		listInfo.clickCreateListButton();
	    Assert.assertTrue(listID.getListName().contains(listName));  
	        //I tried to use the url id to locate the list names, but 
	  		//it did not work
	  		//listIDcreated = listID.getListIDfromURL();
	}
	@Test(dependsOnMethods = {"createListSuccessfully"})
	public void duplicateListNameWarning()
	{
		listobj.clickAddList();
		listInfo.listInfoEnterName(listName);
		listInfo.clickChooseFolderBurron();
		folder.selectFolder();
		folder.clickChooseSelectedButton();
		listInfo.clickCreateListButton();
		Assert.assertTrue(listInfo.getErrorForNotUniqName().contains("Please input a unique value for this field"));
		listInfo.clicklisInfoCancelButton();
	
	}
	@Test(dependsOnMethods = {"duplicateListNameWarning"})
	public void editTheListName()
	{
		listobj.enterValueintoFilter(listName);
		listobj.clickListNameFromCreatedList(listName);
		listID.clickEditButton();
		listInfo.listInfoEnterName(newName);
		listInfo.clickCreateListButton();
		Assert.assertTrue(listID.getListName().contains(newName));
	}

	@Test (dependsOnMethods = {"editTheListName"})
	public void createTheListWithTheUsedName()
	{
		listobj.clickAddList();
		listInfo.listInfoEnterName(listName);
		listInfo.clickChooseFolderBurron();
		folder.selectFolder();
		folder.clickChooseSelectedButton();
	    listInfo.clickCreateListButton();
		Assert.assertTrue(listID.getListName().contains(listName));
		// Another piece of that attempt 
	    //listID.getURLid();
	}
	@Test 
	public void findAddedList()
	{
		listobj.enterValueintoFilter(listName);
		listobj.clickListNameFromCreatedList(listName);
		listID.selectAllProspectsinView();
		listID.selectDateRangeLast();
		Assert.assertTrue(listID.findTotalProspecs().contains("1"));
		//Could not locate the prospect in the list of prospects,
		//so I decided to verify the total number of them since 
		//the test suits presumes creating brand new lists and prospects
		//listID.enterPrspNameintoFilter(email);
		//listID.findtheProspectName(email);

	}
	
}
