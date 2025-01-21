package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadingConfigValues {

	Properties p;

	public ReadingConfigValues(){

	// loading properties file with file location
	File s = new File("./Configuration/config.properties");

	try
	{

		// getting the key value pair
		FileInputStream fileInputStream = new FileInputStream(s);
		p = new Properties();
		p.load(fileInputStream);
	}

	catch(
	Exception e)
	{
		System.out.println("Exception encountered: " + e);
	}
	}
	public String getURL() {

		// get URL from .properties file
		String url = p.getProperty("baseUrl");
		return url;
	}

}
