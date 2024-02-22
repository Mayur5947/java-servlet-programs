package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Assignment;
import service.AssignmentService;

@WebServlet("/assignmnet/assignment")
public class AssignmentController extends HttpServlet {
	AssignmentService assignmentService = new AssignmentService();

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
		int assignment_id = Integer.parseInt(req.getParameter("assignment_id"));
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		int technician_id = Integer.parseInt(req.getParameter("technician_id"));
		int part_id = Integer.parseInt(req.getParameter("part_id"));
		String status = req.getParameter("status");
		String date = req.getParameter("date");
		
		Assignment assignment = new Assignment();
		assignment.setAssignment_id(assignment_id);
		assignment.setRequest_id(request_id);
		assignment.setTechnician_id(technician_id);
		assignment.setPart_id(part_id);
		assignment.setStatus(status);
		assignment.setDate(date);
		
		try {
			assignmentService.addAssignment(request_id, technician_id, assignment, part_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = resp.getWriter();
		writer.println("added succesfully");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int assignment_id = Integer.parseInt(req.getParameter("assignment_id"));
		String status = req.getParameter("status");
		String date = req.getParameter("date");
		
		Assignment assignment = new Assignment();
		assignment.setAssignment_id(assignment_id);
		assignment.setStatus(status);
		assignment.setDate(date);
		
		try {
			assignmentService.updateAssignment(assignment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = resp.getWriter();
		writer.println("added succesfully");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AssignmentService assignmentService = new AssignmentService();
		List<Assignment> list = null;
		try {
			list = assignmentService.getAllAssignment();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("assignment/view-all-assignments.jsp");
		req.setAttribute("list", list);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
