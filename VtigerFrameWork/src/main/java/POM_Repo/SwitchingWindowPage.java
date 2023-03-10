package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchingWindowPage 
{
	public SwitchingWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchButton;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	//Business logic for search text field
	public void searchTextField(String prdName)
	{
		searchTextField.sendKeys(prdName);
	}
			
	//search button
	public void clickSearchButton()
	{
		searchButton.click();
	}

}
