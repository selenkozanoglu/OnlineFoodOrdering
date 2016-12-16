package SangFood;


public class UserBean {
private  int user_id;
private String firstName;
private String lastName;
private String password;
private String u_email;
private String username;
private String uaddress;
private int user_type;
private String usrtel;
public boolean valid;

public int getUserId(){
	return user_id;
}
public void setUserId(int newUserId){
	user_id=newUserId;
}
public String getFirstName(){
	return firstName;
}
public void setFirstName(String newFirstName){
	firstName=newFirstName;
}

public String getLastName(){
	return lastName;
}
public void setLastName(String newLastName){
	lastName=newLastName;
}
public String getPassword(){
	return password;
}
public void setPassword(String newPassword){
	password=newPassword;
}
public String getUsername(){
	return username;
}
public void setUsername(String newUsername){
	username=newUsername;
}
public String getu_email(){
	return u_email;
}
public void setUEmail(String newUserEmail){
	u_email=newUserEmail;
}
public String getUserAddress(){
	return uaddress;
}
public void setUAddress(String newUserAddress){
	uaddress=newUserAddress;
}
public boolean isValid(){
	return valid;
}
public void setValid(boolean newValid){
	valid=newValid;
}
public int getUserType(){
	return user_type;
}
public void setUserType(int newUserType){
	user_type=newUserType;
}
public String getUsrTel(){
	return usrtel;
}
public void setUsrTel(String newusrtel){
	usrtel=newusrtel;
}
}
