package tests;

import java.util.List;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import pageObjects.WDUToDoListPage;
import resources.Base;



public class WDUActionsTest extends Base {
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
    @Test(priority=1)
    public void verifyDragAndDrop() throws InterruptedException
    {
    	WDUActionsPage wduap = new WDUActionsPage(driver);
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2300)");
		wdufp.getActionSection().click();
        Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId); 
        Actions action = new Actions(driver);
        action.dragAndDrop(wduap.getDraggableBox(), wduap.getDroppableBox()).build().perform();
        String droppableBoxText = wduap.getDroppableBox().getText();
        Assert.assertEquals(droppableBoxText, "Dropped!");
    }
    @Test(priority=2)
    public void verifyDoubleClick()
    {
    	WDUActionsPage wduap = new WDUActionsPage(driver);
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	Actions action = new Actions(driver);
    	action.doubleClick(wduap.getDoubleClickBox()).perform();
    	String doubleClickBoxColor = wduap.getDoubleClickBox().getCssValue("background-color");
    	Assert.assertEquals("rgba(147, 203, 90, 1)", doubleClickBoxColor);	
    }
    
    @Test(priority=3)
    public void verifyHoverOver()
    {
    	WDUActionsPage wduap = new WDUActionsPage(driver);
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	Actions action = new Actions(driver);
    	action.moveToElement(wduap.getHoverOverFirstElement()).moveToElement(wduap.getHoverFirstLink()).click().build().perform();
    	String alertText = driver.switchTo().alert().getText();
    	Assert.assertEquals("Well done you clicked on the link!", alertText);
    	driver.switchTo().alert().accept();
    	action.moveToElement(wduap.getHoverOverThirdElement()).moveToElement(wduap.gethoverThirdElementSecondLink()).click().build().perform();
    	String alertTextSecondLink = driver.switchTo().alert().getText();
    	Assert.assertEquals("Well done you clicked on the link!", alertTextSecondLink);
    	driver.switchTo().alert().accept();
    	
    	 log.info("Action test successfully passed!");
    }
    @AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	}



