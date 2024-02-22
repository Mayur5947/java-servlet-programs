package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import service.ConnectionService;

public class customerRepository {

	ConnectionService connectionService = new ConnectionService();

	public void addCutomer(Customer customer) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into Customer Values (?,?,?,?,?,?)");
		statement.setInt(1, customer.getCustomer_id());
		statement.setString(2, customer.getFirst_name());
		statement.setString(3, customer.getLast_name());
		statement.setString(4, customer.getEmail());
		statement.setString(5, customer.getAddress());
		statement.setLong(6, customer.getPhone());
		statement.executeUpdate();
		connection.close();
	}

	public Customer getCustomer(long customer_phone) throws Exception {

		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From Customer Where customer_id = ?");
		statement.setLong(1, customer_phone);
		ResultSet resultSet = statement.executeQuery();
		Customer customer = new Customer();
		while (resultSet.next()) {

		}
		connection.close();
		return customer;
	}

	public List<Customer> getAllCustomers() throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From Customer");
		ResultSet resultSet = statement.executeQuery();
		List<Customer> customers = new ArrayList<Customer>();
		while (resultSet.next()) {

		}
		return customers;
	}

	public void updateCustomer(Customer customer) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Update Customer Set email = ? , address = ? , phone =? where customer_id = ?");
		statement.setString(1, customer.getEmail());
		statement.setString(2, customer.getAddress());
		statement.setLong(3, customer.getPhone());
		statement.setInt(4, customer.getCustomer_id());
		statement.executeUpdate();
		connection.close();
	}
}
