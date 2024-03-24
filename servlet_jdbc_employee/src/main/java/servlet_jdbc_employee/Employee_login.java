package servlet_jdbc_employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Employee_login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee employee =  new Employee();
		
		employee.setEmail(email);
		employee.setPassword(password);
		
		EmployeeCrud crud  = new EmployeeCrud ();
		PrintWriter writer = resp.getWriter();
		
		try {
			if (password.equals(crud.getPassword(email))){
				resp.sendRedirect("https://stackoverflow.com/");
				
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
				dispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
