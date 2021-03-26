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
import pageObjects.WDUAutocompletePage;
import pageObjects.WDUButtonClicksPage;
import pageObjects.WDUContactUsPage;
import pageObjects.WDUFrontPage;
import pageObjects.WDUIFramePage;
import pageObjects.WDUToDoListPage;
import resources.Base;



public class WDUAutocompleteTest extends Base {
	
	public WebDriver driver;

	@BeforeTest

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("webdriveruniversity"));
		driver.manage().window().maximize();
	}
	
    @Test(priority=1)
    public void validateAutoCompleteTextfield() throws InterruptedException
    {
    	WDUFrontPage wdufp = new WDUFrontPage(driver);
    	WDUAutocompletePage wduap  = new WDUAutocompletePage(driver);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4200)");
		wdufp.getAutoCompleteSection().click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId); 
        wduap.getTextInput().sendKeys("A");
        String textToSelect = "Apple";
        List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));
        boolean wrongText = true;
        for(WebElement option : optionsToSelect){
            if(option.getText().equals(textToSelect)) {
                option.click();
                wrongText = false;
                break;      
            }
            
        else {
        	Assert.assertEquals(wrongText, true);
        }
           
        }
        
        wduap.getSubmitButton().click();
        Thread.sleep(2000);
        
        }
    @AfterTest
	public void tearDown()
	{
		driver.quit();
	}
  
    }
    



