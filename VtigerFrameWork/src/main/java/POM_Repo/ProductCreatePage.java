package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage 
{
	public ProductCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement plusImage;
	
	@FindBy(name = "productname")
	private WebElement ProductName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(name = "Delete")
	private WebElement deleteButton;
	
	public WebElement getPlusImage() {
		return plusImage;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	//Business logic for +image
	public void clickProduct()
	{
		plusImage.click();
	}
		
	//productName
	public void productName(String productName)
	{
		ProductName.sendKeys(productName);
	}
		
	//Save
	public void saveButton()
	{
		saveButton.click();
	}

	//Delete
	public void deleteButton()
	{
		deleteButton.click();
	}

}
