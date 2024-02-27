package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Parts;
import service.ConnectionService;

public class PartsRepository {

	ConnectionService connectionService = new ConnectionService();

	public void addPart(Parts parts) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into part_inventory values (?,?,?,?)");
		statement.setInt(1, parts.getPart_id());
		statement.setString(2, parts.getPart_name());
		statement.setInt(3, parts.getQty_available());
		statement.setInt(4, parts.getPrice());
		statement.executeUpdate();
		connection.close();
	}

	public Parts getPart(int part_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from part_inventory where part_id = ?");
		statement.setInt(1, part_id);
		ResultSet resultSet = statement.executeQuery();
		Parts parts = new Parts();
		while (resultSet.next()) {	
			parts.setPart_id(resultSet.getInt(1));
			parts.setPart_name(resultSet.getString(2));
			parts.setPrice(resultSet.getInt(4));
			parts.setQty_available(resultSet.getInt(3));
			
		}
		connection.close();
		return parts;
	}

	public List<Parts> getAllParts() throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from part_inventory ");
		ResultSet resultSet = statement.executeQuery();
		List<Parts> list = new ArrayList<Parts>();
		while (resultSet.next()) {
			Parts part = new Parts();
			part.setPart_id(resultSet.getInt(1));
			part.setPart_name(resultSet.getString(2));
			part.setPrice(resultSet.getInt(4));
			part.setQty_available(resultSet.getInt(3));
			list.add(part);
		}
		connection.close();
		return list;
	}
	
	public void updatePart(Parts parts) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Update part_inventory set part_name = ? , available_quantity  = ? , price = ? where part_id = ?");
		statement.setString(1, parts.getPart_name());
		statement.setInt(2, parts.getQty_available());
		statement.setInt(3, parts.getPrice());
		statement.setInt(4, parts.getPart_id());
		statement.executeUpdate();
		connection.close();
	}

}
