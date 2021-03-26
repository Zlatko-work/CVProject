package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage {

	public WebDriver driver;
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	
	public SauceDemoLoginPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
}
