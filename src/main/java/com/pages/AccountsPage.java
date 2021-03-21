package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By accountsSection = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public int getAccountSectionCount()
	{
		return driver.findElements(accountsSection).size();
	}
	
	
	public String getAccountPageTitle()
	{
		return driver.getTitle();
	}
	
	public List<String> getAccountSectionList()
	{
		List<WebElement> accountSectionList = driver.findElements(accountsSection);
		List<String> accountsList = new ArrayList<String>();
		for(WebElement ele : accountSectionList)
		{
			accountsList.add(ele.getText());
			System.out.println("Element is "+ele.getText());
		}
		return accountsList;
	}
	
	
}
