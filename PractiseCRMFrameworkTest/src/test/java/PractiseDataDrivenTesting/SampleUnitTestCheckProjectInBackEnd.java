package PractiseDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.jdbc.Driver;
import junit.framework.Assert;

public class SampleUnitTestCheckProjectInBackEnd {
	@Test
	public void projectCheckTest() throws Throwable {
		String expectedProjectName = "Facebook";
		boolean flag = false;
		//Step 1: load/register the database driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// Step 2: Connect to datbase
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projects", "root", "root");

		// Step 3: Create SQL statement
		Statement statement = connection.createStatement();
		
		// Step 4: Execute select query and get result
		ResultSet resultSet = statement.executeQuery("select * from project");
		while (resultSet.next()) {
			String actualprojectname = resultSet.getString(2);
			if (expectedProjectName.equalsIgnoreCase(actualprojectname)) {
				flag = true;
				System.out.println(expectedProjectName + " is available=== Pass");
			}
		}
		if (flag == false) {
			System.out.println(expectedProjectName + " is not available=== Failed");
			Assert.fail();
		}
		// Step 5: Close the connection conn
		connection.close();
	}
}
