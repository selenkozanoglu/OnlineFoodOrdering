package SangFoodproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.resource.spi.ConnectionManager;
import SangFoodproject.ConnectionManager;

public class UserDAO {

	static Connection currentCon=null;
	static ResultSet rs=null;
	private static Object currentCon2;
	
	public static UserBean login(UserBean bean){
		
		//preparing some objects for connection
		Statement stmt=null;
		
		String username=bean.getUsername();
		String password=bean.getPassword();
		
		String searchQuery="select * from users where username="+"'"+username+"'"+" AND password="+password+"";
		
		System.out.println("Your name is"+username);
		System.out.println("Your password is"+password);
		System.out.println("Query:"+searchQuery);
		
		try{
			//connect to DB
			currentCon=ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
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

	public static void  EditProfile(String newlastname,String newemail,String newaddress,String newphonenumber,String username){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update users set  u_email=?,lastName=?,user_address=?,usrtel=? where username =?";
		
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
			stmt.setString(5, username);
			
			
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void Search(String rest_name) throws SQLException {
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String SearchQuery="SELECT*FROM Restaurants WHERE rest_name LIKE ?";
		
		try {
			stmt = currentCon.prepareStatement(SearchQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
		
	   java.sql.ResultSet result=stmt.executeQuery();
		result.getString(rest_name);
		}
		
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
}
	}
