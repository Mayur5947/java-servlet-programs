package servlet_jdbc_student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ServletContext context = getServletContext();
		String school = context.getInitParameter("school");
		StudentCrud crud = new StudentCrud();
		
		
		try {
			Student dbstudent = crud.getPassword(email);
			if (password.equals(dbstudent.getPassword()) && school.equals(dbstudent.getSchool())) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("success.html");
				dispatcher.forward(req, resp);
			} else {
				resp.sendRedirect("login.html");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
