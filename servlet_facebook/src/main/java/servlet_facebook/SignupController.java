package servlet_facebook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUp")
public class SignupController extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		//String phone = req.getParameter("phone");
		long mobile = Long.parseLong(req.getParameter("phone"));
		int id = Integer.parseInt(req.getParameter("Id"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);

		UserCrud crud = new UserCrud();

		try {
			crud.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter writer = res.getWriter();
		writer.println("saved succesfully");
	}

}
