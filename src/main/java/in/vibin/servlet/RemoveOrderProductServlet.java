package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.vibin.model.OrderProduct;
import in.vibin.service.OrderService;
import in.vibin.validator.NumberValidation;

/**
 * Servlet implementation class RemoveOrderProductServlet
 */
@WebServlet("/RemoveOrderProductServlet")
public class RemoveOrderProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RemoveOrderProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		String price1=request.getParameter("price");
		String quantity1=request.getParameter("quantity");
		String name=request.getParameter("name");
		double price=NumberValidation.parseDouble(price1, "Invalid Price");
		int quantity=NumberValidation.parseInt(quantity1, "Invalid quantity");
		int id=NumberValidation.parseInt(id1,"Invalid ID");
		OrderProduct product=new OrderProduct();
		product.setID(id);
		product.setPrice(price);
		product.setOrderedQuantity(quantity);
		product.setName(name);
		OrderService.removeOrderedProduct(product);
		response.sendRedirect("orderproduct.jsp");
	}
}
