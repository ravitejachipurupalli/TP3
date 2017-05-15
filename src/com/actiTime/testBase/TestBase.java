package com.actiTime.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.actiTime.testUtils.Utills;

public class TestBase extends Utills
{
	public Properties Repository = new Properties();
	public File f;
	FileInputStream fis;
	
	public void init() throws Exception
	{
		loadPropertiesFille();
		selectBrowser("firefox");
		implicitWait(30);
		driver.get(Repository.getProperty("url"));
	}
	


	public void loadPropertiesFille() throws Exception
	{
		f = new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\config\\config.properties");
		fis = new FileInputStream(f);
		Repository.load(fis);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\loginpage.properties");
		fis = new FileInputStream(f);
		Repository.load(fis);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\reportspage.properties");
		fis = new FileInputStream(f);
		Repository.load(fis);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\taskPage.properties");
		fis = new FileInputStream(f);
		Repository.load(fis);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\timeTracks.properties");
		fis = new FileInputStream(f);
		Repository.load(fis);
	}
	
	public WebElement getLocator(String locator) throws Exception
	{
		String locatorType = locator.split("_")[0];
		String locatorValue = locator.split("_")[1];
		
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if (locatorType.toLowerCase().equals("classname") || (locatorType.toLowerCase().equals("class")))
		   return driver.findElement(By.className(locatorValue));
		else if (locatorType.toLowerCase().equals("tagname") || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.tagName(locatorValue));
		else if (locatorType.toLowerCase().equals("linktext") || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if (locatorType.toLowerCase().equals("cssselector") || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else 
			throw new Exception("Unknown locator type '"+locatorType+"'");		
	}
	
	public WebElement getWebElement(String locator) throws Exception
	{
		return getLocator(Repository.getProperty(locator));
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
