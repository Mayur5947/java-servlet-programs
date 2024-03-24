package servlet_jdbc_employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/update")
public class Employee_Update extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id  = Integer.parseInt(req.getParameter("Id"));
		long phone  = Long.parseLong(req.getParameter("New phone"));
		String name = req.getParameter("New name");
		String email = req.getParameter("New email");
		String password = req.getParameter("New password");
		String address = req.getParameter("New address");

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);
		employee.setAddress(address);
		
		
		EmployeeCrud crud = new EmployeeCrud();
		try {
			crud.updateEmployee(employee);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = res.getWriter();
		writer.println("updated succesfully");
		
		
	}

}
