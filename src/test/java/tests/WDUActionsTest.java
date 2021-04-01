package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUActionsPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUActionsTest extends Base {
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	
    @Test(priority=1)  // Verifying that drag and drop works as expected
    public void verifyDragAndDrop() throws InterruptedException
    {
    	WDUActionsPage wduap = new WDUActionsPage(driver);
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	wduap.scrollingPage();
		wdufp.getActionSection().click();
        driver.switchTo().window(getChildWindow());
        wduap.getWebDriverWaitActions();
        Actions action = new Actions(driver);
        action.dragAndDrop(wduap.getDraggableBox(), wduap.getDroppableBox()).build().perform();
        Assert.assertEquals(wduap.getDroppableBoxText(), "Dropped!");
    }
    @Test(priority=2) // Verifying that double click works as expected
    public void verifyDoubleClick()
    {
    	WDUActionsPage wduap = new WDUActionsPage(driver);
    	Actions action = new Actions(driver);
    	action.doubleClick(wduap.getDoubleClickBox()).perform();
    	Assert.assertEquals("rgba(147, 203, 90, 1)", wduap.getDoubleClickBoxColor());	
    }
    
    @Test(priority=3) // Verifying that hover over works as expected
    public void verifyHoverOver()
    {
    	WDUActionsPage wduap = new WDUActionsPage(driver);
    	Actions action = new Actions(driver);
    	action.moveToElement(wduap.getHoverOverFirstElement()).moveToElement(wduap.getHoverFirstLink()).click().build().perform();
    	Assert.assertEquals("Well done you clicked on the link!", wduap.getAlertText());
    	driver.switchTo().alert().accept();
    	action.moveToElement(wduap.getHoverOverThirdElement()).moveToElement(wduap.gethoverThirdElementSecondLink()).click().build().perform();
    	Assert.assertEquals("Well done you clicked on the link!", wduap.getAlertTextSecondLink());
    	driver.switchTo().alert().accept();
    	
    	 log.info("Action test successfully passed!");
    }
    @AfterTest()
	public void quitDriver()
	{
		driver.quit();
	}
	
	}



