package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUContactUsTest extends Base {

	public WebDriver driver;
	
	@BeforeClass

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1) // Validating reset button that works properly
	
	public void validateResetButton() throws InterruptedException
	{
		WDUContactUsPage wdcup = new WDUContactUsPage(driver);
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		wdufp.getContactUsSection().click();
		driver.switchTo().window(getChildWindow());
		wdcup.sendValidCredentials();
		wdcup.getResetButton().click();
		wdcup.getWebDriverWaitContactUsResetButton();
		Assert.assertEquals("", wdcup.getFirstName().getText());
		}
		
		@Test(priority=2) // Validating contact us section using valid data
		public void validateContactUs() throws InterruptedException
		{
			WDUContactUsPage wdcup = new WDUContactUsPage(driver);
			wdcup.sendValidCredentialsWithComment();
			wdcup.getSubmitButton().click();
            Assert.assertEquals(wdcup.getFinalText(), "Thank You for your Message!");
			driver.quit();
		}
		
		
	
	@Test(priority=3) // Validating contact us section using invalid data
	
	public void invalidContactUs() throws InterruptedException, IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
		WDUContactUsPage wdcup = new WDUContactUsPage(driver);
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		wdufp.getContactUsSection().click();
		driver.switchTo().window(getChildWindow());
		wdcup.sendInvalidCredentials();
		wdcup.getSubmitButton().click();
		Assert.assertEquals(wdcup.getInvalidText(), "Error: Invalid email address");
	}
	
	
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
	
	}



