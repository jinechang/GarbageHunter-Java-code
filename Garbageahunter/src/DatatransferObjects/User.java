package DatatransferObjects;

import java.util.Date;

public class User {

	private String userName;
	private String password;
	private Date registerDate;
	
	public User(){};
	public User(String username){
		this.userName = username;
	};
	
	public void setUserName(String username){
		this.userName = username;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setRegisterDate(Date date){
		this.registerDate = date;
	}
	
	public Date getRegisterDate(){
		return this.registerDate;
	}
	
	
	
}
