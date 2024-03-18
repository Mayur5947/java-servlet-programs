package servlet_jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class personCrud {
	
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "root");
		
		return connection;
	}

	public void savePerson(person person) throws SQLException, ClassNotFoundException, IOException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO PERSON   VALUES (? ,? ,? , ? , ?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setString(3, person.getEmail());
		preparedStatement.setLong(4, person.getPhone());
		preparedStatement.setString(5, person.getPassword());
		int a = preparedStatement.executeUpdate();

		connection.close();

	}
	
	public void updatePerson(person person) throws SQLException, ClassNotFoundException, IOException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE PERSON SET NAME=? ,EMAIL=? , PHONE=? , PASSWORD=? WHERE ID = ?");
		
		preparedStatement.setString(1, person.getName());
		preparedStatement.setString(2, person.getEmail());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getPassword());
		preparedStatement.setInt(5, person.getId());
		preparedStatement.executeUpdate();

		connection.close();

	}
	
	public String  getPassword(String email) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM PERSON WHERE EMAIL = ?");
		preparedStatement.setString(1,email);
		ResultSet resultSet = preparedStatement.executeQuery();
		String  password = null;
		while(resultSet.next())
		{
			password = resultSet.getString("password");
		}
		connection.close();
		return password;
		
		
		
	}


}
