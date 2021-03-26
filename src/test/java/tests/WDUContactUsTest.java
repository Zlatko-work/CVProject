package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUContactUsTest extends Base {

	public WebDriver driver;
	
	@BeforeClass

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	
	public void validateResetButton() throws InterruptedException
	{
		WDUContactUsPage wdcup = new WDUContactUsPage(driver);
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		wdufp.getContactUsSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
		wdcup.getFirstName().sendKeys("Zlatko");
		wdcup.getLastName().sendKeys("Cvetkoski");
		wdcup.getEmail().sendKeys("Zlatko@gmail.com");
		wdcup.getResetButton().click();
		Assert.assertEquals("", wdcup.getFirstName().getText());
		}
		
		@Test(priority=2)
		public void validateContactUs() throws InterruptedException
		{
			WDUContactUsPage wdcup = new WDUContactUsPage(driver);
			WDUFrontPage wdufp = new WDUFrontPage(driver);
			wdcup.getFirstName().sendKeys("Zlatko");
			wdcup.getLastName().sendKeys("Cvetkoski");
			wdcup.getEmail().sendKeys("Zlatko@gmail.com");
			wdcup.getComments().sendKeys("I would like to ask a question");
			wdcup.getSubmitButton().click();
			String validationText = wdcup.getValidationText().getText();
			Assert.assertEquals(validationText, "Thank You for your Message!");
			driver.quit();
		}
		
		
	
	@Test(priority=3)
	
	public void invalidContactUs() throws InterruptedException, IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
		WDUContactUsPage wdcup = new WDUContactUsPage(driver);
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		wdufp.getContactUsSection().click();
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
		driver.switchTo().window(childId);
		Thread.sleep(3000);
		wdcup.getFirstName().sendKeys("Zlatko");
		wdcup.getLastName().sendKeys("Cvetkoski");
		wdcup.getEmail().sendKeys("Zlatko");
		wdcup.getComments().sendKeys("I would like to ask a question");
		wdcup.getSubmitButton().click();
		String invalidEmailText = wdcup.getInvalidEmailText().getText();
		Assert.assertEquals(invalidEmailText, "Error: Invalid email address");
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	}



