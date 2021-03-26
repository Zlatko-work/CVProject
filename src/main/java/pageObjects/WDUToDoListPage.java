package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUToDoListPage {

	public WebDriver driver;
	
	By addItemButton = By.cssSelector("*[id='plus-icon']");
	By addNewToDo = By.cssSelector("*[type='text']");
	By addedItem = By.xpath("//div[@id='container']/ul/li[4]");
    By deleteItemButton = By.xpath("//div[@id='container']/ul/li[4]/span/i");
	
	
	public WDUToDoListPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getAddItemButton()
	{
		return driver.findElement(addItemButton);
	}
	
	public WebElement getAddNewToDo()
	{
		return driver.findElement(addNewToDo);
	}
	
	public WebElement getAddedItem()
	{
		return driver.findElement(addedItem);
	}
	
	public WebElement getDeleteItemButton()
	{
		return driver.findElement(deleteItemButton);
	}
	
	

	
}
