package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
