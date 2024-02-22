package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Request;
import service.RequestService;

@WebServlet("/request/request")
public class RequestController extends HttpServlet{
	
	RequestService requestService =  new RequestService();
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
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		String status = req.getParameter("status");
		String description = req.getParameter("discription");
		
		Request request =  new Request();
		
		request.setRequest_id(request_id);
		request.setDescription(description);
		request.setStatus(status);
		
		try {
			requestService.updateRequest(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestService requestService =  new RequestService();
		List<Request> list = null;
		
		try {
			list=requestService.getAllRequests();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("request/view-all-requests.jsp");
		req.setAttribute("list", list);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
