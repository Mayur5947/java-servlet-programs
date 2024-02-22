package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Parts;
import service.PartsService;

@WebServlet("/parts/parts")
public class PartsController extends  HttpServlet{
	
	PartsService partsService =  new  PartsService();
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
		int part_id = Integer.parseInt(req.getParameter("part_id"));
		int price = Integer.parseInt(req.getParameter("price"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		String part_name = req.getParameter("part_name");
		
		Parts parts =  new Parts();
		parts.setPart_id(part_id);
		parts.setPart_name(part_name);
		parts.setPrice(price);
		parts.setQty_available(qty);
		
		try {
			partsService.addPart(parts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int part_id = Integer.parseInt(req.getParameter("part_id"));
		int price = Integer.parseInt(req.getParameter("price"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		
		Parts parts =  new Parts();
		parts.setPart_id(part_id);
		parts.setPrice(price);
		parts.setQty_available(qty);
		
		try {
			partsService.addPart(parts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PartsService partsService =  new PartsService();
		List<Parts> list = null;
		try {
			list=partsService.getAllParts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("parts/view-all-parts.jsp");
		req.setAttribute("list", list);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
