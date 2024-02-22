package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Assignment;
import service.ConnectionService;

public class AssignmentRepository {
	ConnectionService connectionService = new ConnectionService();

	public void addAssignment(int request_id, int technician_id, Assignment assignment, int part_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Insert Into service_assignment values (?,?,?,?,?,?)");
		statement.setInt(1, assignment.getAssignment_id());
		statement.setInt(2, request_id);
		statement.setInt(3, technician_id);
		statement.setInt(4, part_id);
		statement.setString(5, assignment.getStatus());
		statement.setString(6, assignment.getDate());
		statement.executeUpdate();
		connection.close();
	}

	public Assignment getAssignment(int assignment_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Select * From service_assignment where assignment_id = ?");
		statement.setInt(1, assignment_id);
		ResultSet resultSet = statement.executeQuery();
		Assignment assignment = new Assignment();
		while (resultSet.next()) {

		}
		connection.close();
		return assignment;
	}

	public List<Assignment> getAllAssignment() throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From service_assignment");
		ResultSet resultSet = statement.executeQuery();
		List<Assignment> assignments =  new ArrayList<Assignment>();
		while (resultSet.next()) {
			
		}
		connection.close();
		return assignments;
	}
	
	public void updateAssignment(Assignment assignment) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("update service_assignment set status = ? , assignment_date = ? where assignment_id = ?");
		statement.setString(1, assignment.getStatus());
		statement.setString(2, assignment.getDate());
		statement.setInt(3, assignment.getAssignment_id());
		statement.executeUpdate();
		connection.close();

	}

}
