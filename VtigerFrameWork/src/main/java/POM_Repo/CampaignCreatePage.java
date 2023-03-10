package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreatePage 
{
	public CampaignCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement plusImage;
	
	@FindBy(name = "campaignname")
	private WebElement CampaingnName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement productPlusButton;
	
	public WebElement getPlusImage() {
		return plusImage;
	}

	public WebElement getCampaingnName() {
		return CampaingnName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getProductPlusButton() {
		return productPlusButton;
	}

	//Business logic for +image
	public void clickCampaign()
	{
		plusImage.click();
	}
		
	//campaingnName
	public void campaignName(String campaingnName)
	{
		CampaingnName.sendKeys(campaingnName);
	}
		
	//Save
	public void saveButton()
	{
		saveButton.click();
	}

	//Productplusbutton
	public void productPlusButton()
	{
		productPlusButton.click();
	}
}
