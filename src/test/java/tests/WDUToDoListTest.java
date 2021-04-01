package tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUFrontPage;
import pageObjects.WDUToDoListPage;
import resources.Base;



public class WDUToDoListTest extends Base {
	
	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1) // Testing if the To do list works properly by adding something in the list
	public void addItemInToDoList() throws InterruptedException
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUToDoListPage wl = new WDUToDoListPage(driver);
        wl.scrollPage();
		wdufp.getToDoListSection().click();
		driver.switchTo().window(getChildWindow());
        Actions actions = new Actions(driver);
		actions.moveToElement(wl.getAddNewToDo()).click().sendKeys("Go home").sendKeys(Keys.ENTER).build().perform();
		Assert.assertEquals(wl.getListItem(), "Go home");
        
	}
	
	@Test(priority=2) // Testing if the To do list works properly by deleting something in the list
	public void deleteItemFromToDoList()
	{
		WDUToDoListPage wl = new WDUToDoListPage(driver);
		wl.getDeleteItemButton().click();
		wl.getWebDriverWaitToDoList();
		Assert.assertEquals(wl.getCountedList(), 3);
		
	}
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
	
	
	
	
	}



