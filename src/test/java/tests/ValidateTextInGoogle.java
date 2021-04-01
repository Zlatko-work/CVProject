package tests;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.GooglePage;
import pageObjects.GoogleSearchPage;
import resources.Base;

public class ValidateTextInGoogle extends Base {
	public WebDriver driver;
    public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("google"));
		driver.manage().window().maximize();
	}
	
	@Test // Validating if i would get the expected text result by searching in google
	
	public void GoogleSearchResults() throws IOException
	{
		
		GooglePage g = new GooglePage(driver);
		g.changeLanguage();
        g.getSearchLabel().sendKeys(g.name);
        g.getSearchButton().click();
        GoogleSearchPage gsp = new GoogleSearchPage(driver);
        Assert.assertEquals(gsp.getSearchResults(), gsp.textForValidation);
		
		    log.info("Google search result test successfully passed!");
	}
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
		
	}
	
	
	
}
