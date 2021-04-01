package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDUButtonClicksPage {

	public WebDriver driver;
	
	By buttonOne = By.cssSelector("span[id='button1']");
    By buttonTwo = By.cssSelector("span[id='button2']");
    By buttonThree = By.cssSelector("span[id='button3']");
    By closeButton = By.xpath("//div[@class='modal-footer']/button");
	
	
	public WDUButtonClicksPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getButtonOne()
	{
		return driver.findElement(buttonOne);
	}
	
	public WebElement getButtonTwo()
	{
		return driver.findElement(buttonTwo);
	}
	
	public WebElement getButtonThree()
	{
		return driver.findElement(buttonThree);
	}
	
	public WebElement getCloseButton()
	{
		return driver.findElement(closeButton);
	}

	
	// Explicit wait
	
	public void getWebDriverWaitButton()
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='button2']")));
	}
	
	// Method for scrolling page
	
	public void scrollPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
	}
}
