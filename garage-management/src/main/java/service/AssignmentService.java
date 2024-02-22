package service;

import java.util.List;

import model.Assignment;
import repository.AssignmentRepository;

public class AssignmentService {

	AssignmentRepository repository = new AssignmentRepository();

	public void addAssignment(int request_id, int technician_id, Assignment assignment, int part_id) throws Exception {
		repository.addAssignment(request_id, technician_id, assignment, part_id);
	}

	public Assignment getAssignment(int assignment_id) throws Exception {
		return repository.getAssignment(assignment_id);
	}

	public List<Assignment> getAllAssignment() throws Exception {
		return repository.getAllAssignment();
	}
	
	public void updateAssignment(Assignment assignment) throws Exception {
		repository.updateAssignment(assignment);
	}
}
