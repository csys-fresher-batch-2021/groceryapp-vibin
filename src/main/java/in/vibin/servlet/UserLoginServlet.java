package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.vibin.service.UserLoginService;
import in.vibin.validator.MobileNumberValidation;
import in.vibin.validator.PasswordValidation;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mobileNumber = request.getParameter("mobileNumber").trim();
		String password = request.getParameter("password").trim();
		long mobileNumberLong=Long.parseLong(mobileNumber);
		boolean isValidPassword = PasswordValidation.checkPassword(password);
		boolean isValidMobileNumber = MobileNumberValidation.checkMobileNumber(mobileNumberLong);
		boolean isUser = false;
		if (isValidPassword && isValidMobileNumber) {
			isUser = UserLoginService.user(mobileNumberLong, password);
		}
		if (isUser) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", "user");
			session.setAttribute("userMobileNumber", mobileNumberLong);
			response.sendRedirect("index.jsp?infoMessage=" + "User Login");
		} else {
			response.sendRedirect("userlogin.jsp?errorMessage=" + "Login Failed. Please Try Again!..");
		}
	}
}
