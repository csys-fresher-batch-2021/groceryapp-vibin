package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vibin.model.OrderHistory;
import in.vibin.service.SellingHistory;
import in.vibin.validator.NumberValidation;

/**
 * Servlet implementation class SellingHistoryServlet
 */
@WebServlet("/SellingHistoryServlet")
public class SellingHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellingHistoryServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		long mobileNumber = (Long) session.getAttribute("userMobileNumber");
		String productName = request.getParameter("productname");
		String pricePerQuantity = request.getParameter("priceperquantity");
		String orderedQuantity = request.getParameter("orderedquantity");
		String amount1 = request.getParameter("amount");
		double price = NumberValidation.parseDouble(pricePerQuantity, "Invalid price");
		int quantity = NumberValidation.parseInt(orderedQuantity, "Invalid quantity");
		double amount = NumberValidation.parseDouble(amount1, "Invalid amount");
		OrderHistory orderProduct = new OrderHistory();
		orderProduct.setMobileNumber(mobileNumber);
		orderProduct.setName(productName);
		orderProduct.setPrice(price);
		orderProduct.setOrderedQuantity(quantity);
		orderProduct.setAmount(amount);
		SellingHistory.addOrderHistory(orderProduct);
		response.sendRedirect("billproduct.jsp");
	}

}
