package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WDUFrontPage {

	public WebDriver driver;
	
	By contactUsSection = By.xpath("//a[@id='contact-us']");
	By loginPortalSection = By.xpath("//a[@id='login-portal']");
	By buttonClicksSection = By.xpath("//a[@id='button-clicks']");
	By toDoListSection = By.xpath("//a[@id='to-do-list']");
	By dropdownsSection = By.xpath("//a[@id='dropdown-checkboxes-radiobuttons']");
	By actionSection = By.xpath("//a[@id='actions']");
	By iFrameSection = By.xpath("//a[@id='iframe']");
	By autocompleteSection = By.xpath("//a[@id='autocomplete-textfield']");
	By fileUploadSection = By.xpath("//a[@id='file-upload']");
	By datePickerSection = By.xpath("//a[@id='datepicker']");
	
	public WDUFrontPage (WebDriver driver)
    {
		this.driver=driver;
	}
	
	
	public WebElement getContactUsSection()
	{
		return driver.findElement(contactUsSection);
	}
	
	public WebElement getLoginPortalSection()
	{
		return driver.findElement(loginPortalSection);
	}
	
	public WebElement getButtonClickSection()
	{
		return driver.findElement(buttonClicksSection);
	}
	
	public WebElement getToDoListSection()
	{
		return driver.findElement(toDoListSection);
	}
	
	public WebElement getDropdownsSection()
	{
		return driver.findElement(dropdownsSection);
	}
	
	public WebElement getActionSection()
	{
		return driver.findElement(actionSection);
	}
	
	public WebElement getIFrameSection()
	{
		return driver.findElement(iFrameSection);
	}
	
	public WebElement getAutoCompleteSection()
	{
		return driver.findElement(autocompleteSection);
	}
	
	public WebElement getFileUploadSection()
	{
		return driver.findElement(fileUploadSection);
	}
	
	public WebElement getDatePickerSection()
	{
		return driver.findElement(datePickerSection);
	}
}
