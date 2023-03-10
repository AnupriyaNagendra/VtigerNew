package organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Repo.Home_Page;
import POM_Repo.OrganizationCreatePage;
import POM_Repo.ValidationPage;
import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Property_Utility;
import generic_utilities.WebDriver_Utility;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "RegressionTest")
	public void createOrganizationTest() throws Throwable
	{
		Property_Utility plib = new Property_Utility();
		//Launching Browser
		/*
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
		home.organizationsLinkText();
		//driver.findElement(By.linkText("Organizations")).click();
		OrganizationCreatePage orgPage = new OrganizationCreatePage(driver);
		orgPage.clickOrganization();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Random class to avoid duplicate
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		//Fetching the data from Excel file
		Excel_Utility elib = new Excel_Utility();
		//String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
		String orgName = elib.getExcelUsingDataFormatter("Organization", 0, 0)+ranNum;;
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheetName = book.getSheet("Organization");
		Row rowNum = sheetName.getRow(0);
		Cell cellNum = rowNum.getCell(0);
		String orgName = cellNum.getStringCellValue()+ranNum;*/
		
		orgPage.organizationName(orgName);
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		//driver.findElement(By.name("button")).click();
		orgPage.saveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//Validation
		//String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		ValidationPage validate = new ValidationPage(driver);
		String actData = validate.orgValidate(driver, orgName);
		//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		Assert.assertEquals(orgName, actData);
		/*if(actData.contains(orgName))
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

/*	@Test
	public void m1()
	{
		System.out.println("m1 running");
	}*/
}
