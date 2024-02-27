package servlet_jsp_employee;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/signup")
public class Employee_Signup  extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id  = Integer.parseInt(req.getParameter("id"));
		long phone  = Long.parseLong(req.getParameter("phone"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);
		employee.setAddress(address);
		
		EmployeeCrud crud = new EmployeeCrud();
		try {
			crud.saveEmployee(employee);
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			req.setAttribute("message", "signup Succesfully , now u can login");
			dispatcher.forward(req, res);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
