package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class WDUContactUsPage extends Base {

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
	
	
	// Explicit waits
	
	public void getWebDriverWaitContactUs()
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		w.until(ExpectedConditions.elementToBeClickable(firstName));
		w.until(ExpectedConditions.elementToBeClickable(lastName));
		w.until(ExpectedConditions.elementToBeClickable(email));
		w.until(ExpectedConditions.elementToBeClickable(resetButton));
		w.until(ExpectedConditions.elementToBeClickable(submitButton));
	}
	
	public void getWebDriverWaitContactUsResetButton()
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.textToBePresentInElementValue(By.name("first_name"), ""));
	}
	
	// Method to get validation text
	
	public String getFinalText()
	{
	   String finalText = getValidationText().getText();
	   return finalText;
	}
	
	// Method to get invalid text
	
	public String getInvalidText()
	{
		String invalidEmailText = getInvalidEmailText().getText();
		return invalidEmailText;
	}
	
	// Method to send valid credentials
	public void sendValidCredentials()
	{
		getWebDriverWaitContactUs();
		getFirstName().sendKeys("Zlatko");
		getLastName().sendKeys("Cvetkoski");
		getEmail().sendKeys("Zlatko@gmail.com");
	}
	
	// Method to send valid credentials with comments plus
	public void sendValidCredentialsWithComment()
	{
		getFirstName().sendKeys("Zlatko");
		getLastName().sendKeys("Cvetkoski");
		getEmail().sendKeys("Zlatko@gmail.com");
		getComments().sendKeys("I would like to ask a question");	
	}
	
	// Method to send invalid credentials
	public void sendInvalidCredentials() throws InterruptedException
	{
		Thread.sleep(2000);
		getFirstName().sendKeys("Zlatko");
		getLastName().sendKeys("Cvetkoski");
		getEmail().sendKeys("Zlatko");
		getComments().sendKeys("I would like to ask a question");
	}
	
	
}
