package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> threadlocalDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser)
	{
		
		System.out.println("Browser value is "+browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			threadlocalDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			threadlocalDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			threadlocalDriver.set(new InternetExplorerDriver());
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			threadlocalDriver.set(new EdgeDriver());
		}
		else
		{
			System.out.println("Please pass the correct value of browser "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return threadlocalDriver.get();
	}
	
}
