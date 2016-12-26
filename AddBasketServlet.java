package SangFood;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;





/**
 * Servlet implementation class AddBasketServlet
 */

public class AddBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBasketServlet() {
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
	try{
	if (session.getAttribute("currentSessionUser").equals(null)){
		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		
	}
    System.out.println(request.getParameterValues("foodid").length);
	String [] foodid = new String  [request.getParameterValues("foodid").length];
	System.out.println("1. adim");
	String [] restid = new String  [request.getParameterValues("restid").length];
	System.out.println("2. adim" );
	String [] price = new String  [request.getParameterValues("price").length];
	System.out.println("3. adim");
	foodid=request.getParameterValues("foodid");
	restid=request.getParameterValues("restid");
	price=request.getParameterValues("price");
	String username = (String) session.getAttribute("currentSessionUser");
	System.out.println(username);   
	OrdersBean order = new OrdersBean();
		/*int food_id= Integer.parseInt(request.getParameter("adress"));
		String price= request.getParameter("price");
		int restid = Integer.parseInt(request.getParameter("restid"));*/
		//System.out.println(username +  " asd" + restid );
		//response.sendRedirect("index.jsp"); 
   
          for ( int i = 0 ;i<request.getParameterValues("foodid").length; i++) {
        	  
        	  order.setFoodId(Integer.parseInt(foodid[i]));
        	  System.out.println("4. adim");
        	  order.setRestId(Integer.parseInt(restid[i]));
        	  System.out.println("5. adim");
        	  order.setPrice(price[i]);
        	  System.out.println("6. adim");
        	  UserDAO.addBasket(order,username);
        	  System.out.println("7. adim");
          }
       //   UserDAO.addBasket(orders,(String) session.getAttribute("currentSessionUser"));
    /*   orders.setFoodId(food_id);
        orders.setUserName(username);
        orders.setPrice(price);
        orders.setRestId(restid);
        UserDAO.addBasket(orders);  */
        request.getRequestDispatcher("customerLogged.jsp").forward(request, response);
	}catch (NullPointerException e) {
        System.out.print("Caught the NullPointerException");
        request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
