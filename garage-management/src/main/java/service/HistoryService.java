package service;

import java.util.List;

import model.History;
import repository.HistoryRepository;

public class HistoryService {
	
	HistoryRepository historyRepository =  new HistoryRepository();
	
	public void createHistory(int request_id, int technician_id, History history,int part_id) throws Exception {
		
		historyRepository.createHistory(request_id, technician_id, history, part_id);
	}
	
	public History getHistory(int history_id) throws Exception {
		return historyRepository.getHistory(history_id);
	}
	
	public List<History> getAllHistory() throws Exception {
		return historyRepository.getAllHistory();
	}
	
	
	
}
