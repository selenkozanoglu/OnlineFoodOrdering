package SangFood;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditMenuServlet
 */
@WebServlet("/EditMenuServlet")
public class AddFoodToMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFoodToMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		
		 RestMenuBean menu=new RestMenuBean();
          menu.setFoodName(request.getParameter("foodname"));
          menu.setfoodType(request.getParameter("foodtype"));
          menu.setPrice(request.getParameter("price"));
          String username = (String) session.getAttribute("currentSessionUser");
          String rest_Id=UserDAO.GetRestaurantId(username);
          System.out.println(rest_Id);
          int rid = Integer.parseInt(rest_Id);
          System.out.println(rid);
          UserDAO.AddFood(menu,rid);
          request.setAttribute("message", "Food has been added into menu");
          RequestDispatcher rd = request.getRequestDispatcher("EditMenu.jsp");
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
