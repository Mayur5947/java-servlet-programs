package servlet_jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginCongtroller extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		person person = new person();
		
		person.setEmail(email);
		person.setPassword(password);
		
		personCrud crud = new personCrud();
		PrintWriter writer = resp.getWriter();
		
		try {
			if (password.equals(crud.getPassword(email))){
				resp.sendRedirect("https://www.facebook.com/");
				
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
