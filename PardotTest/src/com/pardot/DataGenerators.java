package com.pardot;
import org.testng.annotations.*;

public class DataGenerators 
{

	static RandomValueGenerator gr = new RandomValueGenerator();
	static String list = gr.nextSessionId();
	static String email = list+"@mail.com";
	static String newName = gr.nextSessionId();

	@DataProvider
	public static Object[][] randomdata()
	{	
		return new Object[][]{{list, email, newName}};	
	}
	
}
	
	/*
	String s;
	public DataGenerators()
	{
		RandomValueGenerator gr = new RandomValueGenerator();
		String listName = gr.nextSessionId();
		this.s = listName;
	}
	
	public String getListName()
	{
		return s;
	}
*/

