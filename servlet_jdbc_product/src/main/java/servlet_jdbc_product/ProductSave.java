package servlet_jdbc_product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ProductSave extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String name  = req.getParameter("name");
	    String manufacturer = req.getParameter("manufacturer");
	    String state = req.getParameter("state");
	    int id = Integer.parseInt(req.getParameter("id"));
	    double price = Double.parseDouble(req.getParameter("price"));
	    String brand = req.getParameter("brand");
	    
	    Product product = new Product();
	     product.setId(id);
	     product.setName(name);
	     product.setManufacturer(manufacturer);
	     product.setState(state);
	     product.setBrand(brand);
	     
	     PrintWriter printWriter = resp.getWriter();
	     
	    ProductCrud crud = new ProductCrud();
	    if (state.equals("mah")) {
			ServletContext context =  getServletContext();
			double CGST = Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config = getServletConfig();
			Double SGST = Double.parseDouble(config.getInitParameter("mah"));
			double totalPrice = price+(CGST+SGST)*price;
			product.setPrice(totalPrice);
		} else {
			ServletContext context =  getServletContext();
			double CGST = Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config = getServletConfig();
			Double SGST = Double.parseDouble(config.getInitParameter("kar"));
			double totalPrice = price+(CGST+SGST)*price;
			product.setPrice(totalPrice);
		}
	    try {
			int a = crud.saveProduct(product);
			if (a!=0) {
				printWriter.print("saved");
			} else {
				printWriter.print("NOt saved");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
