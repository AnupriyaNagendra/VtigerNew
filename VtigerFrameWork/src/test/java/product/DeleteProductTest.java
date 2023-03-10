package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ProductCreatePage;
import POM_Repo.ValidationPage;
import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Property_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProductTest extends BaseClass {

	@Test(groups = "RegressionTest")
	public void DeleteProductTest() throws Throwable 
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

		//Fetching the data from properties file
		/*String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		/*FileInputStream fis = new FileInputStream("./src/test/resources/properties_file.properties.txt");
		Properties property = new Properties();
		property.load(fis);
		String URL = property.getProperty("url");
		String USERNAME = property.getProperty("username");
		String PASSWORD = property.getProperty("password");*/
		
		//Login to Vtiger application
		/*driver.get(URL);
		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
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
		//String orgName = elib.getExcelData("Product", 0, 0)+ranNum;
		String prdName = elib.getExcelUsingDataFormatter("Product", 0, 0);
	
		/*FileInputStream fes = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String prdName = cell.getStringCellValue()+ranNum;*/
		
		proPage.productName(prdName);
		proPage.saveButton();
		//Validation
		ValidationPage validate = new ValidationPage(driver);
		String actData = validate.productValidate(driver, prdName);
		Assert.assertEquals(prdName, actData);
		/*String actData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(actData.contains(prdName))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		
		proPage.deleteButton();
		//driver.findElement(By.name("productname")).sendKeys(prdName);
		//driver.findElement(By.name("button")).click();
		//driver.findElement(By.name("Delete")).click();
		Thread.sleep(1000);
		
		//Handling alert popup
		wlib.switchToAlertAndAccept(driver);
		//driver.switchTo().alert().accept();
		
		//Logout
		//home.logout(driver);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		//driver.quit();
	}

}
