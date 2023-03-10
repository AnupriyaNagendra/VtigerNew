package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility 
{
	public String getKeyValue(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/properties_file.properties.txt");
		Properties property = new Properties();
		property.load(fis);
		String Value = property.getProperty(Key);
		return Value;
	}
}
