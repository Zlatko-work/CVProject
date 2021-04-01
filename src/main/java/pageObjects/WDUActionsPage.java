package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDUActionsPage {

	public WebDriver driver;
	
	By draggableBox = By.cssSelector("*[id='draggable'] p");
	By droppableBox = By.cssSelector("*[id='droppable'] p");
	By doubleClickBox = By.cssSelector("div[id='double-click']");
    By hoverOverFirstElement = By.cssSelector("div[class='dropdown hover']");
	By hoverFirstLink = By.cssSelector("div[class='dropdown hover'] a");
	By hoverOverThirdElement = By.xpath("//div[@id='div-hover']/div[3]");
	By hoverThirdElementSecondLink = By.xpath("//div[@id='div-hover']/div[3]/div/a[2]");
	
	public WDUActionsPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getDraggableBox()
	{
		return driver.findElement(draggableBox);
	}
	
	public WebElement getDroppableBox()
	{
		return driver.findElement(droppableBox);
	}
	
	public WebElement getDoubleClickBox()
	{
		return driver.findElement(doubleClickBox);
	}
	
	public WebElement getHoverOverFirstElement()
	{
		return driver.findElement(hoverOverFirstElement);
	}

	public WebElement getHoverFirstLink()
	{
		return driver.findElement(hoverFirstLink);
	}
	
	public WebElement getHoverOverThirdElement()
	{
		return driver.findElement(hoverOverThirdElement);
	}
	
	public WebElement gethoverThirdElementSecondLink()
	{
		return driver.findElement(hoverThirdElementSecondLink);
	}
	
	// Explicit wait
	
	public void getWebDriverWaitActions()
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[id='draggable'] p")));
	}
	
	// Scroll page method
	
	public void scrollingPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2300)");
	}
	
	// Method to get the droppable box text
	
	public String getDroppableBoxText()
	{
		String droppableBoxText = getDroppableBox().getText();
		return droppableBoxText;
	}
	
	// Method to get double click box color
	
	public String getDoubleClickBoxColor()
	{
		String doubleClickBoxColor = getDoubleClickBox().getCssValue("background-color");
		return doubleClickBoxColor;
	}
	
	// Method to get alert text
	
	public String getAlertText()
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	// Method to get alert text from second link
	
	public String getAlertTextSecondLink()
	{
		String alertTextSecondLink = driver.switchTo().alert().getText();
		return alertTextSecondLink;
	}
	
}
