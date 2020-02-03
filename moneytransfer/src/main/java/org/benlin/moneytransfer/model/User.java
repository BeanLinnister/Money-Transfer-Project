package org.benlin.moneytransfer.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private long userId;
	private String username;
	
	public User() {
		
	}
	
	public User(long userId, String username) {
		this.userId = userId;
		this.username = username;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
