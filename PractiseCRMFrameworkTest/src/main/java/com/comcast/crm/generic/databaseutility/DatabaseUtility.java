package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection connection;

	public void getDbConnection(String url, String username, String password)throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}

	}
	public void getConnection()throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projects", "root", "root");
		} catch (Exception e) {
		}

	}

	public void closeDbConnection() throws SQLException {
		try {
			connection.close();
		} catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String Query) throws SQLException {
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(Query);
		} catch (Exception e) {
		}
		return resultSet;
	}
	public int executeNonSelectQuery(String Query) throws SQLException {
		int result=0;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeUpdate(Query);
		} catch (Exception e) {
		}
		return result;
	}
}
