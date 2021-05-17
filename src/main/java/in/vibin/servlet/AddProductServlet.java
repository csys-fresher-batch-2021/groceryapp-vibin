package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.vibin.service.ProductService;
import in.vibin.validator.*;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMessage = null;
		String excecutionPath="addproduct.jsp?errorMessage=";
		try {
			String name = request.getParameter("name").trim().toLowerCase();
			int id = NumberValidation.parseInt(request.getParameter("productID"), "Invalid ID");
			double price = NumberValidation.parseDouble(request.getParameter("price"), "Invalid price");
			int quantity = NumberValidation.parseInt(request.getParameter("quantity"), "Invalid quantity");
			boolean isValidID = NumberValidation.checkInteger(id);
			boolean isValidQuantity = NumberValidation.checkInteger(quantity);
			boolean isValidName = StringValidation.checkString(name);
			boolean isValidPrice = NumberValidation.checkDecimal(price);
			int isAdded = 0;
			if (isValidID && isValidQuantity && isValidName && isValidPrice) {
				isAdded = ProductService.addProduct(id, name, price, quantity);
			}
			if (isAdded == 1) {
				errorMessage = "ID and Name already exist";
				response.sendRedirect(excecutionPath + errorMessage);// send the message to the
																						// addproduct.jsp
			} else if (isAdded == 2) {
				errorMessage = "ID already exist";
				response.sendRedirect(excecutionPath + errorMessage);// send the message to the
																						// addproduct.jsp
			} else if (isAdded == 3) {
				errorMessage = "Name already exist";
				response.sendRedirect(excecutionPath + errorMessage);// send the message to the
																						// addproduct.jsp
			} else if (isAdded == 4) {
				String infoMessage = "Product added successfully ";
				response.sendRedirect("addproduct.jsp?infoMessage=" + infoMessage);// send the message to the
																					// addproduct.jsp
			} else {
				errorMessage = "Invalid Inputs";
				response.sendRedirect(excecutionPath + errorMessage);// send the message to the
																						// addproduct.jsp
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
			response.sendRedirect(excecutionPath + errorMessage);// send the message to the addproduct.jsp
		}
	}
}