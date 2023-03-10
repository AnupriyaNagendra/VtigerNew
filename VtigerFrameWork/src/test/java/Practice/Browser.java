package Practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream("./src/test/resources/properties_file.properties.txt");
		Properties property = new Properties();
		property.load(fis);
		String URL = property.getProperty("url");
		String USERNAME = property.getProperty("username");
		String PASSWORD = property.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		FileInputStream fes = new FileInputStream("./src/test/resources/Excel_File.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheetName = book.getSheet("Organization");
		Row rowNum = sheetName.getRow(0);
		Cell cellNum = rowNum.getCell(0);
		String orgName = cellNum.getStringCellValue();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("button")).click();
	}

}
