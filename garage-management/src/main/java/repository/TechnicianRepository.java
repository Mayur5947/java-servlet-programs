package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Technician;
import service.ConnectionService;

public class TechnicianRepository {

	ConnectionService connectionService = new ConnectionService();

	public List<Technician> getAllTechnicians() throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From service_technician");
		ResultSet resultSet = statement.executeQuery();
		List<Technician> technicians = new ArrayList<Technician>();
		while (resultSet.next()) {
			Technician technician =  new Technician();
			technician.setTechnician_id(resultSet.getInt(1));
			technician.setFirst_name(resultSet.getString(2));
			technician.setLast_name(resultSet.getString(3));
			technician.setSpecialization(resultSet.getString(4));
			technicians.add(technician);
		}
		connection.close();
		return technicians;
	}

	public void addTechnician(Technician technician) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into service_technician values (?,?,?,?)");
		statement.setInt(1, technician.getTechnician_id());
		statement.setString(2, technician.getFirst_name());
		statement.setString(3, technician.getLast_name());
		statement.setString(4, technician.getSpecialization());
		statement.executeUpdate();
		connection.close();
	}

	public void updateTechnician(Technician technician) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("update service_technician set specialization = ? where technician_id = ?");
		statement.setString(1, technician.getSpecialization());
		statement.setInt(2, technician.getTechnician_id());
		statement.executeUpdate();
		connection.close();
	}

	public Technician getTechnician(int technician_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Select * From service_technician where technician_id = ?");
		statement.setInt(1, technician_id);
		ResultSet resultSet = statement.executeQuery();
		Technician technician = new Technician();
		while (resultSet.next()) {
			technician.setTechnician_id(resultSet.getInt(1));
			technician.setFirst_name(resultSet.getString(2));
			technician.setLast_name(resultSet.getString(3));
			technician.setSpecialization(resultSet.getString(4));
		}
		connection.close();
		return technician;
	}
}
