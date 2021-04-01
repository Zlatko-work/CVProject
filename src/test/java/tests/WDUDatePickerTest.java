package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUDatePickerPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUDatePickerTest extends Base {

	public WebDriver driver;
	
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1) // Verifying that datePicker section works correctly
	public void chooseDate() throws InterruptedException 
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUDatePickerPage wdudpp = new WDUDatePickerPage(driver);
		wdudpp.scrollingPage();
		wdufp.getDatePickerSection().click();
		driver.switchTo().window(getChildWindow());
		wdudpp.getDatePickerInput().click();
		wdudpp.chooseMonthAndYear();
		wdudpp.chooseDay();
		wdudpp.selectedDate();
		Assert.assertEquals(wdudpp.selectedDate(), wdudpp.monthAndYear);
	}
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
}


