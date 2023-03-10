package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage
{
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusImage;
	
	@FindBy(name = "accountname")
	private WebElement OrgName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getPlusImage() {
		return plusImage;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logic for +image
	public void clickOrganization()
	{
		plusImage.click();
	}
	
	//orgName
	public void organizationName(String orgName)
	{
		OrgName.sendKeys(orgName);
	}
	
	//Save
	public void saveButton()
	{
		saveButton.click();
	}
}
