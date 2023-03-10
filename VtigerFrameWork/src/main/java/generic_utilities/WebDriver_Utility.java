package generic_utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility 
{
	/**
	 * Used to switch to any window based on window title
	 * @param driver
	 * @param PartialWindowTitle
	 */
	public void switchWindow(WebDriver driver, String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if(title.contains(PartialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * Used to switch alert window and accept(click on ok button)
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * Used to maximize the window
	 * @param driver
	 */
	public void toMaximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}
