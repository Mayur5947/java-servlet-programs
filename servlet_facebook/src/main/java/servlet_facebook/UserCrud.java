package servlet_facebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class UserCrud {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root");

		return connection;

	}

	public void saveUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setLong(4, user.getMobile());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(5, user.getPassword());
		int a = preparedStatement.executeUpdate();

		connection.close();
	}

	

}
