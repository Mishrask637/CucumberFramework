package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By loginButton = By.id("SubmitLogin");
	private By forgotpasswdlink = By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getLoginPagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPassLinkExists()
	{
		return driver.findElement(forgotpasswdlink).isDisplayed();
	}
	
	public void enteruserName(String userName)
	{
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterpasswd(String passwd)
	{
		driver.findElement(password).sendKeys(passwd);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(loginButton).click();
	}
	
	public AccountsPage doLogin(String un,String pwd)
	{
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new AccountsPage(driver);
	}
}
