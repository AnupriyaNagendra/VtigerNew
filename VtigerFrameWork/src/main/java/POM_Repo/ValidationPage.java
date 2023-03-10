package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage 
{
	public ValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement validate;

	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement validateCampaign;
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement validateCamWithProduct;
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement validateProduct;
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement validateDeleteProduct;
	
	public WebElement getValidationName() 
	{
		return validate;
	}
	
	public WebElement getValidateCampaign() 
	{
		return validateCampaign;
	}

	public WebElement getValidateCamWithProduct() 
	{
		return validateCamWithProduct;
	}

	public WebElement getValidateProduct() 
	{
		return validateProduct;
	}

	public WebElement getValidateDeleteProduct() 
	{
		return validateDeleteProduct;
	}

	//Business logic for Organization validation
	public String orgValidate(WebDriver driver, String actData)
	{
		String data = validate.getText();
		return data;
	}
	
	//Business logic for Campaign validation
	public String campValidate(WebDriver driver, String actData)
	{
		String data = validateCampaign.getText();
		return data;
	}
	
	//Business logic for CampaignWithProduct validation
	public String campWithProductValidate(WebDriver driver, String actData)
	{
		String data = validateCamWithProduct.getText();
		return data;
	}
	
	//Business logic for Product validation
	public String productValidate(WebDriver driver, String actData)
	{
		String data = validateProduct.getText();
		return data;
	}
	
	//Business logic for Product(Delete) validation
	public String deleteProductValidate(WebDriver driver, String actData)
	{
		String data = validateDeleteProduct.getText();
		return data;
	}
}
