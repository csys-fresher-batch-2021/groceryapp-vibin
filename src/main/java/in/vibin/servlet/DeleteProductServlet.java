package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vibin.service.ProductService;
import in.vibin.validator.NumberValidation;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = NumberValidation.parseInt(request.getParameter("productID"), "Invalid input");
			ProductService.deleteProduct(id);
			response.sendRedirect("listproducts.jsp?infoMessage=" + "Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}