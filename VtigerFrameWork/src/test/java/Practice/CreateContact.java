package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import generic_utilities.Excel_Utility;
import generic_utilities.Property_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws Throwable 
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
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Fetching the data from properties file
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		/*FileInputStream fis = new FileInputStream("./src/test/resources/properties_file.properties.txt");
		Properties property = new Properties();
		property.load(fis);
		String URL = property.getProperty("url");
		String USERNAME = property.getProperty("username");
		String PASSWORD = property.getProperty("password");*/
		
		//Login to Vtiger application
		driver.get(URL);
		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);
				
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		Home_Page home = new Home_Page(driver);
		home.contactsLinkText();
		//driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Fetching the data from Excel file
		Excel_Utility elib = new Excel_Utility();
		//String orgName = elib.getExcelData("Contact", 0, 0)+ranNum;
		String firstName = elib.getExcelUsingDataFormatter("Contact", 0, 0);
		String lastName = elib.getExcelUsingDataFormatter("Contact", 1, 0);
		String mobileNum = elib.getExcelUsingDataFormatter("Contact", 2, 0);
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Contact");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String firstName = cell.getStringCellValue();*/
		
		/*Sheet sheet1 = book.getSheet("Contact");
		Row row1 = sheet.getRow(0);
		Cell cell1 = row.getCell(1);
		String lastName = cell.getStringCellValue();*/
		
		/*Sheet sheet2 = book.getSheet("Contact");
		Row row2 = sheet.getRow(0);
		Cell cell2 = row.getCell(2);
		String mobileNum = cell.getStringCellValue();*/
		
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("mobile")).sendKeys(mobileNum);
		driver.findElement(By.name("button")).click();
		
		//Logout
		home.logout(driver);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
	}

}
