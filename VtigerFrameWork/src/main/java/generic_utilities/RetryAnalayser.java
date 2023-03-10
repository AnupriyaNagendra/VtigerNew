package generic_utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalayser implements IRetryAnalyzer
{
	int count = 0;
	int retrylimit = 4;

	public boolean retry(ITestResult result) 
	{
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
