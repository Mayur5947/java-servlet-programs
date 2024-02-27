package servlet_jsp_employee;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCrud {
public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		
		return connection;
	}

	public void saveEmployee(Employee employee) throws SQLException, ClassNotFoundException, IOException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO EMPLOYEE   VALUES (? ,? ,? , ? , ? , ?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(6, employee.getPassword());
		preparedStatement.setString(4, employee.getAddress());
		int a = preparedStatement.executeUpdate();

		connection.close();

	}
	
	public void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException, IOException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE EMPLOYEE SET  NAME  = ? , PHONE = ? ,ADDRESS = ?, EMAIL = ? , PASSWORD =?WHERE ID = ?");
		
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setInt(6, employee.getId());
		int a = preparedStatement.executeUpdate();

		connection.close();

	}
	
	public String  getPassword(String email) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMAIL = ?");
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
	
	public List<Employee>  getAllEmployees() throws SQLException, ClassNotFoundException, IOException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM EMPLOYEE");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Employee> employees = new ArrayList<Employee>();
		while(resultSet.next())
		{
			Employee employee =  new Employee();
			employee.setId(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setPhone(resultSet.getLong(3));
			employee.setAddress(resultSet.getString(4));
			employee.setEmail(resultSet.getString(5));
			employee.setPassword(resultSet.getString(6));
			employees.add(employee);
		}
		connection.close();
		return employees;
		
		
		
	}


}

