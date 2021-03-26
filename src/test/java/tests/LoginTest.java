package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;

import pageObjects.SauceDemoLoginPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("saucedemo"));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getData")
	
	public void LoginTests(String Username, String Password) throws IOException
	{
		
		
		SauceDemoLoginPage sdlp = new SauceDemoLoginPage(driver);
		sdlp.getUsername().sendKeys(Username);
		sdlp.getPassword().sendKeys(Password);
		sdlp.getLoginButton().click();
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, "https://www.saucedemo.com/inventory.html");
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[4][2];
		data[0][0] ="standard_user";
		data[0][1] = "secret_sauce";
		
		data[1][0] = "locked_out_user";
		data[1][1] = "secret_sauce";
		
		data[2][0] = "problem_user";
		data[2][1] = "secret_sauce";
		
		data[3][0] = "performance_glitch_user";
		data[3][1] = "secret_sauce";
		
		
		return data;
	}

}
