package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.History;
import service.ConnectionService;

public class HistoryRepository {
	ConnectionService connectionService =  new ConnectionService();
	
	public void createHistory(int request_id, int technician_id, History history,int part_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into service_history values (?,?,?,?,?,?)");
		statement.setInt(1, history.getHistory_id());
		statement.setInt(2, request_id);
		statement.setInt(3, technician_id);
		statement.setInt(4, part_id);
		statement.setString(5, history.getDate());
		statement.setString(6, history.getComments());
		statement.executeUpdate();
		connection.close();
	}
	
	public History getHistory(int history_id) throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_history where history_id = ?");
		statement.setInt(1, history_id);
		ResultSet resultSet = statement.executeQuery();
		History history =  new History();
		while(resultSet.next()) {
			history.setHistory_id(resultSet.getInt(1));
			history.setRequest_id(resultSet.getInt(2));
			history.setTechnician_id(resultSet.getInt(3));
			history.setPart_id(resultSet.getInt(4));
			history.setDate(resultSet.getString(5));
			history.setComments(resultSet.getString(6));
		}
		connection.close();
		return history;
	}
	
	public List<History> getAllHistory() throws Exception {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_history");
		ResultSet resultSet = statement.executeQuery();
		List<History> histories =  new  ArrayList<History>();
		while(resultSet.next()) {
			History history =  new History();
			history.setHistory_id(resultSet.getInt(1));
			history.setRequest_id(resultSet.getInt(2));
			history.setTechnician_id(resultSet.getInt(3));
			history.setPart_id(resultSet.getInt(4));
			history.setDate(resultSet.getString(5));
			history.setComments(resultSet.getString(6));
			histories.add(history);
		}
		connection.close();
		return histories;
	}
}
