package generic_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentation implements ITestListener 
{

	public void onTestFailure(ITestResult result) 
	{
		String testData = result.getMethod().getMethodName();
		System.out.println("-----------execute-----------");
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src= edriver.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(src,new File("./Screenshot"+testData+".png"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

}
