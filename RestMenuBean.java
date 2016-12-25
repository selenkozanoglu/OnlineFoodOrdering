package SangFood;

public class RestMenuBean {
	private int restaurant_id;
	private String food_name;
	private String food_type;
	private String price;
	private int food_id;
	
	public int getRestaurantId(){
		return restaurant_id;
	}
	public void setRestaurantId(int  newrestaurant_id){
		restaurant_id=newrestaurant_id;
	}
	public String getFoodName(){
		return food_name;
	}
	public void setFoodName(String  newFoodName){
		food_name=newFoodName;
	}
	public String getFoodType(){
		return food_type;
	}
	public void setfoodType(String  newFoodType){
		food_type=newFoodType;
	}
	public String getPrice(){
		return price;
	}
	public void setPrice(String  newPrice){
		price=newPrice;
	}
public int getFoodId(){
	return food_id;
}
public void setFoodId(int newFoodId){
	food_id=newFoodId;
}
}
