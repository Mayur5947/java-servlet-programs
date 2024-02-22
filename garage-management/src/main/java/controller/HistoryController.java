package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.History;
import service.HistoryService;

@WebServlet("/history/history")
public class HistoryController extends HttpServlet{
	HistoryService historyService =  new HistoryService();
	
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
		int history_id = Integer.parseInt(req.getParameter("history_id"));
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		int technician_id = Integer.parseInt(req.getParameter("technician_id"));
		int part_id = Integer.parseInt(req.getParameter("part_id"));
		String date = req.getParameter("date");
		String comments = req.getParameter("comments");
		
		History history =  new History();
		history.setHistory_id(history_id);
		history.setRequest_id(request_id);
		history.setTechnician_id(technician_id);
		history.setPart_id(part_id);
		history.setDate(date);
		history.setComments(comments);
		
		try {
			historyService.createHistory(request_id, technician_id, history, part_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HistoryService historyService = new HistoryService();
		List<History> list = null;
		try {
			list=historyService.getAllHistory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("history/view-all-history.jsp");
		req.setAttribute("lsit", list);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
