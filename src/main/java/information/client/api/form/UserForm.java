package information.client.api.form;

public class UserForm {
	private String userId ;
	
	private String userPw ;
	
	private String token ; 

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	} 
	
	@Override
	public String toString() {
		return "[UserForm userId=" + userId + " userPw=" + userPw +" userToken=" + token + "]";  
	}
	
}
