package Practice;

import org.testng.annotations.Test;

public class TestNGPractice 
{
	//method 1
	@Test
	public void createContact()
	{
		System.out.println("Created");
		//int[] arr={1,2,3};
		//System.out.println(arr[5]);
	}
	
	@Test(invocationCount = 2)
	//Method 2
	public void modifyContact()
	{
		System.out.println("Modified");
	}
	
	@Test(dependsOnMethods = "createContact")
	//Method 3
	public void deleteContact()
	{
		System.out.println("Deleted");
	}

}
