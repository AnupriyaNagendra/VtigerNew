package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.OrganizationCreatePage;
import generic_utilities.Java_Utility;
import generic_utilities.Property_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderVTiger 
{
	@Test(dataProvider = "dataProvider_test")
	public void companyDetails(String name, String phnum, String email) throws Throwable
	{
		//Launching Browser
		Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		//WebDriver driver = new ChromeDriver();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.toMaximizeTheWindow(driver);
		wlib.waitForPageToLoad(driver);
		
		//Fetching the data from properties file
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		//Login to Vtiger application
		driver.get(URL);
		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);
			
		Home_Page home = new Home_Page(driver);
		home.organizationsLinkText();
		OrganizationCreatePage orgPage = new OrganizationCreatePage(driver);
		orgPage.clickOrganization();
		
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(phnum);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] dataProvider_test() throws Throwable 
	{
		Java_Utility ran = new Java_Utility();
		ran.getRandomNum();
		Object[][] objArr= new Object[3][3];
		objArr[0][0] = "AAA"+ran;
		objArr[0][1] = "9845791838";
		objArr[0][2] = "jhkjshdfk@gmail.com";
		
		Thread.sleep(2000);
		objArr[1][0] = "BBB"+ran;
		objArr[1][1] = "8197237262";
		objArr[1][2] = "VFVHKJ@gmail.com";
		
		Thread.sleep(2000);
		objArr[2][0] = "CCC"+ran;
		objArr[2][1] = "9972016367";
		objArr[2][2] = "fjkfdk@gmail.com";
		
		return objArr;
		
	}

}
