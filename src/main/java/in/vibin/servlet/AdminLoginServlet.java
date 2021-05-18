package in.vibin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.vibin.service.*;
import in.vibin.validator.MobileNumberValidation;
import in.vibin.validator.NumberValidation;
import in.vibin.validator.PasswordValidation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobileNumber=request.getParameter("mobileNumber").trim();
		String password=request.getParameter("password").trim();
		long mobileNumberLong= NumberValidation.parseLong(mobileNumber,"Invalid mobile number");
		boolean isValidPassword=PasswordValidation.checkPassword(password);
		boolean isValidMobileNumber=MobileNumberValidation.checkMobileNumber(mobileNumberLong);
		boolean isAdmin=false;
		if(isValidPassword && isValidMobileNumber) {
			isAdmin=AdminLoginService.admin(mobileNumberLong, password);
		}
		if(isAdmin) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_ADMIN", "admin");
			response.sendRedirect("index.jsp?infoMessage=" + "Admin Login");
		}
		else {
			response.sendRedirect("adminlogin.jsp?errorMessage=" + "Invalid Inputs");
		}
	}

}