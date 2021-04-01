package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.WDUAutoCompletePage;
import pageObjects.WDUFrontPage;
import resources.Base;



public class WDUAutoCompleteTest extends Base {
	
	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
    @Test(priority=1)
    public void validateAutoCompleteTextfield() throws InterruptedException               // Verifying that text field works correctly
    {
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	WDUAutoCompletePage wduap  = new WDUAutoCompletePage(driver);
    	wduap.scrollPage();
		wdufp.getAutoCompleteSection().click();
		driver.switchTo().window(getChildWindow());
		wduap.sendKeyToTextInput();
        wduap.optionClick();
        Assert.assertEquals(wduap.textToSelect, wduap.getTextInput().getAttribute("value"));
        wduap.getSubmitButton().click();
    }

    @AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
  
    }