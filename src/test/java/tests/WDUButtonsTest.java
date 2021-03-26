package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUButtonClicksPage;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUButtonsTest extends Base {

	public WebDriver driver;
	
	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void validateButtonOne() throws InterruptedException 
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUButtonClicksPage wdubcp = new WDUButtonClicksPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		wdufp.getButtonClickSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
		wdubcp.getButtonOne().click();
		wdubcp.getCloseButton().click();
		
	}
	
	@Test(priority=2)
	
	public void validateButtonTwoUsingJavascriptExecutor()
	{
		WDUButtonClicksPage wdubcp = new WDUButtonClicksPage(driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wdubcp.getButtonTwo());
		wdubcp.getCloseButton().click();
	}
	
	@Test(priority=3)
	
	public void validateButtonThreeUsingMouseAndKeyboard()
	{
		WDUButtonClicksPage wdubcp = new WDUButtonClicksPage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(wdubcp.getButtonThree()).click().build().perform();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	}



