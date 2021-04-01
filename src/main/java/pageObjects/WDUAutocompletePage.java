package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDUAutoCompletePage {

	public WebDriver driver;
	
	By textInput = By.id("myInput");
	By options = By.cssSelector("div[id='myInputautocomplete-list'] div");
    By submitButton = By.id("submit-button");
	
	public WDUAutoCompletePage (WebDriver driver)
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
	
	// Method to scroll page
	public void scrollPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4200)");
	}
	
	// Explicit wait
	
	public void getWebDriverWaitAutoComplete()
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.elementToBeClickable(textInput));
		w.until(ExpectedConditions.elementToBeClickable(submitButton));
	}
	
	// Strings to select which text to send and get. And a list of options that we can select.
	
	public String someKey = "A";
	public String textToSelect = "Apple";
	
	// Method to click the right option
	
	public void optionClick()
	{
		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));
	for(WebElement option : optionsToSelect){
        if(option.getText().equals(textToSelect)) {
            option.click();
            break;      
        }
	}
	}
	
	// Method to send keys to the text input
	public void sendKeyToTextInput() throws InterruptedException
	{
		Thread.sleep(2000);
		getTextInput().sendKeys(someKey);
	}
	
	
	
}
