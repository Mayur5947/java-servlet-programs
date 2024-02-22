package service;

import java.util.List;

import model.Technician;
import repository.TechnicianRepository;

public class TechnicianService {

	TechnicianRepository repository = new TechnicianRepository();

	public List<Technician> getAllTechnicians() throws Exception {
		return repository.getAllTechnicians();
	}

	public void addTechnician(Technician technician) throws Exception {
		repository.addTechnician(technician);
	}

	public void updateTechnician(Technician technician) throws Exception {
		repository.updateTechnician(technician);
	}

	public Technician getTechnician(int technician_id) throws Exception {
		return repository.getTechnician(technician_id);
	}
}
