package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUDatePickerPage {

	public WebDriver driver;
	
	By datePickerInput = By.className("input-group-addon");
    By monthYearPicker = By.className("datepicker-switch");
	By prevButton = By.className("prev");
	By dayPicker = By.className("day");
	By currentDate = By.className("form-control");
	
	public WDUDatePickerPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getDatePickerInput()
	{
		return driver.findElement(datePickerInput);
	}
	
	public WebElement getMonthYearPicker()
	{
		return driver.findElement(monthYearPicker);
	}
	
	public WebElement getPrevButton()
	{
		return driver.findElement(prevButton);
	}
	
	public List<WebElement> getDayPicker()
	{
		return driver.findElements(dayPicker);
	}
	
	public WebElement getCurrentDate()
	{
		return driver.findElement(currentDate);
	}

}
