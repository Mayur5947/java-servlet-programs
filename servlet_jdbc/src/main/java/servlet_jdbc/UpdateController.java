package servlet_jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/update")
public class UpdateController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id  = Integer.parseInt(req.getParameter("Id"));
		long phone  = Long.parseLong(req.getParameter("New phone"));
		String name = req.getParameter("New name");
		String email = req.getParameter("New email");
		String password = req.getParameter("New password");
		
		person person = new person();
		person.setName(name);
		person.setId(id);
		
		person.setEmail(email);
		person.setPassword(password);
		person.setPhone(phone);
		
		personCrud crud = new personCrud();
		try {
			crud.updatePerson(person);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = res.getWriter();
		writer.println("updated succesfully");
		
		
	}

}
