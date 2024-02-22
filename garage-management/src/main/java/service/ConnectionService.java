package service;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class ConnectionService {

	public Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/garage_management_db";
		String user = "root";
		String password = "root";
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;

	}
}
