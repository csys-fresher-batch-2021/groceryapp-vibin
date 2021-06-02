package in.vibin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.vibin.model.OrderProduct;
import in.vibin.service.OrderService;
import in.vibin.service.SellingHistory;

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
		List<OrderProduct>orderedProduct=OrderService.getProduct();
		SellingHistory.addOrderHistory(mobileNumber,orderedProduct);
		session.removeAttribute("mobileNumber");
		session.removeAttribute("LOGGED_IN_USER");
		response.sendRedirect("billproduct.jsp");
	}

}
