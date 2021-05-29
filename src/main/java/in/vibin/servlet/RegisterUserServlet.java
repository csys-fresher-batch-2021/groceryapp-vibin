package in.vibin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vibin.exception.RegisterUserException;
import in.vibin.exception.SuccessfullException;
import in.vibin.service.RegisterUserService;
import in.vibin.validator.MobileNumberValidation;
import in.vibin.validator.NumberValidation;
import in.vibin.validator.PasswordValidation;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
    
    }
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobileNumber = request.getParameter("mobileNumber").trim();
		String password = request.getParameter("password").trim();
		String rePassword=request.getParameter("repassword").trim();
		long mobileNumberLong = NumberValidation.parseLong(mobileNumber, "Invalid mobile number");
		boolean isValidMobileNumber = MobileNumberValidation.checkMobileNumber(mobileNumberLong);
		boolean isValidPassword = PasswordValidation.checkPassword(password);
		if(isValidMobileNumber && isValidPassword) {
			
				
						try {
							RegisterUserService.registerUser(mobileNumberLong, password, rePassword);
						} catch (SuccessfullException e) {
							response.sendRedirect("registeruser.jsp?infoMessage="+e.getMessage());
						}
					 catch (RegisterUserException e) {
						response.sendRedirect("registeruser.jsp?errorMessage="+e.getMessage());
					}
		}	
}
}

