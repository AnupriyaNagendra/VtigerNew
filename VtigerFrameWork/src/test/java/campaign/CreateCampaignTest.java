package campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM_Repo.CampaignCreatePage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ValidationPage;
import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.Property_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(generic_utilities.ListenerImplimentation.class)
public class CreateCampaignTest extends BaseClass 
{	
	//@Test(retryAnalyzer = generic_utilities.RetryAnalayser.class)
	@Test(groups = "SmokeTest")
	public void CreateCampaignTest() throws Throwable 
	{
		Property_Utility plib = new Property_Utility();
		//Launching Browser
		/*Property_Utility plib = new Property_Utility();
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
		}*/
		
		//WebDriver driver = new ChromeDriver();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.toMaximizeTheWindow(driver);
		wlib.waitForPageToLoad(driver);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Fetching the data from properties file
		/*String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");*/
		
		/*FileInputStream fis = new FileInputStream("./src/test/resources/properties_file.properties.txt");
		Properties property = new Properties();
		property.load(fis);
		String URL = property.getProperty("url");
		String USERNAME = property.getProperty("username");
		String PASSWORD = property.getProperty("password");*/
		
		//Login to Vtiger application
		/*driver.get(URL);
		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);*/
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		Home_Page home = new Home_Page(driver);
		home.moreLink();
		home.campaignsLinkText();
		//Assert.assertEquals(false, true);
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		
		CampaignCreatePage camPage = new CampaignCreatePage(driver);
		camPage.clickCampaign();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//Fetching the data from Excel file
		Excel_Utility elib = new Excel_Utility();
		//String orgName = elib.getExcelData("Campaign", 0, 0)+ranNum;
		String campaingnName = elib.getExcelUsingDataFormatter("Campaign", 0, 0);
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Campaign");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String campaingnName = cell.getStringCellValue();*/
		
		camPage.campaignName(campaingnName);
		camPage.saveButton();
		
		//driver.findElement(By.name("campaignname")).sendKeys(campaingnName);
		//driver.findElement(By.name("button")).click();
		
		//Validation
		ValidationPage validate = new ValidationPage(driver);
		String actData = validate.campValidate(driver, campaingnName);
		Assert.assertEquals(campaingnName, actData);
		/*String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actData.contains(campaingnName))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		//Logout
		//home.logout(driver);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		//driver.quit();
	}

}
