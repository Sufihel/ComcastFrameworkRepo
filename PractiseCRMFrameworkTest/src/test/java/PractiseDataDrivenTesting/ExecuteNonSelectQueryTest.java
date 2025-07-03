package PractiseDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		// Step 1: load/ register the database driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		// Step 2: Connect to datbase
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projects", "root", "root");

		// Step 3: Create SQL statement
		Statement statement = connection.createStatement();
		// Step 4: Execute Nonselect query and get result
		int result = statement.executeUpdate("insert into project values('22','Facebook01','Active','Sufi','5');");
		System.out.println(result);
		// Step 5: Close the connection 
		connection.close();

	}

}
