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

	public void tearUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("google"));
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void GoogleSearchResults() throws IOException
	{
		
		GooglePage g = new GooglePage(driver);
		String pageLanguage = (g.getLanguageButton().getText());
		
		if(pageLanguage.equals("English")) 
		{
            g.getLanguageButton().click();
		} 
			g.getSearchLabel().sendKeys("Zlatko");
		    g.getSearchButton().click();
		    GoogleSearchPage gsp = new GoogleSearchPage(driver);
		    String searchResults = gsp.textResult().getText();
		    Assert.assertEquals(searchResults, "Zlatko is a South Slavic masculine given name. The name is derived from the word zlato meaning gold with hypocoristic suffix -ko common in South Slavic ...");
		
	    
	    
		    log.info("Google search result test successfully passed!");
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
	
}
