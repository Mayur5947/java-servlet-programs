package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Bike;
import service.ConnectionService;

public class BikeRepository {

	ConnectionService connectionService = new ConnectionService();

	public void addBike(Bike bike, int customer_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into bike values (?,?,?,?,?,?,?)");
		statement.setInt(1, bike.getBike_id());
		statement.setInt(2, customer_id);
		statement.setString(3, bike.getMake());
		statement.setString(4, bike.getModel());
		statement.setString(5, bike.getColor());
		statement.setString(6, bike.getNumber_plate());
		statement.setInt(1, bike.getBike_id());
		statement.executeUpdate();
		connection.close();
	}

	public Bike getBike(int bike_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From Bike where bike_id = ?");
		statement.setInt(1, bike_id);
		ResultSet resultSet = statement.executeQuery();
		Bike bike = new Bike();
		while (resultSet.next()) {

		}
		connection.close();
		return bike;
	}

	public List<Bike> getAllBikes() throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From Bike ");
		ResultSet resultSet = statement.executeQuery();
		List<Bike> bikes = new ArrayList<Bike>();
		while (resultSet.next()) {

		}
		connection.close();
		return bikes;
	}

	public void updateBike(Bike bike) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"update bike set make = ? , model = ? ,color = ?,license_plate = ? , year = ? where bike_id = ? ");
		statement.setInt(6, bike.getBike_id());
		statement.setString(1, bike.getMake());
		statement.setString(2, bike.getModel());
		statement.setString(3, bike.getColor());
		statement.setString(4, bike.getNumber_plate());
		statement.setInt(5, bike.getYear());
		statement.executeUpdate();
		connection.close();
	}
}
