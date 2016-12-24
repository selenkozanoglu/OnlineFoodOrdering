package SangFood;

public class OrdersBean {
private int order_id;
private int rest_id;
private String userName;
private int food_id;
private String price;

public int getOrderId(){
	return order_id;
}
public void setOrderId(int newOrderId){
	order_id=newOrderId;

}
public int getRestId(){
	return rest_id;
}
public void setRestId(int newRestId){
	rest_id=newRestId;

}
public String getuserName(){
	return userName;
}
public void setUserName(String newUserName){
	userName=newUserName;

}
public int getFoodId(){
	return food_id;
}
public void setFoodId(int newFoodId){
	food_id=newFoodId;

}
public String getPrice(){
	return price;
}
public void setPrice(String newPrice){
	price=newPrice;

}
}
