package SangFood;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import SangFood.ConnectionManager;
import SangFood.UserBean;


public class UserDAO {
	static Connection currentCon=null;
	static ResultSet rs=null;
	
	public static UserBean login(UserBean bean){
		
		//preparing some objects for connection
		Statement stmt=null;
		
		String username=bean.getUsername();
		String password=bean.getPassword();
		
		String searchQuery="select * from users where username="+"'"+username+"'"+" AND password="+password+"";
		
		System.out.println("Your username is"+username);
		System.out.println("Your password is"+password);
		System.out.println("Query:"+searchQuery);
		
		try{
			//connect to DB
			currentCon=ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(searchQuery);
			rs=stmt.executeQuery(searchQuery);
			boolean more=rs.next();
			
			//if user does not exist set the isValid variable false
			if(!more){
				System.out.println("Sorry, you are not registered user! Please sign up first");
				bean.setValid(false);
			}
			
			//if user exists set the isValid variable to true
			else if(more){
				String firstName=rs.getString("firstName");
				String  lastName=rs.getString("lastName");
				int user_type=rs.getInt("user_type");
				
				System.out.println("Welcome"+firstName);
				System.out.println("Welcome"+user_type);
				
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setUserType(user_type);
				bean.setValid(true);
			
			}}
		catch(Exception ex){
			System.out.println("Log in failed:An Exception has occured!"+ex);
			
		}
		
		//some exception handling
		finally{
			if(rs!=null){
				try{
					rs.close();
				} catch(Exception e){}
				rs=null;
			}
			if(stmt!=null){
				try{
					stmt.close();
					
				}catch(Exception e){}
				stmt=null;
			}
			if(currentCon!=null){
				try{
					currentCon.close();
				}catch(Exception e){
					
				}
				currentCon=null;
			}
			
		}
		return bean;
			
		
		
	}
public static Boolean register (UserBean user){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "INSERT INTO users ( user_type,password,u_email,firstName,lastName,username,user_address,usrtel,user_city,user_place) values (? , ? , ?, ? ,? , ? , ?, ?,?,?)";
			try {
				stmt = currentCon.prepareStatement(updateQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				//stmt.setString(1, "73");
				stmt.setInt(1, user.getUserType());
				stmt.setString(2, user.getPassword());
				stmt.setString(3, user.getu_email());
				stmt.setString(4, user.getFirstName()); 
				stmt.setString(5, user.getLastName());
				stmt.setString(6, user.getUsername());
				stmt.setString(7, user.getUserAddress());
				stmt.setString(8, user.getUsrTel());
				stmt.setString(9, user.getUserCity());
				stmt.setString(10,user.getUserPlace());
				int i = stmt.executeUpdate();
				if (i > 0 ) user.setValid(true);
				else user.setValid(false);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return user.valid;
	}
	public static void ChangePassword (String newpassword,String username){ 
		
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update users set password=? where username =?";
				
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.setString(1,newpassword);
			stmt.setString(2,username);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
	public static void addRestaurant(RestaurantBean restaurant){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String insertQuery = "INSERT INTO restaurants (rid,rest_address,rest_name,owner_id,status) values (? , ? , ?,?,?)";
		
		try {
			stmt = currentCon.prepareStatement(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1, "13");
			stmt.setString(2, restaurant.getRestAddress());
			stmt.setString(3, restaurant.getRestName());
			stmt.setString(4, restaurant.getOwnerId());
			stmt.setString(5, "1");
			
		    stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
	}
	
	
	public static void deleteRestaurant(String rest_id){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "delete from restaurants where rid=?";
		
			try {
				stmt = currentCon.prepareStatement(updateQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                            try {
				stmt.setString(1, rest_id);
				stmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void addRestaurantForm(RestaurantBean restaurant){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String insertQuery = "INSERT INTO restaurants (rid,rest_address,rest_name,owner_id,rest_info,status) values (? , ? , ?,?,?,?)";
		
		try {
			stmt = currentCon.prepareStatement(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1, "14");
			stmt.setString(2, restaurant.getRestAddress());
			stmt.setString(3, restaurant.getRestName());
			stmt.setString(4, restaurant.getOwnerId());
			stmt.setString(5, restaurant.getRestInfo());
			stmt.setString(6, "0");
			
		    stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
	
	}
	public static void EditProfile(String newlastname,String newemail,String newaddress,String newphonenumber,String newcity,String newplace,String username){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update users set u_email=?,lastName=?,user_address=?,usrtel=?,user_city=?,user_place=? where username =?";
				
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.setString(1,newemail);
			stmt.setString(2,newlastname);
			stmt.setString(3, newaddress);
			stmt.setString(4, newphonenumber);
            stmt.setString(5,newcity);
            stmt.setString(6, newplace);
			stmt.setString(7, username);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void addBasket(OrdersBean order,String username){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		   Calendar calendar = Calendar.getInstance();
		    java.sql.Timestamp ourJavaDateObject = new java.sql.Timestamp(calendar.getTime().getTime());
		
		String insertQuery = "INSERT INTO orders (rest_id,user_id,food_id,order_sum,order_date,order_status) values (? , ? , ?,?,?,?)";
		
		try {
			stmt = currentCon.prepareStatement(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	
			//stmt.setInt(1, order.getRestId());
			stmt.setInt(1, order.getRestId());
			stmt.setString(2, username);
			stmt.setInt(3, order.getFoodId());
	
			stmt.setString(4, order.getPrice());
			stmt.setTimestamp(5,ourJavaDateObject);
			stmt.setInt(6, 0);
		    stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public static void setRest(String rid,int status){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update restaurants set status=? where rid =?";
			
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.setInt(1,status);
			stmt.setString(2,rid);
			
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void setOrder(int order_id){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update orders set order_status=? where order_id =?";
			
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.setInt(1,1);
			stmt.setInt(2,order_id);
			
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	public static String GetRestaurantId(String username){
		PreparedStatement stmt=null;
       String rid="";
		String restaurantIdQuery= "select rid from restaurants r1,users u1 where u1.user_id = r1.owner_id AND username = ?";
	
		try{
			//connect to DB
			currentCon=ConnectionManager.getConnection();
			stmt = currentCon.prepareStatement(restaurantIdQuery);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			rs = stmt.executeQuery();
			while (rs.next())
			
			rid=rs.getString("rid");
			
			
	}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return rid;
	}
	public static void AddFood(RestMenuBean menu,int restaurant_id){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String insertQuery = "INSERT INTO rest_foods (restaurant_id,food_name,food_type,price) values (? , ? , ?,?)";
	  
		try {
			stmt = currentCon.prepareStatement(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setInt(1,restaurant_id);
			stmt.setString(2, menu.getFoodName());
			stmt.setString(3, menu.getFoodType());
			stmt.setString(4, menu.getPrice());
	
			
		    stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		
	}
}

