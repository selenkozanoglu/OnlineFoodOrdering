package SangFoodproject;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String newlastname = request.getParameter("newlastname");
		String newemail=request.getParameter(newemail);
		String newaddress=request.getParameter(newaddress);
		
		System.out.println(session.getAttribute("currentSessionUser"));
		String username = (String) session.getAttribute("currentSessionUser");
		//String userid ="selo";
		System.out.println("servlete access" + username);
		UserDAO.EditProfile(newlastname, newemail, newaddress);
		
		System.out.println("successful");
		request.setAttribute("message", "user information Succesfuly Changed");
		RequestDispatcher rd = request.getRequestDispatcher("EditProfile.jsp");
		//response.sendRedirect("login.jsp");
		rd.forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				doGet(request, response);

		
	}

}
