package service;

import java.util.List;

import model.Parts;
import repository.PartsRepository;

public class PartsService {

	PartsRepository partsRepository = new PartsRepository();

	public void addPart(Parts parts) throws Exception {
		partsRepository.addPart(parts);
	}

	public Parts getPart(int part_id) throws Exception {
		return partsRepository.getPart(part_id);
	}

	public List<Parts> getAllParts() throws Exception {
		return partsRepository.getAllParts();
	}

	public void updatePart(Parts parts) throws Exception {
		partsRepository.updatePart(parts);
	}
}
