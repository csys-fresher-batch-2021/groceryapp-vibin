package in.vibin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.vibin.model.Product;
import in.vibin.service.ProductService;

/**
 * Servlet implementation class DisplayProductServlet
 */
@WebServlet("/DisplayProductServlet")
public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayProductServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> productList = ProductService.getProduct();

		Gson gson = new Gson();

		String jsonProducts = gson.toJson(productList);

		PrintWriter out = response.getWriter();

		out.print(jsonProducts);

		out.flush();

	}

}
