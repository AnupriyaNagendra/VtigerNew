package campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Repo.CampaignCreatePage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ProductCreatePage;
import POM_Repo.SwitchingWindowPage;
import POM_Repo.ValidationPage;
import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Property_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups = "SmokeTest, RegressionTest")
	public void CreateCampaignWithProductTest() throws Throwable 
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
		home.productsLinkText();
		
		//driver.findElement(By.linkText("Products")).click();
		ProductCreatePage proPage = new ProductCreatePage(driver);
		proPage.clickProduct();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Random class to avoid duplicate
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		//Fetching the data from Excel file
		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0)+ranNum;
		//String prdName = elib.getExcelUsingDataFormatter("Product", 0, 0);
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheetName = book.getSheet("Product");
		Row rowNum = sheetName.getRow(0);
		Cell cellNum = rowNum.getCell(0);
		String prdName = cellNum.getStringCellValue()+ranNum;*/
		
		proPage.productName(prdName);
		proPage.saveButton();
		//driver.findElement(By.name("productname")).sendKeys(prdName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		home.moreLink();
		home.campaignsLinkText();
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		CampaignCreatePage camPage = new CampaignCreatePage(driver);
		camPage.clickCampaign();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//Fetching the data from Excel file
		String campaignName = elib.getExcelData("Campaign", 0, 0)+ranNum;
		//String campaignName = elib.getExcelUsingDataFormatter("Campaign", 0, 0);
				
		/*FileInputStream fas = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book1 = WorkbookFactory.create(fas);
		Sheet sheetName1 = book1.getSheet("Campaign");
		Row rowNum1 = sheetName1.getRow(0);
		Cell cellNum1 = rowNum1.getCell(0);
		String campaignName1 = cellNum1.getStringCellValue()+ranNum;*/
		
		camPage.campaignName(campaignName);
		//camPage.saveButton();
		//driver.findElement(By.name("campaignname")).sendKeys(campaignName1);
		camPage.productPlusButton();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//Switching window
		wlib.switchWindow(driver, "Products&action");
		
		/*Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if(title.contains("Products&action"))
			{
				break;
			}
		}*/
		SwitchingWindowPage sPage = new SwitchingWindowPage(driver);
		sPage.searchTextField(prdName);
		sPage.clickSearchButton();
		//driver.findElement(By.name("search_text")).sendKeys(prdName);
		//driver.findElement(By.xpath("//input[@name='search']")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='Phone946']")).click();
		driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
		Thread.sleep(2000);
		//Switching window
		wlib.switchWindow(driver, "Campaigns&action");
		
		/*Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> it1 = allId1.iterator();
		while(it1.hasNext())
		{
			String wid1 = it1.next();
			driver.switchTo().window(wid1);
			String title1 = driver.getTitle();
			if(title1.contains("Campaigns&action"))
			{
				break;
			}
		}*/
		
		camPage.saveButton();
		//driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		
		//Validation
		ValidationPage validate = new ValidationPage(driver);
		String actData = validate.campWithProductValidate(driver, campaignName);
		Assert.assertEquals(campaignName, actData);
		/*String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actData.contains(campaignName))
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
