package SangFood;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,java.io.IOException{
				Boolean result ;
	
                UserBean user=new UserBean();
                user.setFirstName(request.getParameter("fname"));
                user.setLastName(request.getParameter("lname"));
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("pass"));
                user.setUAddress(request.getParameter("address"));
                user.setUEmail(request.getParameter("email"));
                user.setUsrTel(request.getParameter("usrtel"));
                
                result = UserDAO.register(user);
                
                if (result == true)
               
        			response.sendRedirect("index.jsp"); 
                else response.sendRedirect("Register.jsp"); 
                
	
	
	}
}
