package SangFoodproject;

public class EditProfileBean {
private String Firstname;
private String Lastname;
private String Email;
private String Address;
private int PhoneNum;
private String Username;
private String Password;

public String getFirstname(){
    return Firstname;
}
public void setFirstname(String Firstname){
    this.Firstname=Firstname;
}

public String getLastname(){
    return lastname;
}
public void setLastname(String newLastname){
    this.Lastname=Lastname;
}
public String getPassword(){
    return Password;
}
public void setPassword(String Password){
  this.Password=Password;
}
public String getUsername(){
    return Username;
}
public void setUsername(String Username){
  this.Username=Username;
}
public String getEmail(){
    return Email;
}
public void setEmail(String Email){
    this.Email=Email;
}
public String getAddress(){
    return Address;
}
public void setAddress(String Address){
    this.Address=Address;
}


public int getPhoneNum(){
    return PhoneNum;
}
public void setPhoneNum(int PhoneNum){
    this.PhoneNum=PhoneNum;
}


}
