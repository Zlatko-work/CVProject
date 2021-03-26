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
import pageObjects.WDUButtonClicksPage;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUFrontPage;
import pageObjects.WDUToDoListPage;
import resources.Base;



public class WDUToDoListTest extends Base {
	
	public WebDriver driver;

	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void addItemInToDoList() throws InterruptedException
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)");
		WDUToDoListPage wl = new WDUToDoListPage(driver);
		wdufp.getToDoListSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        Actions actions = new Actions(driver);
		actions.moveToElement(wl.getAddNewToDo()).click().sendKeys("Go home").sendKeys(Keys.ENTER).build().perform();
		String listItem = wl.getAddedItem().getText();
		Assert.assertEquals(listItem, "Go home");
        
	}
	
	@Test(priority=2)
	public void deleteItemFromToDoList()
	{
		WDUToDoListPage wl = new WDUToDoListPage(driver);
		wl.getDeleteItemButton().click();
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='container']/ul/li[4]")));
		List<WebElement> listItemsCount = driver.findElements(By.xpath("//div/ul/li"));
		int listCount = listItemsCount.size();
		Assert.assertEquals(listCount, 3);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	}



