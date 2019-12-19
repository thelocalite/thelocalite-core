package core.entities.Actors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private boolean isActive;
	
	private String address;
	
	private String imageUrl;
	
	private String phoneNumber;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String userName, String email, String password, boolean isActive, String address,
			String imageUrl, String phoneNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.address = address;
		this.imageUrl = imageUrl;
		this.phoneNumber = phoneNumber;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
