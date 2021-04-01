package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

	public WebDriver driver;
	
	By searchLabel = By.name("q");
	By searchButton = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]");
	By languageButton = By.xpath("//div[@id='SIvCob']/a");
	
	
    public GooglePage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	public WebElement getSearchLabel()
	{
		return driver.findElement(searchLabel);
	}
	
	public WebElement getSearchButton()
	{
		return driver.findElement(searchButton);
	}
	
	public WebElement getLanguageButton()
	{
		return driver.findElement(languageButton);
	}
	
	// Method to get the page language
	
	public String getPageLanguage()
	{
		String pageLanguage = (getLanguageButton().getText());
		return pageLanguage;
	}
	
	// Method to change language if its not english
	
	public void changeLanguage()
	{
		if(getPageLanguage().equals("English")) 
		{
           getLanguageButton().click();
		} 
	}
	public String name = "Zlatko";
}
