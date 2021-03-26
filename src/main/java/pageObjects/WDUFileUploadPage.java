package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUFileUploadPage {

	public WebDriver driver;
	
	By fileUploadButton = By.id("myFile");
	By submitButton = By.id("submit-button");

	
	
	public WDUFileUploadPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getFileUploadButton()
	{
		return driver.findElement(fileUploadButton);
	}
	

	public WebElement getSubmitButton()
	{
		return driver.findElement(submitButton);
	}
	
}
