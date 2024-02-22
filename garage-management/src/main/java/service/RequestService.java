package service;

import java.util.List;

import model.Request;
import repository.RequestRepository;

public class RequestService {
	RequestRepository repository = new RequestRepository();

	public void addRequest(int bike_id, Request request) throws Exception {
		repository.addRequest(bike_id, request);
	}

	public Request getRequest(int request_id) throws Exception {
		return repository.getRequest(request_id);
	}

	public List<Request> getAllRequests() throws Exception {
		return repository.getAllRequests();
	}
	
	public void updateRequest(Request request) throws Exception {
		repository.updateRequest(request);
	}

}
