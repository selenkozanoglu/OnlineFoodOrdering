package SangFoodproject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSearch
 */

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		//HttpSession session = request.getSession(true);
		
		
		
	   //response.setContentType("search");
	   //System.out.println(session.getAttribute("currentSessionUser"));
		//String restname = (String) session.getAttribute("currentSessionUser");
		//String userid ="selo";
		//System.out.println("servlete access" + restname);
		//UserDAO.Search(restname);
	   
		/* String text = request.getParameter("text");
         String search1 = request.getParameter("search");
         user u = new user();
         
         if(search1.equals("rest_name"))
         {
             String message = u.searchResult(text);
             
             if(message.equals("notFound")) {
                 out.print("No restaurant is founded");
                
             }else
             {
            	 UserDAO.Search(rest_name);
                 response.sendRedirect("index.jsp?rest_name="+message);
                 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
         		//response.sendRedirect("login.jsp");
         		rd.forward(request, response);
             }
         }*/
		
		
		String rest_name=request.getParameter("search");
		UserDAO.Search(rest_name);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		if(!rest_name.equals("search")){
			System.out.print("not found");
		}
		//response.sendRedirect("login.jsp");
		rd.forward(request, response);
		}
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
}
