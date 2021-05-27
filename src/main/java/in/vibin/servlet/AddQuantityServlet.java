package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddQuantityServlet
 */
@WebServlet("/AddQuantityServlet")
public class AddQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuantityServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("productID");
		String availableQuantity = request.getParameter("availablequantity");
		HttpSession session = request.getSession();
		session.setAttribute("addProductID", id);
		session.setAttribute("oAvailableQuantity", availableQuantity);
		response.sendRedirect("addquantity.jsp");
	}

	
}
