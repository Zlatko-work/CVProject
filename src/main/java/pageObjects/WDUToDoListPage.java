package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	// Method to scroll page
	
	public void scrollPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)");
	}

	// Method to get the text of the item added in to do list
	
	public String getListItem()
	{
		String listItem = getAddedItem().getText();
		return listItem;
	}
	
	// Explicit wait
	
	public void getWebDriverWaitToDoList()
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='container']/ul/li[4]")));	
	}
	
	// Method to calculate the items in the list
	public int getCountedList() {
		List<WebElement> listItemsCount = driver.findElements(By.xpath("//div/ul/li"));
		int listCount = listItemsCount.size();
		return listCount;
	}
	
	
	
}
