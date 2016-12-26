package SangFood;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

/**
 * Servlet implementation class AddRestaurantFormServlet
 */

public class AddRestaurantFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRestaurantFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	     HTTPException session =null;
         RestaurantBean restaurant=new RestaurantBean();
         restaurant.setRestAddress(request.getParameter("restaddress"));
         restaurant.setRestName(request.getParameter("restname"));
         restaurant.setOwnerId(request.getParameter("owner_id"));
         restaurant.setRestInfo(request.getParameter("restinfo"));
         UserBean user=new UserBean();
         user.setFirstName(request.getParameter("ownername"));
         user.setLastName(request.getParameter("ownersurname"));
         user.setUsername(request.getParameter("ownerusername"));
         user.setPassword(request.getParameter("ownerpassword"));
         user.setUEmail(request.getParameter("owneremail"));
         user.setUsrTel(request.getParameter("ownerphone"));
         
 
         user.setUserType(3);
         UserDAO.addRestaurantForm(restaurant);    
         UserDAO.register(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
