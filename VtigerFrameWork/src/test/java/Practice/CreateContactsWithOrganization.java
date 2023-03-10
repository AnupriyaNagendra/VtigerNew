package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import generic_utilities.Excel_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Property_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsWithOrganization {

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
		//String contactName = elib.getExcelData("Contact", 0, 0);
		String contactName = elib.getExcelUsingDataFormatter("Contact", 0, 0);
		
		/*FileInputStream fis1 = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheetName = book.getSheet("Contact");
		Row rowNum = sheetName.getRow(0);
		Cell cellNum = rowNum.getCell(0);
		String contactName = cellNum.getStringCellValue();*/
		
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		
		//Random class to avoid duplicate
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		
		//Fetching the data from Excel file
		String orgName = elib.getExcelData("Organization", 0, 0);
		//String orgName = elib.getExcelUsingDataFormatter("Organization", 0, 0);
		
		/*FileInputStream fis2 = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book1 = WorkbookFactory.create(fis2);
		Sheet sheetName1 = book1.getSheet("Organization");
		Row rowNum1 = sheetName1.getRow(0);
		Cell cellNum1 = rowNum1.getCell(0);
		String orgName = cellNum1.getStringCellValue();*/
		//driver.findElement(By.name("account_name")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//Switching window
		wlib.switchWindow(driver, "Accounts&action");
		
		/*Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if(title.contains("Accounts&action"))
			{
				break;
			}
		}*/
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		//driver.findElement(By.xpath("//a[text()='Qspiders']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
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
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Logout
		home.logout(driver);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
	}

}
