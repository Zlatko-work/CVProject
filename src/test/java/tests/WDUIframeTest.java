package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUFrontPage;
import pageObjects.WDUIFramePage;
import resources.Base;



public class WDUIframeTest extends Base {
	
	
	public WebDriver driver;


	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
    @Test(priority=1)  // Testing IFrames
    public void handleIframe() throws InterruptedException
    {
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	WDUIFramePage wduifp = new WDUIFramePage(driver);	
    	wduifp.scrollPage();
		wdufp.getIFrameSection().click();
		driver.switchTo().window(getChildWindow()); 
        driver.switchTo().frame("frame");
    	wduifp.getNavBarProducts().click();
    	driver.switchTo().parentFrame();
    	wduifp.getNavTitle().click();
    	Assert.assertEquals("WebdriverUniversity.com (New Approach To Learning)", wduifp.getTitleNavBar());
    	
    	
    }
    @AfterTest
    public void quitDriver()
    {
    	driver.quit();
    }
    
	}



