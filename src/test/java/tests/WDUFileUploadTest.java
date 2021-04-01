package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUFileUploadPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUFileUploadTest extends Base {

	public WebDriver driver;
	
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1) // Uploading a file properly
	public void uploadFile() throws InterruptedException 
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUFileUploadPage wdufup = new WDUFileUploadPage(driver);
		wdufup.scrollingPage();
		wdufp.getFileUploadSection().click();
		driver.switchTo().window(getChildWindow());
		wdufup.getWebDriverWaitFileUpload();
		wdufup.getFileUploadButton().sendKeys(wdufup.pathOfFile);
		wdufup.getSubmitButton().click();
		wdufup.getAlertText();
	    Assert.assertEquals("Your file has now been uploaded!", wdufup.getAlertText());
	    

	}
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
}


