package servlet_jdbc_student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/lifecycle")
public class Lifecycle extends HttpServlet{
	
	
	public Lifecycle() {
		System.out.println("object creation");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init method");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service");
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
}
