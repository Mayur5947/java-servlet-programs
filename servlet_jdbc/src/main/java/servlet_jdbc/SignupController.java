package servlet_jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/SignUp")
public class SignupController  extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id  = Integer.parseInt(req.getParameter("Id"));
		long phone  = Long.parseLong(req.getParameter("phone"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		person person = new person();
		person.setId(id);
		person.setName(name);
		person.setEmail(email);
		person.setPassword(password);
		person.setPhone(phone);
		
		personCrud crud = new personCrud();
		try {
			crud.savePerson(person);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = res.getWriter();
		writer.println("saved succesfully");
		
	}

}
