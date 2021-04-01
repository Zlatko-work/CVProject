package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUIFramePage {

	public WebDriver driver;
	
	By navBarProducts = By.xpath("//div[@class='container-fluid']/ul/li[2]");
	By navTitle = By.cssSelector("a[id='nav-title']");

	
	public WDUIFramePage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getNavBarProducts()
	{
		return driver.findElement(navBarProducts);
	}
	
	public WebElement getNavTitle()
	{
		return driver.findElement(navTitle);
	}
	
	// Method for scroll page
	
	public void scrollPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,3300)");
	}
	
	// Method to get the title of nav bar
	
	public String getTitleNavBar()
	{
		String titleNavBar = getNavTitle().getText();
		return titleNavBar;
	}
	
}
