package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vibin.service.UserService;
import in.vibin.validator.NumberValidation;


/**
 * Servlet implementation class BuyProductServlet
 */
@WebServlet("/OrderProductServlet")
public class OrderProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("orderID");
		String name = (String) session.getAttribute("orderName");
		String price = (String) session.getAttribute("orderPrice");
		String orderedQuantity=request.getParameter("orderedquantity");
		int idInt=NumberValidation.parseInt(id, "Invalid ID");
		int orderedQuantityInt=NumberValidation.parseInt(orderedQuantity, "Invalid Quantity");
		boolean isValidQuantity=NumberValidation.checkInteger(orderedQuantityInt);
		if(isValidQuantity) {
			 double amount=UserService.orderProduct(idInt, orderedQuantityInt);
			response.sendRedirect("billproduct.jsp?id="+id+"&name="+name+"&price="+price+"&orderquantity="+orderedQuantity+"&amount="+amount);
			 }

	}
}