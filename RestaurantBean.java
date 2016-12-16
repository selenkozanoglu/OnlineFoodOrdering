package SangFood;

public class RestaurantBean {
	private int rid;
	private String rest_address;
	private String rest_name;
	private String owner_id;
	
	public int getRid(){
		return rid;
	}
	public void setRid(int newRid){
		rid=newRid;
	}
	public String getRestAddress(){
		return rest_address;
	}
	public void setRestAddress(String newRestAddress){
		rest_address=newRestAddress;
	
	}
	public String getRestName(){
		return rest_name;
	}
	public void setRestName(String newRestName){
		rest_name=newRestName;
	
	}
	public String getOwnerId(){
		return owner_id;
	}
	public void setOwnerId(String newOwnerId){
		owner_id=newOwnerId;
	
	}
	
}
