package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public String pathOfFile = "C:\\Users\\Zlatko\\Desktop\\windows.jpg";
	
	// Method to get alert text
	
	public String getAlertText()
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	
	// Scrolling page method
	
	public void scrollingPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4200)");
	}
	
	// Explicit wait
	
	public void getWebDriverWaitFileUpload()
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-button")));
	}
}
