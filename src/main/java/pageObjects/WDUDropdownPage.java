package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUDropdownPage {

	public WebDriver driver;
	
	By addItemButton = By.cssSelector("*[id='plus-icon']");
	By staticDropdownOne = By.cssSelector("#dropdowm-menu-1");
	By staticDropdownTwo = By.cssSelector("#dropdowm-menu-2");
	By staticDropdownThree = By.cssSelector("#dropdowm-menu-3");
	By checkboxOptionOne = By.xpath("//div[@id='checkboxes']/label[1]/input");
	By checkboxOptionTwo = By.xpath("//div[@id='checkboxes']/label[2]/input");
	By checkboxOptionThree = By.xpath("//div[@id='checkboxes']/label[3]/input");
	By checkboxOptionFour = By.xpath("//div[@id='checkboxes']/label[4]/input");
	By radioButtonGreen = By.cssSelector("input[value='green']");
	By radioButtonBlue = By.cssSelector("input[value='blue']");
	By radioButtonYellow = By.cssSelector("input[value='yellow']");
	By radioButtonOrange = By.cssSelector("input[value='orange']");
	By radioButtonPurple = By.cssSelector("input[value='purple']");
	By disabledButton = By.cssSelector("input[value='cabbage']");
	
	public WDUDropdownPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getAddItemButton()
	{
		return driver.findElement(addItemButton);
	}
	

	public WebElement getStaticDropdownOne()
	{
		return driver.findElement(staticDropdownOne);
	}
	
	public WebElement getStaticDropdownTwo()
	{
		return driver.findElement(staticDropdownTwo);
	}
	
	public WebElement getStaticDropdownThree()
	{
		return driver.findElement(staticDropdownThree);
	}
	
	public WebElement getCheckboxOptionOne()
	{
		return driver.findElement(checkboxOptionOne);
	}
	
	public WebElement getCheckboxOptionTwo()
	{
		return driver.findElement(checkboxOptionTwo);
	}
	
	public WebElement getCheckboxOptionThree()
	{
		return driver.findElement(checkboxOptionThree);
	}
	
	public WebElement getCheckboxOptionFour()
	{
		return driver.findElement(checkboxOptionFour);
	}
	
	public WebElement getRadioButtonGreen()
	{
		return driver.findElement(radioButtonGreen);
	}
	
	public WebElement getRadioButtonBlue()
	{
		return driver.findElement(radioButtonBlue);
	}
	
	public WebElement getRadioButtonYellow()
	{
		return driver.findElement(radioButtonYellow);
	}
	
	public WebElement getRadioButtonOrange()
	{
		return driver.findElement(radioButtonOrange);
	}
	
	public WebElement getRadioButtonPurple()
	{
		return driver.findElement(radioButtonPurple);
	}
	
	public WebElement getDisabledButton()
	{
		return driver.findElement(disabledButton);
	}
}
