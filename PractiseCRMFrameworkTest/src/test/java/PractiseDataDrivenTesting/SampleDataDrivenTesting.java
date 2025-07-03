package PractiseDataDrivenTesting;

import java.io.FileInputStream;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(
				"‪C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\commondata.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String URL = properties.getProperty("url");
		String BROWSER = properties.getProperty("browser");
		String USERNAME = properties.getProperty("username");
		String USERPASSWORD = properties.getProperty("password");

		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(USERPASSWORD);

	}

}
