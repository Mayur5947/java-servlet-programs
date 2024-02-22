package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import service.CustomerService;

@WebServlet("/customer/customer")
public class CustomerController extends HttpServlet {
	
	CustomerService customerService =  new CustomerService();
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
		int customer_id = Integer.parseInt(req.getParameter("customer_id"));
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		Customer customer =  new Customer();
		
		customer.setAddress(address);
		customer.setCustomer_id(customer_id);
		customer.setEmail(email);
		customer.setFirst_name(first_name);
		customer.setLast_name(last_name);
		customer.setPhone(phone);
		
		try {
			customerService.addCutomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int customer_id = Integer.parseInt(req.getParameter("customer_id"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		Customer customer =  new Customer();
		
		customer.setAddress(address);
		customer.setCustomer_id(customer_id);
		customer.setEmail(email);
		customer.setPhone(phone);
		
		try {
			customerService.updateCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerService customerService =  new CustomerService();
		List<Customer> list = null;
		try {
		list =	customerService.getAllCustomers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher =  req.getRequestDispatcher("customer/view-all-customers.jsp");
		req.setAttribute("list", list);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
