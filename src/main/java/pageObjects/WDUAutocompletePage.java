package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUAutocompletePage {

	public WebDriver driver;
	
	By textInput = By.id("myInput");
	By options = By.cssSelector("div[id='myInputautocomplete-list'] div");
    By submitButton = By.id("submit-button");
	
	public WDUAutocompletePage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getTextInput()
	{
		return driver.findElement(textInput);
	}
	
	public WebElement getOptions()
	{
		return driver.findElement(options);
	}

	public WebElement getSubmitButton()
	{
		return driver.findElement(submitButton);
	}
	
}
