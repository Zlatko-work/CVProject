package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUDropdownPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUDropdownsTest extends Base {
	
	public WebDriver driver;
	

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1) // Validating dropdown that works properly
	public void validateDropdown() throws InterruptedException
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUDropdownPage ddp = new WDUDropdownPage(driver);
		ddp.scrollPage();
		wdufp.getDropdownsSection().click();
		driver.switchTo().window(getChildWindow());
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
	
	@Test(priority=2) // Validating checkboxes that works properly
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
	
	@Test(priority=3) // Validating radio buttons that works properly
	
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
	
	@Test(priority=4) // Validating that button is disabled
	public void validateDisabledButton()
	{
		WDUDropdownPage ddp = new WDUDropdownPage(driver);
		boolean actualValue = ddp.getDisabledButton().isEnabled();
		Assert.assertFalse(actualValue);
	}
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
	}



