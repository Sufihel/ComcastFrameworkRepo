package PractiseDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ReadDataFromDatabaseUsingJDBC {

	public static void main(String[] args) throws Throwable {
		Connection connection = null;
		try {
			// Step 1: load/ register the database driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// Step 2: Connect to datbase
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projects", "root", "root");

			// Step 3: Create SQL statement
			Statement statement = connection.createStatement();
			// Step 4: Execute select query and get result
			ResultSet resultSet = statement.executeQuery("select * from project");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t"
						+ resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5));
			}
		} catch (Exception e) {
			System.out.println("Handle Exception");
		} finally {
			// Step 5: Close the connection conn

			connection.close();
		}
	}
}
