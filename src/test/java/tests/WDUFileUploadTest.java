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
import pageObjects.WDUFileUploadPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUFileUploadTest extends Base {

	public WebDriver driver;
	
	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void uploadFile() throws InterruptedException 
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUFileUploadPage wdufup = new WDUFileUploadPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4200)");
		wdufp.getFileUploadSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
		wdufup.getFileUploadButton().sendKeys("C:\\Users\\Zlatko\\Desktop\\windows.jpg");
		wdufup.getSubmitButton().click();
		String alertText = driver.switchTo().alert().getText();
	    Assert.assertEquals("Your file has now been uploaded!", alertText);
	    

	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}


