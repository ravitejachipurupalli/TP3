package com.actiTime.testUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Utills 
{
	public static WebDriver driver;
	
	
	//method to initialize a browser
	public static WebDriver selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		
		return null;
	}
	
	//method to wait implicitly
	public static void implicitWait(int timeInSec)
	{
		Reporter.log("Waiting for page to load..");
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
		Reporter.log("Page loaded successfully");
	}
	
	//method to select a value from the drop down list
	public static WebElement selectDropDown(WebElement element, String dropDownValue)
	{
		Select select = new Select(element);
		Reporter.log("Selecting "+dropDownValue+" value from dropdown");
		select.selectByVisibleText(dropDownValue);
		return element;
	}
	
	//method to wait blindly
	public void driverWait(int timeToWaitInSec) throws InterruptedException
	{
		Reporter.log("Waiting for "+timeToWaitInSec+" seconds...");
		Thread.sleep(timeToWaitInSec*1000);
	}
	
	//method to wait explicitly
	public void explicitWait(WebElement element, int timeToWaitInSec)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
