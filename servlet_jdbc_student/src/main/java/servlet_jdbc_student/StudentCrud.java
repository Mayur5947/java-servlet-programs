package servlet_jdbc_student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentCrud {
public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
		
		return connection;
	}

	public int saveStudent(Student student) throws SQLException, ClassNotFoundException, IOException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO STUDENT   VALUES (? ,? ,? , ? , ? , ?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getStudent_name());
		preparedStatement.setString(3, student.getFather_name());
		preparedStatement.setString(4, student.getMother_name());
		preparedStatement.setInt(5,student.getAge());
		preparedStatement.setString(6, student.getEmail());
		preparedStatement.setString(7, student.getPassword());
		preparedStatement.setString(8, student.getSchool());
		preparedStatement.setLong(9, student.getFees());
		int a =preparedStatement.executeUpdate();

		
		

		connection.close();
		return a;

	}
	
	
	public Student getPassword(String email) throws Exception, IOException, SQLException
	{
		Connection connection =getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet=preparedStatement.executeQuery();
		Student student =  new Student();
		while(resultSet.next())
		{
			student.setPassword(resultSet.getString("password"));
			student.setSchool(resultSet.getString("school"));
		}
		connection.close();
		return student;
		
	}


}
