package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriver_Utility;

public class Home_Page 
{
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLinkText;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLinkText;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLinkText;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLinkText;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLinkText;

	//getter methods
	public WebElement getCampaignsLinkText() 
	{
		return campaignsLinkText;
	}

	public WebElement getMoreLink() 
	{
		return moreLink;
	}

	public WebElement getProductsLinkText()
	{
		return productsLinkText;
	}

	public WebElement getOrganizationsLinkText() 
	{
		return organizationsLinkText;
	}

	public WebElement getContactsLinkText() 
	{
		return contactsLinkText;
	}

	public WebElement getSignOutImage() 
	{
		return signOutImage;
	}

	public WebElement getSignOutLinkText()
	{
		return signOutLinkText;
	}
	
	//Business Logic Campaign
	public void campaignsLinkText()
	{
		campaignsLinkText.click();
	}
	
	//Business Logic for more
	public void moreLink()
	{
		moreLink.click();
	}
	
	//Business Logic for Products
	public void productsLinkText()
	{
		productsLinkText.click();
	}
	
	//Business Logic for Organizations
	public void organizationsLinkText()
	{
		organizationsLinkText.click();
	}
	
	//Business Logic for Contacts
	public void contactsLinkText()
	{
		contactsLinkText.click();
	}
	
	//Business Logic for SignOut
	public void logout(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.moveToElement(signOutImage).perform();
		signOutLinkText.click();
	}
}
