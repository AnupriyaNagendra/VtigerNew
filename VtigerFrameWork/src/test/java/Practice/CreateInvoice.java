package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Repo.Login_Page;

public class CreateInvoice {

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
		
		//Login to Vtiger application
		driver.get(URL);
		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.id("more")).click();
		driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
	}
}
