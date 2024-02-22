package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Bike;
import service.BikeService;

@WebServlet("bike/bike")
public class BikeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method_name = req.getParameter("method_name");
		if (method_name.equalsIgnoreCase("post")) {
			doPost(req, resp);
		} else if (method_name.equalsIgnoreCase("put")) {
			doPut(req, resp);
		} else if (method_name.equalsIgnoreCase("delete")) {
			doDelete(req, resp);
		} else {
			doGet(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bike bike = new Bike();
		int bike_id = Integer.parseInt(req.getParameter("bike_id"));
		int customer_id = Integer.parseInt(req.getParameter("customer_id"));
		String make = req.getParameter("make");
		String model = req.getParameter("model");
		String color = req.getParameter("color");
		String number_plate = req.getParameter("number_plate");
		int year = Integer.parseInt(req.getParameter("year"));

		BikeService bikeService = new BikeService();
		try {
			bikeService.addBike(bike, customer_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Bike bike = new Bike();
		int bike_id = Integer.parseInt(req.getParameter("bike_id"));
		int customer_id = Integer.parseInt(req.getParameter("customer_id"));
		String make = req.getParameter("make");
		String model = req.getParameter("model");
		String color = req.getParameter("color");
		String number_plate = req.getParameter("number_plate");
		int year = Integer.parseInt(req.getParameter("year"));

		BikeService bikeService = new BikeService();
		try {
			bikeService.addBike(bike, customer_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BikeService bikeService = new BikeService();
		List<Bike> list = null;
		try {
			list = bikeService.getAllBikes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("bike/view-all-bikes.jsp");
		req.setAttribute("list", list);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
