package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUContactUsPage {

	public WebDriver driver;
	
	By firstName = By.name("first_name");
	By lastName = By.name("last_name");
	By email = By.name("email");
	By comments = By.name("message");
	By resetButton = By.cssSelector("input[type='reset']");
	By submitButton = By.cssSelector("input[type='submit']");
	By validationText = By.xpath("//div[@id='contact_reply']/h1");
	By invalidEmailText = By.xpath("/html/body");
	
	public WDUContactUsPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	public WebElement getFirstName()
	{
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName()
	{
		return driver.findElement(lastName);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getComments()
	{
		return driver.findElement(comments);
	}
	
	public WebElement getResetButton()
	{
		return driver.findElement(resetButton);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submitButton);
	}
	
	public WebElement getValidationText()
	{
	     return driver.findElement(validationText);	
	}
	
	public WebElement getInvalidEmailText()
	{
		return driver.findElement(invalidEmailText);
	}
}
