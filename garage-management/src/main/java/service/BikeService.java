package service;

import java.util.List;

import model.Bike;
import repository.BikeRepository;

public class BikeService {

	BikeRepository bikeRepository = new BikeRepository();

	public void addBike(Bike bike, int customer_id) throws Exception {
		bikeRepository.addBike(bike, customer_id);
	}

	public Bike getBike(int bike_id) throws Exception {
		return bikeRepository.getBike(bike_id);
	}

	public List<Bike> getAllBikes() throws Exception {
		return bikeRepository.getAllBikes();
	}

	public void updateBike(Bike bike) throws Exception {
		bikeRepository.updateBike(bike);
	}
}
