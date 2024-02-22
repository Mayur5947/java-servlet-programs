package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Technician;
import service.TechnicianService;

@WebServlet("/technician/technician")
public class TechnicianController extends HttpServlet{
	TechnicianService service =  new TechnicianService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service method");
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
		int technician_id = Integer.parseInt(req.getParameter("technician_id"));
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String specialization = req.getParameter("specialization");
		
		Technician technician =  new Technician();
		technician.setFirst_name(first_name);
		technician.setLast_name(last_name);
		technician.setSpecialization(specialization);
		technician.setTechnician_id(technician_id);
		
		try {
			service.addTechnician(technician);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int technician_id = Integer.parseInt(req.getParameter("technician_id"));
		String specialization = req.getParameter("specialization");
		
		Technician technician =  new Technician();
		technician.setSpecialization(specialization);
		technician.setTechnician_id(technician_id);
		
		try {
			service.updateTechnician(technician);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TechnicianService service =  new TechnicianService();
		List<Technician> list = null;
		try {
			list=service.getAllTechnicians();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("technician/view-all-technician.jsp");
		req.setAttribute("list", list);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
