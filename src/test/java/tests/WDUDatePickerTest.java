package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUButtonClicksPage;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUDatePickerPage;
import pageObjects.WDUFileUploadPage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUDatePickerTest extends Base {

	public WebDriver driver;
	
	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void chooseDate() throws InterruptedException 
	{
		WDUFrontPage wdufp = new WDUFrontPage(driver);
		WDUDatePickerPage wdudpp = new WDUDatePickerPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4200)");
		wdufp.getDatePickerSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
		wdudpp.getDatePickerInput().click();
		while (!wdudpp.getMonthYearPicker().getText().contains("March 1994")) {
			   wdudpp.getPrevButton().click();
			  }
		List<WebElement> dates = wdudpp.getDayPicker();
		int count = wdudpp.getDayPicker().size();

		  for (int i = 0; i < count; i++) {
		   String text = wdudpp.getDayPicker().get(i).getText();
		   if (text.equalsIgnoreCase("21")) {
		    wdudpp.getDayPicker().get(i).click();
		    break;
	}		   
}
		  
		 
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}


