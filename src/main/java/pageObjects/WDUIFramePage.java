package pageObjects;

import org.openqa.selenium.By;
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
	
	
}
