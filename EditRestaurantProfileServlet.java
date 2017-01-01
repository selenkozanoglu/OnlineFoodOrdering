package SangFood;

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

public class EditRestaurantProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public EditRestaurantProfileServlet() {
        super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession(true);
        String newrestAdress = request.getParameter("NewAddress");
        String newrestInfo = request.getParameter("NewRestInfo");
        String newphone=request.getParameter("NewTel");
        

      System.out.println(session.getAttribute("currentSessionUser"));
      String ownerid = (String) session.getAttribute("currentSessionUser");
        //String ownerid ="gamze";
        System.out.println("servlete access" + ownerid);
        UserDAO.EditRestaurantProfile(newrestAdress,newrestInfo,newphone,ownerid);
        
        System.out.println("successful");
        request.setAttribute("message", "user information Succesfuly Changed");
RequestDispatcher rd = request.getRequestDispatcher("EditRestaurantProfile.jsp");
        //response.sendRedirect("login.jsp");
        rd.forward(request, response);
        }

/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // TODO Auto-generated method stub                doGet(request, response);

}
}
