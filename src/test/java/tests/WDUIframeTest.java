package tests;

import java.util.List;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUActionsPage;
import pageObjects.WDUButtonClicksPage;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUFrontPage;
import pageObjects.WDUIFramePage;
import pageObjects.WDUToDoListPage;
import resources.Base;



public class WDUIframeTest extends Base {
	
	public WebDriver driver;

	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
    @Test(priority=1)
    public void handleIframe() throws InterruptedException
    {
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	WDUIFramePage wduifp = new WDUIFramePage(driver);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,3300)");
		wdufp.getIFrameSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);  
        driver.switchTo().frame("frame");
        Thread.sleep(1500);
    	wduifp.getNavBarProducts().click();
    	driver.switchTo().parentFrame();
    	Thread.sleep(1500);
    	wduifp.getNavTitle().click();
    	
    	
    }
    @AfterTest
    public void tearDown()
    {
    	driver.quit();
    }
    
	}



