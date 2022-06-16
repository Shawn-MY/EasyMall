package com.po;

public class UserRegist {
	@Override
	public String toString() {
		return "UserRegist [id=" + id + ", username=" + username
				+ ", password=" + password + ", password2=" + password2
				+ ", nickname=" + nickname + ", email=" + email + "]";
	}
	private int id;
	private String username;
	private String password;
	private String password2;
	private String nickname;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
