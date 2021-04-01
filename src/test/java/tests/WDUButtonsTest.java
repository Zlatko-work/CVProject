package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.WDUButtonClicksPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUButtonsTest extends Base {

	public WebDriver driver;
	
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1) // Clicking the first button 
	public void validateButtonOne() throws InterruptedException 
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUButtonClicksPage wdubcp = new WDUButtonClicksPage(driver);
	    wdubcp.scrollPage();
		wdufp.getButtonClickSection().click();
		driver.switchTo().window(getChildWindow());
		wdubcp.getWebDriverWaitButton();
		wdubcp.getButtonOne().click();
		wdubcp.getCloseButton().click();
		
	}
	
	@Test(priority=2) // Clicking the second button with JavaScript click method 
	
	public void validateButtonTwoUsingJavascriptExecutor()
	{
		WDUButtonClicksPage wdubcp = new WDUButtonClicksPage(driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wdubcp.getButtonTwo());
		wdubcp.getCloseButton().click();
	}
	
	@Test(priority=3) // Clicking the third button with using Action Move & Click
	
	public void validateButtonThreeUsingMouseAndKeyboard()
	{
		WDUButtonClicksPage wdubcp = new WDUButtonClicksPage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(wdubcp.getButtonThree()).click().build().perform();
	}
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
	
	
	
	}



