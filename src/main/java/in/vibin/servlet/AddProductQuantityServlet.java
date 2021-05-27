package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import in.vibin.model.Product;

import in.vibin.service.ProductService;

import in.vibin.validator.NumberValidation;

/**
 * Servlet implementation class AddProductQuantityServlet
 */
@WebServlet("/AddProductQuantityServlet")
public class AddProductQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddProductQuantityServlet() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("addProductID");
		String availableQuantity = (String) session.getAttribute("oAvailableQuantity");
		String addingQuantity = request.getParameter("addedquantity");
		int idInt = NumberValidation.parseInt(id, "Invalid ID");
		int addingQuantityInt =NumberValidation.parseInt(addingQuantity, "In valid adding Quantity");
		int availableQuantityInt = NumberValidation.parseInt(availableQuantity, "Invalid quantity");
		boolean isValidQuantity = NumberValidation.checkInteger(addingQuantityInt);
		if (isValidQuantity) {
			Product addQuantityProduct=new Product();
			addQuantityProduct.setID(idInt);
			addQuantityProduct.setQuantity(availableQuantityInt);
			addQuantityProduct.setOrderedQuantity(addingQuantityInt);
			ProductService.addQuantity(addQuantityProduct);
			session.removeAttribute("addProductID"); 
			session.removeAttribute("oAvailableQuantity");
			response.sendRedirect("buyproduct.jsp");
		}

	}
	}

