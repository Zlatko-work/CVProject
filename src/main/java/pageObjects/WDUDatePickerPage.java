package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	// Method for scrolling page
	
   public void scrollingPage()
   {
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4200)");
   }
	
   // Method for checking the current date
   
   public String selectedDate()
   {
	  getDatePickerInput().click();
	  String currentMonthAndYear = getMonthYearPicker().getText();
	  return currentMonthAndYear;
   }
   
	
	// Choosing the date
	
	public String monthAndYear = "March 1994";
	public String day = "21";
	
	public void chooseMonthAndYear()
	{
		while (!getMonthYearPicker().getText().contains(monthAndYear)) {      // Creating a simple logic to choose a month and year
			   getPrevButton().click();
			  }
	}

	
	public void chooseDay()
	{
		int count = getDayPicker().size();

		  for (int i = 0; i < count; i++) {                                     // Creating a simple logic to choose a day
		   String text = getDayPicker().get(i).getText();
		   if (text.equalsIgnoreCase(day)) {
		    getDayPicker().get(i).click();
		    break;
		    
	}		
		  
}
	}
}
