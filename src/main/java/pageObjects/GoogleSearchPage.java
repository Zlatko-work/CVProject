package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	public WebDriver driver;
	
	By textResult = By.xpath("//div[@id='rso']/div[1]/div[1]/div[1]/div[2]/span[1]");
	
	
	 public GoogleSearchPage (WebDriver driver)
	    {
			this.driver=driver;
		}
	 
	 public WebElement textResult()
	 {
		 return driver.findElement(textResult);
	 }
	 
	 //Method to get search result
	 public String getSearchResults()
	 {
		 String searchResults = textResult().getText();
		 return searchResults;
	 }
	 
	 public String textForValidation = "Zlatko is a South Slavic masculine given name. The name is derived from the word zlato meaning gold with hypocoristic suffix -ko common in South Slavic ...";
}
