package in.vibin.Servlet;

import in.vibin.Validator.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.vibin.service.ProductService;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("productID"));
		String name = request.getParameter("name").trim().toLowerCase();
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		boolean isValidID = NumberValidation.checkNumber(id);
		boolean isValidQuantity = NumberValidation.checkNumber(quantity);
		boolean isValidName = StringValidation.checkString(name);
		boolean isValidPrice = DecimalValidation.checkDecimal(price);
		int isAdded = 0;
		if (isValidID && isValidQuantity && isValidName && isValidPrice) {
			isAdded = ProductService.addProduct(id, name, price, quantity);
		}
		if (isAdded == 1) {
			String errorMessage = "ID and Name already exist";
			response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
		} else if (isAdded == 2) {
			String errorMessage = "ID already exist";
			response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
		} else if (isAdded == 3) {
			String errorMessage = "Name already exist";
			response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
		} else {
			String infoMessage = "Product successfully added";
			response.sendRedirect("addproduct.jsp?infoMessage=" + infoMessage);
		}
	}
}