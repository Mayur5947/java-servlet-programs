package servlet_jdbc_student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id =Integer.parseInt(req.getParameter("id"));
		String student_name =req.getParameter("s_name");
		String father_name =req.getParameter("f_name");
		String mother_name =req.getParameter("m_name");
		int age =Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		
		ServletContext context = getServletContext();
		String school =context.getInitParameter("school");
		
		Student student =  new Student();
		student.setId(id);
		student.setStudent_name(student_name);
		student.setFather_name(father_name);
		student.setMother_name(mother_name);
		student.setAge(age);
		student.setEmail(email);
		student.setPassword(password);
		student.setSchool(school);
		
		String fee = req.getParameter("fees");
		if (fee.equals("one shot")) {
			ServletConfig config = getServletConfig();
			long fees = Long.parseLong(config.getInitParameter("os"));
			student.setFees(fees);
		} else {
			ServletConfig config = getServletConfig();
			long fees = Long.parseLong(config.getInitParameter("I"));
			student.setFees(fees);
		}
		
		StudentCrud  crud = new StudentCrud();
		try {
			int a =crud.saveStudent(student);
			if (a!=0) {
				RequestDispatcher dispatcher =req.getRequestDispatcher("login.html");
			} else {
				RequestDispatcher dispatcher =req.getRequestDispatcher("home.html");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
