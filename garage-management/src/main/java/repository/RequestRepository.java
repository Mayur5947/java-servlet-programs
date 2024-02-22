package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Request;
import service.ConnectionService;

public class RequestRepository {

	ConnectionService connectionService = new ConnectionService();

	public void addRequest(int bike_id, Request request) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into service_request Values (?,?,?,?)");
		statement.setInt(1, request.getRequest_id());
		statement.setInt(2, bike_id);
		statement.setString(3, request.getStatus());
		statement.setString(4, request.getDescription());
		statement.executeUpdate();
		connection.close();
	}

	public Request getRequest(int request_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_request where request_id = ?");
		statement.setInt(1, request_id);
		ResultSet resultSet = statement.executeQuery();
		Request request = new Request();
		while (resultSet.next()) {

		}
		connection.close();
		return request;
	}

	public List<Request> getAllRequests() throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_request");
		ResultSet resultSet = statement.executeQuery();
		List<Request> requests = new ArrayList<Request>();
		while (resultSet.next()) {

		}
		connection.close();
		return requests;
	}

	public void updateRequest(Request request) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Update  service_request set status = ? , description = ? where request_id = ?");
		statement.setString(1, request.getStatus());
		statement.setString(2, request.getDescription());
		statement.setInt(3, request.getRequest_id());
		statement.executeUpdate();
		connection.close();
	}

}
