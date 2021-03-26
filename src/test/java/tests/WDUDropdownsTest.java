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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUButtonClicksPage;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUDropdownPage;
import pageObjects.WDUFrontPage;
import pageObjects.WDUToDoListPage;
import resources.Base;



public class WDUDropdownsTest extends Base {
	
	public WebDriver driver;
	

	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void validateDropdown() throws InterruptedException
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1600)");
		wdufp.getDropdownsSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        WDUDropdownPage ddp = new WDUDropdownPage(driver);
        Select dropdownOne = new Select(ddp.getStaticDropdownOne());
        Select dropdownTwo = new Select(ddp.getStaticDropdownTwo());
        Select dropdownThree = new Select(ddp.getStaticDropdownThree());
        dropdownOne.selectByVisibleText("C#");
        dropdownTwo.selectByIndex(2);
        String dropdownOneSelectedItem = dropdownOne.getFirstSelectedOption().getText();
        String dropdownTwoSelectedItem = dropdownTwo.getFirstSelectedOption().getText();
        String dropdownThreeSelectedItem = dropdownThree.getFirstSelectedOption().getText();
        Assert.assertEquals("C#", dropdownOneSelectedItem);
        Assert.assertEquals("TestNG", dropdownTwoSelectedItem);
        Assert.assertEquals("HTML", dropdownThreeSelectedItem);
	}
	
	@Test(priority=2)
	public void validateCheckboxes()
	{
		WDUDropdownPage ddp = new WDUDropdownPage(driver);
		ddp.getCheckboxOptionOne().click();
		ddp.getCheckboxOptionTwo().click();
		ddp.getCheckboxOptionThree().click();
		ddp.getCheckboxOptionFour().click();
		Assert.assertTrue(ddp.getCheckboxOptionOne().isSelected());
		Assert.assertTrue(ddp.getCheckboxOptionTwo().isSelected());
		Assert.assertFalse(ddp.getCheckboxOptionThree().isSelected());
		Assert.assertTrue(ddp.getCheckboxOptionFour().isSelected());
		
	}
	
	@Test(priority=3)
	
	public void validateRadioButtons()
	{
		WDUDropdownPage ddp = new WDUDropdownPage(driver);
		ddp.getRadioButtonGreen().click();
		Assert.assertTrue(ddp.getRadioButtonGreen().isSelected());
		ddp.getRadioButtonBlue().click();
		Assert.assertTrue(ddp.getRadioButtonBlue().isSelected());
		ddp.getRadioButtonOrange().click();
		Assert.assertTrue(ddp.getRadioButtonOrange().isSelected());
		ddp.getRadioButtonPurple().click();
		Assert.assertTrue(ddp.getRadioButtonPurple().isSelected());
		ddp.getRadioButtonYellow().click();
		Assert.assertTrue(ddp.getRadioButtonYellow().isSelected());
	}
	
	@Test(priority=4)
	public void validateDisabledButton()
	{
		WDUDropdownPage ddp = new WDUDropdownPage(driver);
		boolean actualValue = ddp.getDisabledButton().isEnabled();
		Assert.assertFalse(actualValue);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	}



