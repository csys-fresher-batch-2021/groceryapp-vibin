package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vibin.model.Product;
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
		String excecutionPath = "addproduct.jsp?errorMessage=";
		try {
			String name = request.getParameter("name").trim().toLowerCase();
			int id = NumberValidation.parseInt(request.getParameter("productID"), "Invalid ID");
			double price = NumberValidation.parseDouble(request.getParameter("price"), "Invalid price");
			int quantity = NumberValidation.parseInt(request.getParameter("quantity"), "Invalid quantity");
			boolean isValidID = NumberValidation.checkInteger(id);
			boolean isValidQuantity = NumberValidation.checkInteger(quantity);
			boolean isValidName = StringValidation.checkString(name);
			boolean isValidPrice = NumberValidation.checkDecimal(price);
			if (isValidID && isValidQuantity && isValidName && isValidPrice) {
				Product product = new Product();
				product.setID(id);
				product.setName(name);
				product.setPrice(price);
				product.setQuantity(quantity);

				ProductService.addProduct(product);
				response.sendRedirect("addproduct.jsp?infoMessage=Successfully added");
				// addproduct.jsp
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
			response.sendRedirect(excecutionPath + errorMessage);// send the message to the addproduct.jsp
		}
	}
}