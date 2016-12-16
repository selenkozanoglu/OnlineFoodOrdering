package SangFood;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;



/**
 * Servlet implementation class AddRestaurantServlet
 */
//@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
		      HTTPException session =null;
              RestaurantBean restaurant=new RestaurantBean();
              restaurant.setRestAddress(request.getParameter("restAddress"));
              restaurant.setRestName(request.getParameter("RestName"));
              restaurant.setOwnerId(request.getParameter("oid"));
              UserDAO.addRestaurant(restaurant);      
      }	
      
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
