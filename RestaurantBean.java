package SangFood;

public class RestaurantBean {
	private String rid;
	private String rest_address;
	private String rest_name;
	private String owner_id;
	private String rest_info;
	private int status;
	
	public String getRid(){
		return rid;
	}
	public void setRid(String newRid){
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
	public String getRestInfo(){
		return rest_info;
	}
	public void setRestInfo(String newRestInfo){
		rest_info=newRestInfo;
	
	}
	public int getStatus(){
		return status;
	}
	public void setStatus(int newStatus){
		status=newStatus;
	
	}
	
	
}
